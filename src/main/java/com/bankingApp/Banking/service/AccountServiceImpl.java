package com.bankingApp.Banking.service;


import com.bankingApp.Banking.dto.AccountDto;
import com.bankingApp.Banking.dto.TransactionDto;
import com.bankingApp.Banking.entity.Account;
import com.bankingApp.Banking.mapper.AccountMapper;
import com.bankingApp.Banking.repository.AccountRepository;
import com.bankingApp.Banking.service.AccountService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class AccountServiceImpl implements AccountService {


    private final AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public AccountDto createAccount(AccountDto accountDto) {
        //Converting DTO to DB connected - Entity object
        Account account = AccountMapper.mapToAccount(accountDto);

        //Perform any operations
        // Generate unique account number
        account.setAccountNumber(generateAccountNumber());

        // Set initial balance to 0 if not provided
        if (account.getBalance() == null) {
            account.setBalance(0.0);
        }

        //Saving the account
        Account savedAccount = accountRepository.save(account);
        return AccountMapper.mapToAccountDto(savedAccount);
    }

    @Override
    public AccountDto getAccountById(Long id) {
        Account account = accountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Account not found with id: " + id));
        return AccountMapper.mapToAccountDto(account);
    }

    @Override
    public AccountDto deposit(TransactionDto transactionDto) {
        Account account = accountRepository.findByAccountNumber(transactionDto.getAccountNumber())
                .orElseThrow(() -> new RuntimeException("Account not found"));

        // Validate amount
        if (transactionDto.getAmount() <= 0) {
            throw new RuntimeException("Deposit amount must be greater than zero");
        }

        // Update balance
        double newBalance = account.getBalance() + transactionDto.getAmount();
        account.setBalance(newBalance);

        Account savedAccount = accountRepository.save(account);
        return AccountMapper.mapToAccountDto(savedAccount);
    }

    @Override
    public AccountDto withdraw(TransactionDto transactionDto) {
        Account account = accountRepository.findByAccountNumber(transactionDto.getAccountNumber())
                .orElseThrow(() -> new RuntimeException("Account not found"));

        // Validate amount
        if (transactionDto.getAmount() <= 0) {
            throw new RuntimeException("Withdrawal amount must be greater than zero");
        }

        // Check sufficient balance
        if (account.getBalance() < transactionDto.getAmount()) {
            throw new RuntimeException("Insufficient balance");
        }

        // Update balance
        double newBalance = account.getBalance() - transactionDto.getAmount();
        account.setBalance(newBalance);

        Account savedAccount = accountRepository.save(account);
        return AccountMapper.mapToAccountDto(savedAccount);
    }

    @Override
    public List<AccountDto> getAllAccounts() {
        List<Account> accounts = accountRepository.findAll();
        return accounts.stream()
                .map(AccountMapper::mapToAccountDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteAccount(Long id) {
        Account account = accountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Account not found"));
        accountRepository.delete(account);
    }

    // Helper method to generate unique account number
    private String generateAccountNumber() {
        return "ACC" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
    }
}
