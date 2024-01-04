package com.Backend.backend.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Backend.backend.Wallet;
import com.Backend.backend.Service.WalletService;

@RestController
// @RequestMapping("/add")
@CrossOrigin(origins = "http://localhost:4200")
public class AddUser {
    @Autowired
    WalletService walletService;

    @PostMapping("add")
    public ResponseEntity<Wallet> addUser(@RequestBody Wallet w) {
        return walletService.addUser(w);
        // return "User added Successfully";
    }

}
