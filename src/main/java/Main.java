public class Main {
    public static void main(String[] args) {
        Adventure adventure = new Adventure();
        UserInterface userInterface = new UserInterface(adventure);

        //Start the game
        userInterface.startGame();
    }
}
