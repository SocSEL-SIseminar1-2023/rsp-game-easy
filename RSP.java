import java.util.Random;
import java.util.Scanner;

public class RSP {
	public static void main(String[] args) {
		// テキストに使う色の宣言
		final String GREEN = "\u001b[00;32m";
		final String YELLOW = "\u001b[00;33m";
		final String PURPLE = "\u001b[00;34m";
		// プレイヤーの手を入力
		System.out.print("Please input your hand! 0:Rock 1:Scissors 2:Paper\n Your hand is : ");
		Scanner scan = new Scanner(System.in);
		int player_hand = Integer.parseInt(scan.nextLine());
		scan.close();

		// 相手の手を決定
		int enemy_hand = getRandomInt(2);
		System.out.println(" Enemy hand is: " + enemy_hand);

		System.out.print("Result: ");
		// 勝敗判定
		if(player_hand == 0) {
				if (enemy_hand == 0) {
						System.out.println(GREEN + "Draw!");
                } else if (enemy_hand == 1) {
						System.out.println(YELLOW + "You win!");
                } else if (enemy_hand == 2) {
						System.out.println(PURPLE + "Enemy win!");
                }
            } else if (player_hand == 1) {
            if (enemy_hand == 0) {
						System.out.println(GREEN + "Draw!");
					} else if (enemy_hand == 1) {
						System.out.println(YELLOW + "You win!");
                    } else if (enemy_hand == 2) {
						System.out.println(PURPLE + "Enemy win!");
				}
            } else if (player_hand == 2) {
            if (enemy_hand == 0) {
						System.out.println(YELLOW + "You win!");
                    } else if (enemy_hand == 1) {
						System.out.println(PURPLE + "Enemy win!");
                    } else if (enemy_hand == 2) {
						System.out.println(GREEN + "Draw!");
                    }
            }
	}

	// 受け取った範囲でランダムな数値を生成
	private static int getRandomInt(int range) {
		Random random = new Random();
		int random_num = random.nextInt(range);
		return random_num;
	}
}
