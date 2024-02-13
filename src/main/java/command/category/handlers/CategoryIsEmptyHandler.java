package command.category.handlers;

import command.term.Term;
import exceptions.CustomException;
import exceptions.category.CategoryIsNotEmptyException;
import repository.Repository;

public class CategoryIsEmptyHandler extends CategoryHandler{
    private final Repository<Term> termRepository;

    public CategoryIsEmptyHandler(Repository<Term> termRepository) {
        this.termRepository = termRepository;
    }

    @Override
    public boolean handle(String categoryName) throws CustomException {
        if(termRepository.findBy(categoryName).isPresent()){
            throw new CategoryIsNotEmptyException(categoryName);
        }
        return handleNext(categoryName);
    }
}
