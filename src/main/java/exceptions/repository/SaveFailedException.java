package exceptions.repository;

import exceptions.CustomException;

public class SaveFailedException extends CustomException {

    @Override
    public String getMessage() {
        return "Failed to save.";
    }
}
