package command.commandFactory;

import command.Command;
import command.commandDraft.CommandDraft;
import exceptions.CustomException;

public interface CommandFactory {
    Command create(CommandDraft commandDraft) throws CustomException;
}
