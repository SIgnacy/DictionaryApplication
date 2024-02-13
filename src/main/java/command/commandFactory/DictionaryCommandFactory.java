package command.commandFactory;

import command.Command;
import command.category.AddCategoryCommand;
import command.category.Category;
import command.category.DeleteCategoryCommand;
import command.category.UpdateCategoryCommand;
import command.commandDraft.CommandDraft;
import command.commandType.CommandType;
import command.exit.ExitCommand;
import command.help.HelpCommand;
import command.list.ListAllCommand;
import command.list.ListFromCategoryCommand;
import command.search.SearchTermCommand;
import command.term.*;
import exceptions.CustomException;
import exceptions.category.CategoryDoesNotExistException;
import exceptions.command.IncorrectCommandException;
import exceptions.term.TermDoesNotExistException;
import repository.Repository;


public class DictionaryCommandFactory implements CommandFactory {
    private final Repository<Category> categoryRepository;
    private final Repository<Term> termRepository;

    public DictionaryCommandFactory(Repository<Category> categoryRepository, Repository<Term> termRepository) {
        this.categoryRepository = categoryRepository;
        this.termRepository = termRepository;
    }

    public Command create(CommandDraft draft) throws CustomException {
        if (checkIfHelpCommand(draft)) {
            return createHelpCommand();
        } else if (checkIfExitCommand(draft)) {
            return createExitCommand();
        } else if (checkIfAddCategoryCommand(draft)) {
            return createAddCategoryCommand(draft);
        } else if (checkIfDeleteCategoryCommand(draft)) {
            return createDeleteCategoryCommand(draft);
        } else if(checkIfUpdateCategoryCommand(draft)){
            return createUpdateCategoryCommand(draft);
        } else if(checkIfAddTermCommand(draft)){
            return createAddTermCommand(draft);
        } else if (checkIfDeleteTermCommand(draft)) {
            return createDeleteTermCommand(draft);
        } else if (checkIfUpdateTermCommand(draft)) {
            return createUpdateTermCommand(draft);
        } else if(checkIfUpdateTermDescriptionCommand(draft)){
            return createUpdateTermDescriptionCommand(draft);
        } else if (checkIfUpdateTermCategoryCommand(draft)) {
            return createUpdateTermCategoryCommand(draft);
        } else if(checkIfListAllCommand(draft)){
            return createListAllCommand();
        } else if(checkIfListFromCategoryCommand(draft)){
            return createListFromCategoryCommand(draft);
        } else if (checkIfSearchTermCommand(draft)) {
            return createSearchTermCommand(draft);
        } else {
            throw new IncorrectCommandException();
        }
    }

    private static HelpCommand createHelpCommand() {
        return new HelpCommand();
    }

    private static ExitCommand createExitCommand() {
        return new ExitCommand();
    }

    private AddCategoryCommand createAddCategoryCommand(CommandDraft draft) {
        return new AddCategoryCommand(categoryRepository,
                draft.getTarget());
    }

    private DeleteCategoryCommand createDeleteCategoryCommand(CommandDraft draft) throws CustomException{
        return new DeleteCategoryCommand(categoryRepository,
                termRepository,
                getCategoryObject(draft.getTarget()));
    }

    private UpdateCategoryCommand createUpdateCategoryCommand(CommandDraft draft) throws CustomException {
        return new UpdateCategoryCommand(categoryRepository,
                getCategoryObject(draft.getTarget()),
                draft.getArgument()
        );
    }

    private AddTermCommand createAddTermCommand(CommandDraft draft) throws CustomException {
        return new AddTermCommand(termRepository,
                draft.getTarget(),
                draft.getArgument(),
                getCategoryObject(draft.getAdditionalArgument())
        );
    }
    private DeleteTermCommand createDeleteTermCommand(CommandDraft draft) throws CustomException{
        return new DeleteTermCommand(termRepository,
                getTermObject(draft.getTarget(), draft.getArgument())
        );
    }
    private UpdateTermCommand createUpdateTermCommand(CommandDraft draft) throws CustomException{
        return new UpdateTermCommand(
                termRepository,
                getTermObject(draft.getTarget(), draft.getAdditionalArgument()),
                draft.getArgument()
        );
    }
    private UpdateTermDescriptionCommand createUpdateTermDescriptionCommand(CommandDraft draft) throws CustomException{
        return new UpdateTermDescriptionCommand(
                getTermObject(draft.getTarget(), draft.getAdditionalArgument()),
                draft.getArgument()
        );
    }
    private UpdateTermCategoryCommand createUpdateTermCategoryCommand(CommandDraft draft) throws CustomException{
        return new UpdateTermCategoryCommand(
                getTermObject(draft.getTarget(), draft.getArgument()),
                getCategoryObject(draft.getAdditionalArgument())
        );
    }
    private ListAllCommand createListAllCommand(){
        return new ListAllCommand(termRepository);
    }
    private ListFromCategoryCommand createListFromCategoryCommand(CommandDraft draft){
        return new ListFromCategoryCommand(termRepository,
                draft.getTarget());
    }
    private SearchTermCommand createSearchTermCommand(CommandDraft draft) throws CustomException{
        return new SearchTermCommand(termRepository,
                draft.getTarget());
    }

    private boolean checkIfHelpCommand(CommandDraft draft) {
        return CommandType.HELP.equals(draft.getType());
    }

    private boolean checkIfExitCommand(CommandDraft draft) {
        return CommandType.EXIT.equals(draft.getType());
    }

    private boolean checkIfAddCategoryCommand(CommandDraft draft) {
        return CommandType.ADD_CATEGORY.equals(draft.getType())
                && draft.getTarget() != null;
    }
    private boolean checkIfDeleteCategoryCommand(CommandDraft draft) {
        return CommandType.DELETE_CATEGORY.equals(draft.getType())
                && draft.getTarget() != null;
    }
    private boolean checkIfUpdateCategoryCommand(CommandDraft draft) {
        return CommandType.UPDATE_CATEGORY.equals(draft.getType())
                && draft.getTarget() != null
                && draft.getArgument() != null;
    }
    private boolean checkIfAddTermCommand(CommandDraft draft){
        return CommandType.ADD_TERM.equals(draft.getType())
                && draft.getTarget() != null
                && draft.getArgument() != null
                && draft.getAdditionalArgument() != null;
    }
    private boolean checkIfDeleteTermCommand(CommandDraft draft){
        return CommandType.DELETE_TERM.equals(draft.getType())
                && draft.getTarget() != null
                && draft.getArgument() != null;
    }
    private boolean checkIfUpdateTermCommand(CommandDraft draft){
        return CommandType.UPDATE_TERM.equals(draft.getType())
                && draft.getTarget() != null
                && draft.getArgument() != null
                && draft.getAdditionalArgument() != null;
    }
    private boolean checkIfUpdateTermDescriptionCommand(CommandDraft draft){
        return CommandType.UPDATE_TERM_DESCRIPTION.equals(draft.getType())
                && draft.getTarget() != null
                && draft.getArgument() != null
                && draft.getAdditionalArgument() != null;
    }
    private boolean checkIfUpdateTermCategoryCommand(CommandDraft draft){
        return CommandType.UPDATE_TERM_CATEGORY.equals(draft.getType())
                && draft.getTarget() != null
                && draft.getArgument() != null
                && draft.getAdditionalArgument() != null;
    }
    private boolean checkIfListAllCommand(CommandDraft draft){
        return CommandType.LIST_ALL.equals(draft.getType());
    }
    private boolean checkIfListFromCategoryCommand(CommandDraft draft){
        return CommandType.LIST.equals(draft.getType())
                && draft.getTarget() != null;
    }
    private boolean checkIfSearchTermCommand(CommandDraft draft){
        return CommandType.SEARCH.equals(draft.getType())
                && draft.getTarget() != null;
    }

    private Term getTermObject(String term, String category) throws CustomException{
        return termRepository.findBy(term, category)
                .orElseThrow( () -> new TermDoesNotExistException(term, category));
    }
    private Category getCategoryObject(String category) throws CustomException{
        return categoryRepository.findBy(category)
                .orElseThrow( () -> new CategoryDoesNotExistException(category));
    }
}
