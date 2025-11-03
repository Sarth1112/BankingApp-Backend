package com.bankingApp.Banking.mapper;


import com.bankingApp.Banking.dto.AccountDto;
import com.bankingApp.Banking.entity.Account;

public class AccountMapper {

    public static Account mapToAccount(AccountDto accountDto) {
        Account account = new Account();
        account.setId(accountDto.getId());
        account.setAccountHolderName(accountDto.getAccountHolderName());
        account.setAccountNumber(accountDto.getAccountNumber());
        account.setBalance(accountDto.getBalance());
        return account;
    }

    public static AccountDto mapToAccountDto(Account account) {
        AccountDto accountDto = new AccountDto();
        accountDto.setId(account.getId());
        accountDto.setAccountHolderName(account.getAccountHolderName());
        accountDto.setAccountNumber(account.getAccountNumber());
        accountDto.setBalance(account.getBalance());
        return accountDto;
    }
}