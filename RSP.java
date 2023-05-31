import java.util.Random;
import java.util.Scanner;

public class RSP {
    public static void main(String[] args) {
        // テキストに使う色の宣言
        //final String GREEN = "\u001b[00;32m";
        //final String YELLOW = "\u001b[00;33m";
        //final String PURPLE = "\u001b[00;34m";
        

        int player_hand;
        int judgeWin = 0;
        Scanner scan = new Scanner(System.in);
        while (true) {
            try {
                // プレイヤーの手を入力
                System.out.print("Please input your hand! 0:Rock 1:Scissors 2:Paper\nYour hand is: ");
                player_hand = Integer.parseInt(scan.nextLine());
                if (player_hand < 0 || player_hand > 2) {
                    System.out.println("指定された範囲の値ではない数値が入力されました。正しい値を入力してください");
                    continue;
                }
                break;
            } catch (Exception e) {
                System.out.println("型が異なる値が入力されました。正しい値を入力してください。");
            }
        }

        // 相手の手を決定
        int enemy_hand = getRandomInt(2);
        System.out.println("Enemy hand is: " + enemy_hand);

        System.out.print("Result: ");
        // 勝敗判定
        if (player_hand == enemy_hand) {
            System.out.println("Draw!");
            scan.close();
        } else if ((player_hand == 0 && enemy_hand == 1) || (player_hand == 1 && enemy_hand == 2)
                || (player_hand == 2 && enemy_hand == 0)) {
            System.out.println("You win!");
            judgeWin = 1;
            playAchiMuiteHoi(judgeWin);
        } else {
            System.out.println("Enemy win!");
            playAchiMuiteHoi(judgeWin);
        }
    }

    // 受け取った範囲でランダムな数値を生成
    private static int getRandomInt(int range) {
        Random random = new Random();
        int random_num = random.nextInt(range + 1);
        return random_num;
    }

    public static void playAchiMuiteHoi(int judgeWin) {
        Scanner scan = new Scanner(System.in);
        int player_direction;
        while (true) {
            try {
                // プレイヤーの方向を入力
                System.out.print("Please choose your direction! 0:Up 1:Right 2:Down 3:Left\nYour direction is: ");
                player_direction = Integer.parseInt(scan.nextLine());
                if (player_direction < 0 || player_direction > 3) {
                    System.out.println("指定された範囲の値ではない数値が入力されました。正しい値を入力してください");
                    continue;
                }
                break;
            } catch (Exception e) {
                System.out.println("型が異なる値が入力されました。正しい値を入力してください。");
            }
        }
        scan.close();

        int enemy_direction = getRandomInt(3);
        System.out.println("Enemy direction is: " + enemy_direction);
        if(judgeWin == 1){
            if (player_direction == enemy_direction) {
                System.out.println("You win the game!");
            } else {
                System.out.println("You lose the game!");
            }
        }else {
            if (player_direction == enemy_direction) {
                System.out.println("You lose the game!");
            } else {
                System.out.println("You win the game!");
            }
        }
    }
}
