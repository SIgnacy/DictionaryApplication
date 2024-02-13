import command.category.Category;
import command.commandFactory.CommandFactory;
import command.commandFactory.DictionaryCommandFactory;
import command.term.Term;
import controller.CommandLine;
import logger.ConsoleLogger;
import logger.Logger;
import repository.CategoryRepository;
import repository.Repository;
import repository.TermRepository;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        Repository<Category> categoryRepository = new CategoryRepository();
        Repository<Term> termRepository = new TermRepository();
        Logger log = new ConsoleLogger();
        CommandFactory dictionaryCommandFactory = new DictionaryCommandFactory(categoryRepository, termRepository);
        CommandLine commandLine = new CommandLine(scanner, dictionaryCommandFactory, log);
        commandLine.run();
    }
}