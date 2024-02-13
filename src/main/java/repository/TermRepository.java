package repository;

import command.term.Term;
import exceptions.CustomException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TermRepository implements Repository<Term>{

    private final List<Term> terms;

    public TermRepository() {
        this.terms = new ArrayList<>();
    }

    @Override
    public void save(Term object) {
        terms.add(object);
    }

    @Override
    public void delete(Term object) {
        terms.remove(object);
    }

    @Override
    public List<Term> read() {
        return terms;
    }

    @Override
    public List<Term> read(String category)  {
        return terms.stream()
                .filter(t -> t.getCategoryName().equalsIgnoreCase(category))
                .toList();
    }

    @Override
    public List<Term> findAll(String term) {
        return terms.stream()
                .filter(t -> t.getTerm().equalsIgnoreCase(term))
                .toList();
    }

    @Override
    public Optional<Term> findBy(String term, String category) {
        return terms.stream()
                .filter(t -> t.getCategoryName().equalsIgnoreCase(category) && t.getTerm().equalsIgnoreCase(term))
                .findFirst();
    }
    @Override
    public Optional<Term> findBy(String category) throws CustomException {
        return terms.stream()
                .filter(t -> t.getCategoryName().equalsIgnoreCase(category))
                .findAny();
    }
}
