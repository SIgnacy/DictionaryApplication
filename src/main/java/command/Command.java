package command;

import exceptions.CustomException;

public interface Command {
    String execute() throws
            CustomException;

    boolean shouldExitCommandLine();
}
