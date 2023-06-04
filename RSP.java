import java.util.Random;
import java.util.Scanner;
import java.util.InputMismatchException;

public class RSP {
    public static void main(String[] args) {
        // テキストに使う色の宣言
        final String GREEN = "\u001b[00;32m";
        final String YELLOW = "\u001b[00;33m";
        final String PURPLE = "\u001b[00;34m";
        final String RESET = "\u001b[0m";

        // プレイヤーの手を入力
        int player_hand = getPlayerHand();

        // 勝敗判定のループ
        boolean rematch = true;
        while (rematch) {
            // 相手の手を決定
            int enemy_hand = getRandomInt(2);
            System.out.println("Enemy hand is: " + enemy_hand);

            System.out.print("Result: ");
            playRockPaperScissors(player_hand, enemy_hand, GREEN, YELLOW, PURPLE);

            // あいこの場合、もう一度手を入力するか確認
            if (player_hand == enemy_hand) {
                System.out.println(RESET + "Rematch!");
                player_hand = getPlayerHand();
            } else {
                rematch = false;
            }
        }
    }

    // 受け取った範囲でランダムな数値を生成
    private static int getRandomInt(int range) {
        Random random = new Random();
        int random_num = random.nextInt(range);
        return random_num;
    }

    // プレイヤーの手を入力するメソッド
    private static int getPlayerHand() {
        int player_hand = 0;
        boolean flag = false; // 入力が正しいかどうか判断するフラグ
        Scanner scan = new Scanner(System.in);
        while (!flag) {
            try {
                System.out.print("Please input your hand! 0:Rock 1:Scissors 2:Paper\nYour hand is : ");
                player_hand = scan.nextInt();
                if (player_hand >= 0 && player_hand <= 2) {
                    flag = true;
                } else {
                    System.out.println("Error: Please enter a number between 0 and 2");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Please enter a number between 0 and 2");
                scan.nextLine(); // 入力バッファをクリア
            }
        }
        return player_hand;
    }

    // じゃんけんの結果を表示するメソッド
    private static void playRockPaperScissors(int playerHand, int enemyHand, String green, String yellow, String purple) {
        final String GREEN = green;
        final String YELLOW = yellow;
        final String PURPLE = purple;
        final String RESET = "\u001b[0m";

        switch (playerHand) {
            case 0:
                switch (enemyHand) {
                    case 0:
                        System.out.println(GREEN + "Draw!");
                        break;
                    case 1:
                        System.out.println(YELLOW + "You win!");
                        break;
                    case 2:
                        System.out.println(PURPLE + "Enemy win!");
                        break;
                    default:
                        break;
                }
                break;
            case 1:
                switch (enemyHand) {
                    case 1:
                        System.out.println(GREEN + "Draw!");
                        break;
                    case 2:
                        System.out.println(YELLOW + "You win!");
                        break;
                    case 0:
                        System.out.println(PURPLE + "Enemy win!");
                        break;
                    default:
                        break;
                }
                break;
            case 2:
                switch (enemyHand) {
                    case 0:
                        System.out.println(YELLOW + "You win!");
                        break;
                    case 1:
                        System.out.println(PURPLE + "Enemy win!");
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
