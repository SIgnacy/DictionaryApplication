package exceptions.term;

import exceptions.CustomException;

public class TermDoesNotExistException extends CustomException {
    private final String term;
    private final String category;

    public TermDoesNotExistException(String term, String category) {
        this.term = term;
        this.category = category;
    }


    @Override
    public String getMessage() {
        return "Term \"" + term + "\" with category \"" + category + "\" does not exist.";
    }
}
