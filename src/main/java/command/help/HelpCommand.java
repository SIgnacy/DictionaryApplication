package command.help;

import command.Command;

public class HelpCommand implements Command {


    @Override
    public String execute() {
        return  String.format("%-70s %s%n", "HELP", "displays information about commands.") +
                String.format("%-70s %s%n", "EXIT", "exiting the program.") +
                String.format("%-70s %s%n", "ADD CATEGORY \"name\"", "adds a new category.") +
                String.format("%-70s %s%n", "DELETE CATEGORY \"name\"", "delete given category.") +
                String.format("%-70s %s%n", "UPDATE CATEGORY \"old name\" \"new name\"", "updates the category name.") +
                String.format("%-70s %s%n", "ADD TERM \"term\" \"description\" to \"category\"", "adds a new term with given description to existing category.") +
                String.format("%-70s %s%n", "DELETE TERM \"term\" from \"category\"", "delete given term from given category.") +
                String.format("%-70s %s%n", "UPDATE TERM \"oldTerm\" to \"newTerm\" in \"category\"", "updates term in given category") +
                String.format("%-70s %s%n", "UPDATE TERM DESCRIPTION \"term\" \"newDescription\" in \"category\"", "updates description of term in given category") +
                String.format("%-70s %s%n", "UPDATE TERM CATEGORY \"term\" \"oldCategory\" \"newCategory\"", "updates category of given term") +
                String.format("%-70s %s%n", "LIST ALL", "list all saved terms in dictionary.") +
                String.format("%-70s %s%n", "LIST \"category name\"", "list all saved terms from given category.") +
                String.format("%-70s %s%n", "SEARCH \"term\"", "list all terms with given name.");
    }

    @Override
    public boolean shouldExitCommandLine() {
        return false;
    }
}
