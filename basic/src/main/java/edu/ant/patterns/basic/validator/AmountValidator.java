package edu.ant.patterns.basic.validator;

import java.math.BigDecimal;

public class AmountValidator implements IValidator {

    private static final BigDecimal MAX = BigDecimal.TEN;
    private static final BigDecimal MIN = BigDecimal.ONE;

    @Override
    public boolean validate(Transaction transaction) {
        BigDecimal amount = transaction.getAmount();
        return (amount.compareTo(MAX) >= 0 || amount.compareTo(MIN) <= 0);
    }

}
