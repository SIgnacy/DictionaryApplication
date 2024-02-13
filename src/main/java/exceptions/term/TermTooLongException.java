package exceptions.term;

import command.term.Term;
import exceptions.CustomException;

public class TermTooLongException extends CustomException {

    @Override
    public String getMessage() {
        return "Term is too long (max allowable size is " + Term.TERM_MAX_SIZE + " characters).";
    }
}
