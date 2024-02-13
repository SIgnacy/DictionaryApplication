package command.category;

import command.Command;
import command.category.handlers.CategoryDoesNotExistHandler;
import command.category.handlers.CategoryHandler;
import command.category.handlers.CategoryTooLongHandler;
import exceptions.CustomException;
import exceptions.command.FailedToExecuteCommandException;
import repository.Repository;

public class UpdateCategoryCommand implements Command {
    private final Repository<Category> categoryRepository;
    private final Category categoryToUpdate;
    private final String newName;

    public UpdateCategoryCommand(Repository<Category> categoryRepository, Category categoryToUpdate, String newName) {
        this.categoryRepository = categoryRepository;
        this.categoryToUpdate = categoryToUpdate;
        this.newName = newName;
    }

    @Override
    public String execute() throws CustomException{

        CategoryHandler handler = new CategoryTooLongHandler();
            handler.setNextHandler(new CategoryDoesNotExistHandler(categoryRepository));

        if(handler.handle(newName)) {
            String oldName = categoryToUpdate.getName();
            categoryToUpdate.setName(newName);
            return "Updated category \"" + oldName + "\" to \"" + newName + "\".";
        }
        throw new FailedToExecuteCommandException();
    }

    @Override
    public boolean shouldExitCommandLine() {
        return false;
    }


}
