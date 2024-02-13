package controller;

import command.Command;
import command.commandDraft.CommandDraft;
import command.commandFactory.CommandFactory;
import exceptions.CustomException;
import logger.Logger;

import java.util.Scanner;

public class CommandLine {
    private boolean run = true;
    private final Logger log;
    private final Scanner scanner;
    private final CommandFactory commandFactory;

    public CommandLine(Scanner scanner, CommandFactory commandFactory, Logger log) {
        this.scanner = scanner;
        this.log = log;
        this.commandFactory = commandFactory;
    }

    public void run() {
        while (run) {
            try {
                log.info("input:");
                Command command = commandFactory.create(
                        new CommandDraft(
                                scanner.nextLine()));
                log.info(command.execute());
                stop(command);
            } catch(CustomException e){
                log.error(e.getMessage());
            }
        }
    }

    public void stop(Command command) {
        if(command.shouldExitCommandLine())
            run = false;
    }
    public boolean isRunning(){
        return run;
    }
}