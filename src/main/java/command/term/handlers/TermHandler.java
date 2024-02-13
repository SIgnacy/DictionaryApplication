package command.term.handlers;

import exceptions.CustomException;

public abstract class TermHandler {
    private TermHandler next;

    public TermHandler setNextHandler(TermHandler next) {
        this.next = next;
        return next;
    }
    public abstract boolean handle(String term, String description, String category) throws CustomException;
    protected boolean handleNext(String term, String description, String category) throws  CustomException{
        if(next == null)
            return true;

        return  next.handle(term, description, category);
    }
}
