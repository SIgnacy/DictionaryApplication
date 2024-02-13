package command.exit;

import command.Command;

public class ExitCommand implements Command {

    @Override
    public String execute() {
        return "Exiting the program...";
    }

    @Override
    public boolean shouldExitCommandLine() {
        return true;
    }
}
