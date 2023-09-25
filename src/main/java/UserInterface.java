import java.util.Scanner;

public class UserInterface {
    private final Adventure adventure;
    private final Scanner scanner;

    public UserInterface(Adventure adventure) {
        this.adventure = adventure;
        this.scanner = new Scanner(System.in);
    }

    public void startGame() {
        System.out.println("Welcome to the Adventure Game!");
        System.out.println("You are in " + adventure.getCurrentRoom().getName() + ".");
        System.out.println("Type 'help' for a list of commands.");

        while (true) {
            String input = scanner.nextLine();
            interpretCommand(input);
        }
    }

    private void interpretCommand(String input) {
        input = input.toLowerCase(); // Convert input to lowercase for case-insensitivity

        switch (input) {
            case "exit":
                System.out.println("Exiting the game. Goodbye!");
                System.exit(0);
                break;
            case "help":
                displayHelp();
                break;
            case "look":
                System.out.println("You are in " + adventure.getCurrentRoom().getName() + ". " + adventure.getCurrentRoom().getDescription());
                break;
            case "go north":
            case "go east":
            case "go south":
            case "go west":
                String direction = input.split(" ")[1]; // Extract direction from the input
                navigate(direction);
                break;
            default:
                System.out.println("Invalid command. Type 'help' for a list of commands.");
                break;
        }
    }

    private void displayHelp() {
        System.out.println("write 'north' 'east' 'south' or 'west' bitch");

    }

    private void navigate(String direction) {
        Room nextRoom = null;
        switch (direction) {
            case "north":
                nextRoom = adventure.getCurrentRoom().getNorth();
                break;
            case "east":
                nextRoom = adventure.getCurrentRoom().getEast();
                break;
            case "south":
                nextRoom = adventure.getCurrentRoom().getSouth();
                break;
            case "west":
                nextRoom = adventure.getCurrentRoom().getWest();
                break;
        }

        if (nextRoom != null) {
            adventure.setCurrentRoom(nextRoom);
            System.out.println("Going " + direction + ".");
        } else {
            System.out.println("You cannot go that way.");
        }
    }
}
