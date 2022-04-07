package edu.ant.patterns.basic.validator;

import java.math.BigDecimal;

public class Account {

    private String accountNumber;
    private String currency;
    private BigDecimal balance;


    public String getAccountNumber() {
        return accountNumber;
    }

    public String getCurrency() {
        return currency;
    }

    public BigDecimal getBalance() {
        return balance;
    }

}
