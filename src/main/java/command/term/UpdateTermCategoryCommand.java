package command.term;

import command.Command;
import command.category.Category;
import exceptions.CustomException;

public class UpdateTermCategoryCommand implements Command {
    private final Term term;
    private final Category category;

    public UpdateTermCategoryCommand(Term term, Category category) {
        this.term = term;
        this.category = category;
    }

    @Override
    public String execute() throws CustomException {
        String message = "Changed category of term \"" + term.getTerm() + "\" from \"" + term.getCategoryName() + "\" to \"" + category.getName() + "\".";
        term.setCategory(category);
        return message;
    }

    @Override
    public boolean shouldExitCommandLine() {
        return false;
    }
}
