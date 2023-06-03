import java.util.Random;
import java.util.Scanner;

public class RSP {
	public static void main(String[] args) {
		// テキストに使う色の宣言
		final String GREEN = "\u001b[00;32m";
		final String YELLOW = "\u001b[00;33m";
		final String PURPLE = "\u001b[00;34m";
		// プレイヤーの手を入力
        int playerVictoryNum = 0;
        int enemyVictoryNum = 0;
        int player_hand;
        Scanner scan = new Scanner(System.in);
        System.out.println("Whoever wins 3 times first is the winner");

        //プレイヤーまたは敵が3回勝つまで繰り返す
        while((playerVictoryNum < 3) && (enemyVictoryNum < 3)){
            System.out.print("Please input your hand! 0:Rock 1:Scissors 2:Paper\n Your hand is : ");
            player_hand = Integer.parseInt(scan.nextLine());
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
                            playerVictoryNum++;
                            break;
                        case 2:
                            System.out.println(PURPLE + "Enemy win!");
                            enemyVictoryNum++;
                            break;
                        default:
                            break;
                    }
                    break;
                case 1:
                    switch (enemy_hand) {
                        case 0:
                            System.out.println(GREEN + "Enemy win!");
                            enemyVictoryNum++;
                            break;
                        case 1:
                            System.out.println(YELLOW + "Draw!");
                            break;
                        case 2:
                            System.out.println(PURPLE + "You win!");
                            playerVictoryNum++;
                            break;
                        default:
                            break;
                    }
                    break;
                case 2:
                    switch (enemy_hand) {
                        case 0:
                            System.out.println(YELLOW + "You win!");
                            playerVictoryNum++;
                            break;
                        case 1:
                            System.out.println(PURPLE + "Enemy win!");
                            enemyVictoryNum++;
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
            System.out.println("Number of wins  You:" + playerVictoryNum + "  Enemy:" + enemyVictoryNum);
		}
        scan.close();
        if(playerVictoryNum == 3){
            System.out.println("You won 3 times first, so You  win");
        } else if(enemyVictoryNum == 3){
            System.out.println("Your opponent won 3 times first, so you lose");
        } 
	}

	// 受け取った範囲でランダムな数値を生成
	private static int getRandomInt(int range) {
		Random random = new Random();
		int random_num = random.nextInt(range);
		return random_num;
	}
}
