import java.io.Console;

public class RSP {
    public static void main(String[] args) {
        // テキストに使う色の宣言
        final String GREEN = "\u001b[00;32m";
        final String YELLOW = "\u001b[00;33m";
        final String PURPLE = "\u001b[00;34m";
        final String RESET = "\u001b[0m";

        Console console = System.console();

        int playerA_hand = getPlayerHand(console, "Player A");
        int playerB_hand = getPlayerHand(console, "Player B");

        System.out.println("Player A hand:"+playerA_hand);
        System.out.println("Player B hand:"+playerB_hand);
        System.out.print("Result: ");
        judgehands(playerA_hand, playerB_hand);
        

        System.out.println(RESET + "=== Game Set ===");
    }

    private static int getPlayerHand(Console console, String player) {
        int player_hand = 0;
        boolean flag = false;
        while (!flag) {
            try {
                char[] password = console.readPassword("%s, please input your hand! 0:Rock 1:Scissors 2:Paper\nYour hand is: ", player);
                String input = new String(password);
                player_hand = Integer.parseInt(input);
                if (checkhand(player_hand)) {
                    flag = true;
                    return player_hand;
                } else {
                    System.out.println("Error: Please enter a number between 0 and 2");
                }
                java.util.Arrays.fill(password, ' ');
            } catch (Exception e) {
                System.out.println("Error: Please enter a number between 0 and 2");
            }
        }
        return 0;
    }

    private static boolean checkhand(int hand) {
        return hand >= 0 && hand <= 2;
    }

    private static void judgehands(int playerA_hand, int playerB_hand) {
        final String GREEN = "\u001b[00;32m";
        final String YELLOW = "\u001b[00;33m";
        final String PURPLE = "\u001b[00;34m";
        final String RESET = "\u001b[0m";

        switch (playerA_hand) {
            case 0:
                switch (playerB_hand) {
                    case 0:
                        System.out.println(GREEN + "Draw!");
                        break;
                    case 1:
                        System.out.println(YELLOW + "Player A wins!");
                        break;
                    case 2:
                        System.out.println(PURPLE + "Player B wins!");
                        break;
                    default:
                        break;
                }
                break;
            case 1:
                switch (playerB_hand) {
                    case 0:
                        System.out.println(PURPLE + "Player B wins!");
                        break;
                    case 1:
                        System.out.println(GREEN + "Draw!");
                        break;
                    case 2:
                        System.out.println(YELLOW + "Player A wins!");
                        break;
                    default:
                        break;
                }
                break;
            case 2:
                switch (playerB_hand) {
                    case 0:
                        System.out.println(YELLOW + "Player A wins!");
                        break;
                    case 1:
                        System.out.println(PURPLE + "Player B wins!");
                        break;
                    case 2:
                        System.out.println(GREEN + "Draw!");
                        break;
                    default:
                        break;
                }
                break;
            default:
                break;
        }
        System.out.print(RESET);
    }
}
