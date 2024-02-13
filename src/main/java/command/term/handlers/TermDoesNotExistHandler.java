package command.term.handlers;

import command.term.Term;
import exceptions.CustomException;
import exceptions.term.TermAlreadyExistException;
import repository.Repository;

public class TermDoesNotExistHandler extends TermHandler{
    private final Repository<Term> termRepository;

    public TermDoesNotExistHandler(Repository<Term> termRepository) {
        this.termRepository = termRepository;
    }

    @Override
    public boolean handle(String term, String description, String category) throws CustomException {
        if(termRepository.findBy(term, category).isPresent()){
            throw new TermAlreadyExistException(term, category);
        }
        return handleNext(term, description, category);
    }
}
