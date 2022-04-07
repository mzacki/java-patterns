package edu.ant.patterns.basic.validator;

import java.math.BigDecimal;

public class Transaction {

    private Account sender;
    private BigDecimal amount;
    private Account receipient;


    public Account getSender() {
        return sender;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public Account getReceipient() {
        return receipient;
    }

}
