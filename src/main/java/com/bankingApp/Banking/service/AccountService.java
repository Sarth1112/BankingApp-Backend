package com.bankingApp.Banking.service;


import com.bankingApp.Banking.dto.AccountDto;
import com.bankingApp.Banking.dto.TransactionDto;

import java.util.List;

public interface AccountService {
    AccountDto createAccount(AccountDto accountDto);
    AccountDto getAccountById(Long id);
    AccountDto deposit(TransactionDto transactionDto);
    AccountDto withdraw(TransactionDto transactionDto);
    List<AccountDto> getAllAccounts();
    void deleteAccount(Long id);
}