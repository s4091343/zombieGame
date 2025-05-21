import java.util.Scanner;

public class Interactions {
    public static void main(String[] args) {
        Scanner myInput = new Scanner(System.in);
        boolean gameEnded = false;

        while (!gameEnded) {
            System.out.println("You see an injured soldier calling for help, do you approach? (Y/N)");
            String response = myInput.nextLine();

            if (response.equalsIgnoreCase("Y")) {
                System.out.println("Name's Christian. This base was overrun with these things a couple hours ago. From my guess, I'm the only one who's still alive.");
                System.out.println("I'm badly wounded... there's no saving me. Listen, I need a favor from you.");
                System.out.println("Please... end my suffering. In return, I'll give you my medkit.");

                boolean validFavorResponse = false;

                while (!validFavorResponse) {
                    System.out.print("\nDo you grant Christian's request? (Y/N): ");
                    String favorChoice = myInput.nextLine();

                    if (favorChoice.equalsIgnoreCase("Y")) {
                        System.out.println("You steady your hand and do what must be done. Christian's suffering ends peacefully.");
                        System.out.println("You take the medkit he left behind. 'This should keep you alive out there,' you whisper to yourself.");
                        validFavorResponse = true;
                        gameEnded = true;
                    } else if (favorChoice.equalsIgnoreCase("N")) {
                        System.out.println("Christian sighs and turns away. 'Then leave me. I’ll face the end myself.'");
                        System.out.println("You walk away, the weight of his plea heavy on your conscience.");
                        validFavorResponse = true;
                        gameEnded = true;
                    } else {
                        System.out.println("Invalid response. Please enter Y or N.");
                    }
                }

            } else if (response.equalsIgnoreCase("N")) {
                System.out.println("While you're walking away, the soldier bites you. Game Over!");
                gameEnded = true;
            } else {
                System.out.println("Invalid response. Please enter Y or N.");
            }
        }

        myInput.close();
    }
}
