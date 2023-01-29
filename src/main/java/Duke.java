import java.util.Scanner;

public class Duke {

    /**
     * Prints out the greeting message to the user
     */
    public static void greetUser() {
        String greetMessage = "Hello! I'm Duke\n"
                + "Send me a list of things to remember!\n"
                + "Type <bye> to exit";
        System.out.println(greetMessage);
    }

    /**
     * Greets user and responds to user commands from the command line
     *
     * @param args None taken
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String logo = " .----------------.  .----------------.  .----------------.  .----------------. \n" +
                "| | |_   ___ `.  | || ||_   _||_   _|| || | |_  ||_  _|  | || | |_   ___  |  | |\n" +
                "| |   | |   `. \\ | || |  | |    | |  | || |   | |_/ /    | || |   | |_  \\_|  | |\n" +
                "| |   | |    | | | || |  | '    ' |  | || |   |  __'.    | || |   |  _|  _   | |\n" +
                "| |  _| |___.' / | || |   \\ `--' /   | || |  _| |  \\ \\_  | || |  _| |___/ |  | |\n" +
                "| | |________.'  | || |    `.__.'    | || | |____||____| | || | |_________|  | |\n" +
                " '----------------'  '----------------'  '----------------'  '----------------' ";
        System.out.println("Hello from\n" + logo);
        greetUser();
        UserCommandManager commandManager = new UserCommandManager();

        while (true) {
            String userCommand = input.next().toLowerCase();
            commandManager.handleCommands(userCommand, input.nextLine());
        }
    }
}
