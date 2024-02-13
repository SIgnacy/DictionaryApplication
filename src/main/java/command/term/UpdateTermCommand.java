package command.term;

import command.Command;
import command.term.handlers.TermDoesNotExistHandler;
import command.term.handlers.TermHandler;
import command.term.handlers.TermTooLongHandler;
import exceptions.CustomException;
import exceptions.command.IncorrectCommandException;
import repository.Repository;

public class UpdateTermCommand implements Command {

    private final Repository<Term> termRepository;
    private final Term term;
    private final String newTerm;

    public UpdateTermCommand(Repository<Term> termRepository, Term term, String newTerm) {
        this.termRepository = termRepository;
        this.term = term;
        this.newTerm = newTerm;
    }

    @Override
    public String execute() throws CustomException {
        TermHandler handler = new TermTooLongHandler();
        handler.setNextHandler( new TermDoesNotExistHandler(termRepository));
        if(handler.handle(newTerm,"", term.getCategoryName())){
            String message = "Updated term \"" + term.getTerm() + "\" to \"" + newTerm + "\".";
            term.setTerm(newTerm);
            return message;
        }
        throw new IncorrectCommandException();
    }

    @Override
    public boolean shouldExitCommandLine() {
        return false;
    }
}
