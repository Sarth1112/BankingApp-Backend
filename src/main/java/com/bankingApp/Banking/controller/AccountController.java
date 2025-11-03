package com.bankingApp.Banking.controller;


import com.bankingApp.Banking.dto.AccountDto;
import com.bankingApp.Banking.dto.TransactionDto;
import com.bankingApp.Banking.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/accounts")
@CrossOrigin(origins = "${allowed.origins}")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    // Create Account
    @PostMapping
    public ResponseEntity<AccountDto> createAccount(@RequestBody AccountDto accountDto) {
        AccountDto createdAccount = accountService.createAccount(accountDto);
        return new ResponseEntity<>(createdAccount, HttpStatus.CREATED);
    }

    // Get Account by ID
    @GetMapping("/{id}")
    public ResponseEntity<AccountDto> getAccountById(@PathVariable Long id) {
        AccountDto accountDto = accountService.getAccountById(id);
        return ResponseEntity.ok(accountDto);
    }

    // Deposit
    @PutMapping("/deposit")
    public ResponseEntity<AccountDto> deposit(@RequestBody TransactionDto transactionDto) {
        AccountDto accountDto = accountService.deposit(transactionDto);
        return ResponseEntity.ok(accountDto);
    }

    // Withdraw
    @PutMapping("/withdraw")
    public ResponseEntity<AccountDto> withdraw(@RequestBody TransactionDto transactionDto) {
        AccountDto accountDto = accountService.withdraw(transactionDto);
        return ResponseEntity.ok(accountDto);
    }

    // Get All Accounts
    @GetMapping
    public ResponseEntity<List<AccountDto>> getAllAccounts() {
        List<AccountDto> accounts = accountService.getAllAccounts();
        return ResponseEntity.ok(accounts);
    }

    // Delete Account
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> deleteAccount(@PathVariable Long id) {
        accountService.deleteAccount(id);
        return ResponseEntity.ok(Map.of("message", "Account deleted successfully"));
    }
}