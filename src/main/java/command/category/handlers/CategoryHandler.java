package command.category.handlers;

import exceptions.CustomException;

public abstract class CategoryHandler {
    private CategoryHandler next;


    public CategoryHandler setNextHandler(CategoryHandler next) {
        this.next = next;
        return next;
    }

    public abstract boolean handle(String categoryName) throws CustomException;

    protected boolean handleNext(String categoryName) throws CustomException {
        if (next == null)
            return true;

        return next.handle(categoryName);
    }
}