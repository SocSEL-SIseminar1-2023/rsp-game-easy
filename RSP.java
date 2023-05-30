import java.util.Random;
import java.util.Scanner;

public class RSP {
	public static void main(String[] args) {
		// テキストに使う色の宣言
		final String GREEN = "\u001b[00;32m";
		final String YELLOW = "\u001b[00;33m";
		final String PURPLE = "\u001b[00;34m";
        final String END = "\u001b[00m";

        Scanner scan = new Scanner(System.in);
        int continue_num = 0;
        int win_record = 0;
        boolean onlyDrow = true;
        
        while(continue_num == 0) {
            // プレイヤーの手を入力
            System.out.print("Please input your hand! 0:Rock 1:Scissors 2:Paper\n Your hand is : ");
            int player_hand = Integer.parseInt(scan.nextLine());

            // 相手の手を決定
            int enemy_hand = getRandomInt(3);
            System.out.println(" Enemy hand is: " + enemy_hand);

            System.out.print("Result: ");
            // 勝敗判定
            switch (player_hand) {
                case 0:
                    switch (enemy_hand) {
                        case 0:
                            System.out.println(GREEN + "Draw!");
                            break;
                        case 1:
                            System.out.println(YELLOW + "You win!");
                            win_record++;
                            onlyDrow = false;
                            break;
                        case 2:
                            System.out.println(PURPLE + "Enemy win!");
                            win_record = 0;
                            onlyDrow = false;
                            break;
                        default:
                            break;
                    }
                    break;
                case 1:
                    switch (enemy_hand) {
                        case 0:
                            System.out.println(PURPLE + "Enemy win!");
                            win_record = 0;
                            onlyDrow = false;
                            break;
                        case 1:
                            System.out.println(GREEN + "Draw!");
                            break;
                        case 2:
                            System.out.println(YELLOW + "You win!");
                            win_record++;
                            onlyDrow = false;
                            break;
                        default:
                            break;
                    }
                    break;
                case 2:
                    switch (enemy_hand) {
                        case 0:
                            System.out.println(YELLOW + "You win!");
                            win_record++;
                            onlyDrow = false;
                            break;
                        case 1:
                            System.out.println(PURPLE + "Enemy win!");
                            win_record = 0;
                            onlyDrow = false;
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
            System.out.println(END + "win record:" + win_record);
            System.out.println();

            if(win_record == 0 && !(onlyDrow)) {
                System.out.println("continue? 0:Yes 1:No");
                continue_num = Integer.parseInt(scan.nextLine());
                System.out.println();
                onlyDrow = true;
            }
        }
        scan.close();
	}

	// 受け取った範囲でランダムな数値を生成
	private static int getRandomInt(int range) {
		Random random = new Random();
		int random_num = random.nextInt(range);
		return random_num;
	}
}
