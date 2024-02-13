package command.category;

import command.Command;
import command.category.handlers.CategoryDoesNotExistHandler;
import command.category.handlers.CategoryHandler;
import command.category.handlers.CategoryTooLongHandler;
import exceptions.CustomException;
import exceptions.command.FailedToExecuteCommandException;
import repository.Repository;

public class AddCategoryCommand implements Command {
    private final Repository<Category> categoryRepository;
    private final String categoryName;

    public AddCategoryCommand(Repository<Category> categoryRepository, String categoryName) {
        this.categoryRepository = categoryRepository;
        this.categoryName = categoryName;
    }

    @Override
    public String execute() throws CustomException {
        CategoryHandler handler = new CategoryTooLongHandler();
        handler.setNextHandler(new CategoryDoesNotExistHandler(categoryRepository));

        if(handler.handle(categoryName)){
            categoryRepository.save(new Category(categoryName));
            return "Added category \"" + categoryName + "\".";
        }
        throw new FailedToExecuteCommandException();
    }

    @Override
    public boolean shouldExitCommandLine() {
        return false;
    }
}
