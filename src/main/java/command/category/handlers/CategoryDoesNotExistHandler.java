package command.category.handlers;

import command.category.Category;
import exceptions.CustomException;
import exceptions.category.CategoryAlreadyExistException;
import repository.Repository;

public class CategoryDoesNotExistHandler extends CategoryHandler {

    private final Repository<Category> categoryRepository;
    public CategoryDoesNotExistHandler(Repository<Category> categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public boolean handle(String categoryName) throws CustomException {
        if (categoryRepository.findBy(categoryName).isPresent()) {
            throw new CategoryAlreadyExistException(categoryName);
        }
        return handleNext(categoryName);
    }
}
