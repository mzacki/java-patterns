package edu.ant.patterns.basic.validator;

public class AccountValidator implements IValidator {

    public boolean validate(Transaction transaction) {

        String senderAccount = transaction.getSender().getAccountNumber();
        String recipientAccount = transaction.getReceipient().getAccountNumber();

        return senderAccount.equals(recipientAccount);
    }

}
