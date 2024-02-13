package command.term.handlers;

import command.term.Term;
import exceptions.CustomException;
import exceptions.term.TermTooLongException;

public class TermTooLongHandler extends TermHandler {
    @Override
    public boolean handle(String term, String description, String category) throws CustomException {
        if(term.length() > Term.TERM_MAX_SIZE){
            throw new TermTooLongException();
        }
        return handleNext(term, description, category);
    }
}
