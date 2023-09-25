public class Adventure {
    private Room currentRoom;

    public Adventure() {
        // Create room objects and build the game map
        Room room1 = new Room("Room 1", "A room with no distinct features, except two doors.");
        Room room2 = new Room("Room 2", "A dimly lit room with a musty smell.");
        Room room3 = new Room("Room 3", "A large room with a high ceiling.");
        Room room4 = new Room("Room 4", "A mysterious room filled with strange artifacts.");
        Room room5 = new Room("Room 5", "A hidden chamber with a single exit to the east.");
        Room room6 = new Room("Room 6", "A narrow corridor with flickering torches.");
        Room room7 = new Room("Room 7", "An underground cave with a shimmering pool.");
        Room room8 = new Room("Room 8", "A dusty library with rows of ancient books.");
        Room room9 = new Room("Room 9", "A secret chamber containing a treasure chest.");

        // Connect rooms
        room1.setEast(room2);
        room2.setWest(room1);

        room1.setSouth(room4);
        room4.setNorth(room1);

        room2.setSouth(room5);
        room5.setNorth(room2);

        room3.setEast(room4);
        room4.setWest(room3);

        room4.setSouth(room7);
        room7.setNorth(room4);

        room5.setEast(room6);
        room6.setWest(room5);

        room6.setSouth(room9);
        room9.setNorth(room6);

        room7.setEast(room8);
        room8.setWest(room7);

        // Set the starting room
        currentRoom = room1;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room room) {
        currentRoom = room;
    }

    public static void main(String[] args) {
        Adventure adventure = new Adventure();
        UserInterface ui = new UserInterface(adventure);
        ui.startGame();
    }
}
