package command.search;

import command.Command;
import command.term.Term;
import exceptions.CustomException;
import repository.Repository;

public class SearchTermCommand implements Command {
    private final Repository<Term> termRepository;
    private final String term;

    public SearchTermCommand(Repository<Term> termRepository, String term) {
        this.termRepository = termRepository;
        this.term = term;
    }

    @Override
    public String execute() throws CustomException {
        StringBuilder result = new StringBuilder();
        String separator = "-".repeat(100);

        termRepository.findAll(term)
                .forEach(term -> {
                    result.append("\n")
                            .append("--- ").append(term.getCategoryName()).append(" ---").append("\n")
                            .append(term).append("\n")
                            .append(separator);
                });

        return result.toString();
    }

    @Override
    public boolean shouldExitCommandLine() {
        return false;
    }
}
