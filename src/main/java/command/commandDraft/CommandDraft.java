package command.commandDraft;

import command.commandType.CommandType;
import exceptions.command.IncorrectCommandException;


public class CommandDraft {
    private final CommandType type;
    private final String target;
    private final String argument;
    private final String additionalArgument;

    public CommandDraft(String userInput) throws IncorrectCommandException {
        try {
            String[] input = userInput.split("\"");

            type = CommandType.valueOf(input[0]
                    .trim()
                    .replace(' ', '_')
                    .toUpperCase());

            target = (input.length > 1) ? input[1] : null;
            argument = (input.length > 3) ? input[3] : null;
            additionalArgument = (input.length > 5) ? input[5] : null;
        } catch (Exception e) {
            throw new IncorrectCommandException();
        }
    }

    public CommandType getType() {
        return type;
    }

    public String getTarget() {
        return target;
    }

    public String getArgument() {
        return argument;
    }

    public String getAdditionalArgument() {
        return additionalArgument;
    }
}
