package command.term;

import command.Command;
import command.term.handlers.DescriptionTooLongHandler;
import command.term.handlers.TermHandler;
import exceptions.CustomException;
import exceptions.command.FailedToExecuteCommandException;

public class UpdateTermDescriptionCommand implements Command {
    private final Term term;
    private final String newDescription;

    public UpdateTermDescriptionCommand(Term term, String newDescription) {
        this.term = term;
        this.newDescription = newDescription;
    }

    @Override
    public String execute() throws CustomException {
        TermHandler handler = new DescriptionTooLongHandler();
        if(handler.handle(term.getTerm(), newDescription, term.getCategoryName()))
        {
            term.setDescription(newDescription);
            return "Changed description of term \"" + term.getTerm() + "\"";
        }
        throw new FailedToExecuteCommandException();
    }

    @Override
    public boolean shouldExitCommandLine() {
        return false;
    }
}
