package com.Backend.backend.Dao;

// import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Backend.backend.Wallet;

@Repository
public interface WalletDao extends JpaRepository<Wallet, Integer> {

}
