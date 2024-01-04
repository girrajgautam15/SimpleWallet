package com.Backend.backend.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.Backend.backend.Wallet;
import com.Backend.backend.Service.WalletService;

@RestController
@RequestMapping("{id}")
@CrossOrigin(origins = "http://localhost:4200")
public class WalletController {
    @Autowired
    WalletService walletService;

    @GetMapping("home")
    public String home() {

        return "Hello World";

    }

    @GetMapping("/user")
    public Optional<Wallet> getDetails(@PathVariable Integer id) {
        return walletService.getDetails(id);
    }

    @PutMapping("/withdraw/{amount}")

    public String withdraw(@PathVariable Integer id,
            @PathVariable Integer amount) {
        boolean flag = walletService.withdraw(id, amount);
        if (flag == true) {
            return "Withdrawn";
        }
        return "Amount not sufficient";
    }

    @PutMapping("/deposit/{amount}")

    public String deposit(@PathVariable Integer id, @PathVariable Integer amount) {
        Integer current = walletService.deposit(id, amount);
        return "Current Balance =" + current;
    }
}
