package com.Backend.backend.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.Backend.backend.Wallet;
import com.Backend.backend.Dao.WalletDao;
import com.Backend.backend.Exception.ResourceNotFoundException;

@Service
public class WalletService {
    @Autowired
    WalletDao walletDao;

    // private Wallet user1;

    public Optional<Wallet> getDetails(Integer id) {
        return walletDao.findById(id);
    }

    public boolean withdraw(Integer id, Integer amount) {
        if (getDetails(id) == null) {
            return false;
        }
        // System.out.println(user.get().getAmount());
        Wallet user = getDetails(id).orElseThrow(() -> new ResourceNotFoundException("User Not Found"));
        Integer currentBal = user.getAmount();

        if (currentBal > amount) {
            currentBal -= amount;
            user.setAmount(currentBal);
            user.setName(user.getName());
            user.setEmail(user.getEmail());
            user.setId(id);
            walletDao.save(user);
            return true;
        }
        return false;
    }

    public ResponseEntity<Wallet> addUser(Wallet w) {
        Wallet user = walletDao.save(w);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    public Integer deposit(Integer id, Integer amount) {
        // System.out.println(user.get().getAmount());
        Wallet user = getDetails(id).orElseThrow(() -> new ResourceNotFoundException("User Not Found"));
        Integer currentBal = user.getAmount();
        currentBal += amount;
        user.setAmount(currentBal);
        user.setName(user.getName());
        user.setEmail(user.getEmail());
        user.setId(id);
        walletDao.save(user);
        return currentBal;

    }
}
