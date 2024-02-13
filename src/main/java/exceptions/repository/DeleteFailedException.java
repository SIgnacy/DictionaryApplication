package exceptions.repository;

import exceptions.CustomException;

public class DeleteFailedException extends CustomException {

    @Override
    public String getMessage() {
        return "Failed to delete.";
    }
}
