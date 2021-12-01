package com.p54_g1.account_ms.controllers;

import com.p54_g1.account_ms.exceptions.AccountNotFoundException;
import com.p54_g1.account_ms.models.Account;
import com.p54_g1.account_ms.repositories.AccountRepository;
import org.springframework.web.bind.annotation.*;

@RestController
public class AccountController {

    private final AccountRepository accountRepository;

    public AccountController(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @GetMapping("/accounts/{username}")
    Account getAccount(@PathVariable String username) {
        return accountRepository.findById(username)
                .orElseThrow( () -> new AccountNotFoundException("No se encontró una cuenta con el username: " + username));
    }

    @PostMapping("/accounts")
    Account newAccount(@RequestBody Account account) {
        return accountRepository.save(account);
    }
}
