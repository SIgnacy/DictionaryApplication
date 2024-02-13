package command.list;

import command.Command;
import command.term.Term;
import exceptions.CustomException;
import repository.Repository;

import java.util.Comparator;

public class ListAllCommand implements Command {
    private final Repository<Term>  termRepository;

    public ListAllCommand(Repository<Term> termRepository) {
        this.termRepository = termRepository;
    }

    @Override
    public String execute() throws CustomException {
        StringBuilder result = new StringBuilder();
        String separator = "-".repeat(100);

        termRepository.read().stream()
                .sorted(Comparator.comparing(Term::getCategoryName))
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
