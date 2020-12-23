package edu.ant.patterns.basic.exception;

public class NoSuchConstructorException extends NoSuchMethodException{

    public NoSuchConstructorException(String s) {
        super(s);
    }

}
