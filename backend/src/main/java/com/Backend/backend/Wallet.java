package com.Backend.backend;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Wallet {
    @Id
    private Integer userId;
    private String name;
    private String email;
    private Integer amount;

    public Integer getId() {
        return this.userId;
    }

    public void setId(Integer id) {
        this.userId = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAmount() {
        return this.amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
