package exceptions.term;

import command.term.Term;
import exceptions.CustomException;

public class DescriptionTooLongException extends CustomException {
    @Override
    public String getMessage() {
        return "Description is too long (max allowable size is " + Term.DESCRIPTION_MAX_SIZE + " characters).";
    }
}
