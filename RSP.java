import java.util.Random;
import java.util.Scanner;

public class RSP {
    public static void main(String[] args) {
        // テキストに使う色の宣言
        final String GREEN = "\u001b[00;32m";
        final String YELLOW = "\u001b[00;33m";
        final String PURPLE = "\u001b[00;34m";

        // 繰り返し処理のためのループ
        while (true) {
            // プレイヤーの手を入力
            System.out.print("Please input your hand! 0:Rock 1:Scissors 2:Paper\nYour hand is : ");
            Scanner scan = new Scanner(System.in);

            // 入力が正しいかチェック
            if (scan.hasNextInt()) {
                int player_hand = scan.nextInt();

                // 入力の範囲が正しいかチェック
                if (player_hand >= 0 && player_hand <= 2) {
                    // 相手の手を決定
                    int enemy_hand = getRandomInt(2);
                    System.out.println("Enemy hand is: " + enemy_hand);

                    // 勝敗判定
                    if ((player_hand == 0 && enemy_hand == 0) || (player_hand == 1 && enemy_hand == 1) || (player_hand == 2 && enemy_hand == 2)) {
                        System.out.println(GREEN + "Draw!\n");
                    } else if ((player_hand == 0 && enemy_hand == 1) || (player_hand == 1 && enemy_hand == 2) || (player_hand == 2 && enemy_hand == 0)) {
                        System.out.println(YELLOW + "You win!\n");
                        break; // 勝利の場合、ループを終了
                    } else if ((player_hand == 0 && enemy_hand == 2) || (player_hand == 1 && enemy_hand == 0) || (player_hand == 2 && enemy_hand == 1)) {
                        System.out.println(PURPLE + "You lose!\n");
                        break; // 敗北の場合、ループを終了
                    }
                } else {
                    System.out.println("Invalid input. Please try again.\n");
                }
            } else {
                System.out.println("Invalid input. Please try again.\n");
                scan.nextLine(); // 入力バッファをクリア
            }
        }
    }

    // 受け取った範囲でランダムな数値を生成
    private static int getRandomInt(int range) {
        Random random = new Random();
        int random_num = random.nextInt(range + 1); // range + 1 を指定することで、0からrangeまでの範囲で乱数を生成
        return random_num;
    }
}
