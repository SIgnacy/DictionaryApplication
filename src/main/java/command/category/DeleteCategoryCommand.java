package command.category;

import command.Command;
import command.category.handlers.CategoryHandler;
import command.category.handlers.CategoryIsEmptyHandler;
import command.term.Term;
import exceptions.CustomException;
import exceptions.command.FailedToExecuteCommandException;
import repository.Repository;

public class DeleteCategoryCommand implements Command {
    private final Repository<Category> categoryRepository;
    private final Repository<Term> termRepository;
    private final Category categoryToDelete;

    public DeleteCategoryCommand(Repository<Category> categoryRepository, Repository<Term> termRepository, Category categoryToDelete) {
        this.categoryRepository = categoryRepository;
        this.termRepository = termRepository;
        this.categoryToDelete = categoryToDelete;
    }

    @Override
    public String execute() throws CustomException {
        CategoryHandler handler = new CategoryIsEmptyHandler(termRepository);

        if(handler.handle(categoryToDelete.getName())){
            String message = "Deleted category \"" + categoryToDelete.getName() + "\".";
            categoryRepository.delete(categoryToDelete);
            return message;
        }
        throw new FailedToExecuteCommandException();
    }

    @Override
    public boolean shouldExitCommandLine() {
        return false;
    }
}
