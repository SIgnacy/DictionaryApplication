package command.term.handlers;

import command.term.Term;
import exceptions.CustomException;
import exceptions.term.DescriptionTooLongException;

public class DescriptionTooLongHandler extends  TermHandler{
    @Override
    public boolean handle(String term, String description, String category) throws CustomException {
        if(description.length() > Term.DESCRIPTION_MAX_SIZE){
            throw new DescriptionTooLongException();
        }
        return handleNext(term, description, category);
    }
}
