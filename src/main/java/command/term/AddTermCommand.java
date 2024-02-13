package command.term;

import command.Command;
import command.category.Category;
import command.term.handlers.DescriptionTooLongHandler;
import command.term.handlers.TermDoesNotExistHandler;
import command.term.handlers.TermHandler;
import command.term.handlers.TermTooLongHandler;
import exceptions.CustomException;
import exceptions.command.FailedToExecuteCommandException;
import repository.Repository;

public class AddTermCommand implements Command {
    private final Repository<Term> termRepository;
    private final String term;
    private final String description;
    private final Category category;

    public AddTermCommand(Repository<Term> termRepository, String term, String description, Category category) {
        this.termRepository = termRepository;
        this.term = term;
        this.description = description;
        this.category = category;
    }

    @Override
    public String execute() throws CustomException {
        TermHandler handler = new TermTooLongHandler();
        handler.setNextHandler(new DescriptionTooLongHandler())
                .setNextHandler(new TermDoesNotExistHandler(termRepository));

        if(handler.handle(term, description, category.getName())){
            termRepository.save( new Term(category, term, description));
            return "added term \"" + term + "\" to category \"" + category.getName() + "\".";
        }
        throw new FailedToExecuteCommandException();
    }

    @Override
    public boolean shouldExitCommandLine() {
        return false;
    }
}
