import java.util.*;

public class GridGameWithFixedItems {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Map<String, Integer> inventory = new HashMap<>();

        // Room name assignments
        Map<String, String> roomNames = new HashMap<>();
        roomNames.put("0,0", "Cafeteria");
        roomNames.put("0,4", "Armory");
        roomNames.put("2,2", "Head Office");
        roomNames.put("4,0", "Barracks");
        roomNames.put("4,4", "Garage");
        roomNames.put("2,4", "Warehouse");

        // Items assigned to specific rooms
        Map<String, String> itemLocations = new HashMap<>();
        itemLocations.put("0,0", "Medkit");       // Cafeteria
        itemLocations.put("0,4", "Ammo");         // Armory
        itemLocations.put("2,2", "Keycard");      // Head Office
        itemLocations.put("4,0", "Map");          // Barracks
        itemLocations.put("4,4", "Flashlight");   // Garage
        itemLocations.put("2,4", "Toolkit");      // Warehouse

        // Player starts at (0,0)
        int playerX = 0, playerY = 0;
        Set<String> collectedRooms = new HashSet<>();
        boolean playing = true;

        System.out.println("\n=== 5x5 Grid Room Exploration ===");
        System.out.println("Explore rooms and collect all 6 items.");
        System.out.println("Use N/S/E/W to move. Type INV to view inventory. Type Q to quit.");

        while (playing) {
            String positionKey = playerX + "," + playerY;
            String currentRoom = roomNames.getOrDefault(positionKey, "an empty hallway");

            System.out.println("\nYou are at (" + playerX + ", " + playerY + ") - " + currentRoom);

            // Check for item
            if (itemLocations.containsKey(positionKey) && !collectedRooms.contains(positionKey)) {
                String item = itemLocations.get(positionKey);
                System.out.println("You found a " + item + " here!");
                inventory.put(item, 1);
                collectedRooms.add(positionKey);
            }

            System.out.print("Enter move (N/S/E/W), INV to view inventory, or Q to quit: ");
            String command = input.nextLine().trim().toUpperCase();

            switch (command) {
                case "N":
                    if (playerX > 0) playerX--;
                    else System.out.println("You can't go further north.");
                    break;
                case "S":
                    if (playerX < 4) playerX++;
                    else System.out.println("You can't go further south.");
                    break;
                case "E":
                    if (playerY < 4) playerY++;
                    else System.out.println("You can't go further east.");
                    break;
                case "W":
                    if (playerY > 0) playerY--;
                    else System.out.println("You can't go further west.");
                    break;
                case "INV":
                    System.out.println("\n--- Inventory ---");
                    if (inventory.isEmpty()) {
                        System.out.println("You haven't collected any items yet.");
                    } else {
                        inventory.forEach((k, v) -> System.out.println(k + ": " + v));
                    }
                    break;
                case "Q":
                    System.out.println("You exit the building. Game over.");
                    playing = false;
                    break;
                default:
                    System.out.println("Invalid command. Try N, S, E, W, INV, or Q.");
            }

            if (inventory.size() == 6) {
                System.out.println("\n🎉 Congratulations! You collected all 6 items and completed the mission.");
                playing = false;
            }
        }

        input.close();
    }
}
