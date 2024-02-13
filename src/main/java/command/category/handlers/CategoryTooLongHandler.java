package command.category.handlers;

import command.category.Category;
import exceptions.CustomException;
import exceptions.category.CategoryTooLongException;

public class CategoryTooLongHandler extends CategoryHandler {

    @Override
    public boolean handle(String categoryName) throws CustomException {
        if (categoryName.length() > Category.CATEGORY_MAX_SIZE) {
            throw new CategoryTooLongException();
        }
        return handleNext(categoryName);
    }
}
