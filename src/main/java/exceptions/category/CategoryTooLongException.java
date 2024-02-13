package exceptions.category;

import command.category.Category;
import exceptions.CustomException;

public class CategoryTooLongException extends CustomException {
    @Override
    public String getMessage() {
        return "Category name is too long (max allowable size is " + Category.CATEGORY_MAX_SIZE + " characters).";
    }
}
