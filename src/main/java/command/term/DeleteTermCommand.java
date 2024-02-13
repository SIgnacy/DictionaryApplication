package command.term;

import command.Command;
import exceptions.CustomException;
import repository.Repository;

public class DeleteTermCommand implements Command {

    private final Repository<Term> termRepository;
    private final Term term;

    public DeleteTermCommand(Repository<Term> termRepository, Term term) {
        this.termRepository = termRepository;
        this.term = term;
    }

    @Override
    public String execute() throws CustomException {
        String message = "Deleted term \"" + term.getTerm() + "\" from category \"" + term.getCategoryName() + "\".";
        termRepository.delete(term);
        return message;
    }

    @Override
    public boolean shouldExitCommandLine() {
        return false;
    }
}
