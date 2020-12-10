package edu.ant.patterns.design.command;

import java.util.LinkedList;
import java.util.List;


public class Executor {

    private final List<Command> executedCommands;

    public Executor() {
        executedCommands = new LinkedList<>();
    }

    public void execute(Command command) {
        command.execute();
        executedCommands.add(command);
    }

    public void rollback() {
        Command command = executedCommands.get(executedCommands.size() - 1);
        command.rollback();
        executedCommands.remove(command);
    }

}
