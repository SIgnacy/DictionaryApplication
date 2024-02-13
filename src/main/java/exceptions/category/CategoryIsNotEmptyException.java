package exceptions.category;

import exceptions.CustomException;

public class CategoryIsNotEmptyException extends CustomException {
    private final String category;

    public CategoryIsNotEmptyException(String category) {
        this.category = category;
    }

    @Override
    public String getMessage() {
        return "Category \"" + category + "\" is not empty.";
    }
}
