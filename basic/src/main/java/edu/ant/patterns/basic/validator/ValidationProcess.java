package edu.ant.patterns.basic.validator;

import java.util.List;

public class ValidationProcess implements IValidator {

    List<IValidator> validators;

    public boolean validate(Transaction transaction) {
       return validators.stream().map(v -> v.validate(transaction)).anyMatch(r -> r.equals(Boolean.FALSE));
    }

}
