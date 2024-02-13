package exceptions.category;

import exceptions.CustomException;

public class CategoryDoesNotExistException extends CustomException {

    private final String categoryName;

    public CategoryDoesNotExistException(String categoryName) {
        this.categoryName = categoryName;
    }

    @Override
    public String getMessage() {
        return "Category \"" + categoryName + "\" does not exist.";
    }
}
