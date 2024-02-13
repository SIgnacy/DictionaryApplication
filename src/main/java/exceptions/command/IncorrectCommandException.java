package exceptions.command;

import exceptions.CustomException;

public class IncorrectCommandException extends CustomException {

    @Override
    public String getMessage() {
        return "Incorrect input.\nType \"help\" to display information about commands.";
    }
}
