package edu.ant.patterns.design.command;


public interface Command {

    void execute();

    void rollback();
}
