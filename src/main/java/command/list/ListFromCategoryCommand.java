package command.list;

import command.Command;
import command.term.Term;
import exceptions.CustomException;
import repository.Repository;

public class ListFromCategoryCommand implements Command {
    private final Repository<Term> termRepository;
    private final String category;

    public ListFromCategoryCommand(Repository<Term> termRepository, String category) {
        this.termRepository = termRepository;
        this.category = category;
    }

    @Override
    public String execute() throws CustomException {
        StringBuilder result = new StringBuilder();
        String separator = "-".repeat(100);

        termRepository.read(category)
                .forEach(term -> {
                    result.append("\n")
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
