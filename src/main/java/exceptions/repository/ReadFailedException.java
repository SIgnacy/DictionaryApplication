package exceptions.repository;

import exceptions.CustomException;

public class ReadFailedException extends CustomException {

    @Override
    public String getMessage() {
        return "Failed to read.";
    }
}
