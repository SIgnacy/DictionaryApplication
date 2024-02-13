package exceptions.term;

import exceptions.CustomException;

public class TermAlreadyExistException extends CustomException {
    private final String term;
    private final String category;

    public TermAlreadyExistException(String term, String category) {
        this.term = term;
        this.category = category;
    }

    @Override
    public String getMessage() {
        return "Term \"" + term + "\" already exists in category \"" + category + "\".";
    }
}
