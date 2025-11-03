package com.bankingApp.Banking.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountDto {
    private Long id;
    private String accountHolderName;
    private String accountNumber;
    private Double balance;
}