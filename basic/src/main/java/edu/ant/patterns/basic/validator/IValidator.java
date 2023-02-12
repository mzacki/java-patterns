package edu.ant.patterns.basic.validator;

/**
 * Hungarian notation used - controversial.
 * Linus Torvalds spoke against it (compiler knows the type nevertheless, it confuses developer).
 * Robert C. Martin spoke against it (confuses the reader / user, why to leak implementation details (e.g. types) to business user, etc.)
 * */
public interface IValidator {

    boolean validate(Transaction transaction);

}
