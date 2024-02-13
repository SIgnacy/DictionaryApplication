package exceptions.category;

import exceptions.CustomException;

public class CategoryAlreadyExistException extends CustomException {
    private final String categoryName;

    public CategoryAlreadyExistException(String catgoryName) {
        this.categoryName = catgoryName;
    }

    @Override
    public String getMessage() {
        return "Category \"" + categoryName + "\" already exist.";
    }
}
