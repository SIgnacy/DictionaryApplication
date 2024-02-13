package logger;

public class ConsoleLogger extends Logger {
    public void info(String message) {
        System.out.println(message);
    }

    @Override
    public void error(String message) {
        System.out.println("\u001B[31m" + message + "\u001B[0m");
    }
}
