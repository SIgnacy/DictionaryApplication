package exceptions.command;

import exceptions.CustomException;

public class FailedToExecuteCommandException extends CustomException {
    @Override
    public String getMessage() {
        return "Failed to execute command.";
    }
}
