import java.util.Random;
import java.util.Scanner;

public class RSP {
	public static void main(String[] args) {
		// テキストに使う色の宣言
		final String GREEN = "\u001b[00;32m";
		final String YELLOW = "\u001b[00;33m";
		final String PURPLE = "\u001b[00;34m";

        //ゲームモードの選択
        System.out.print("Please select game mode 0:Rock-Paper-Scissors 1:Osaka Rock-Paper-Scissors\n Game mode is :");
        Scanner scan = new Scanner(System.in);
        int play_mode = Integer.parseInt(scan.nextLine());
		// プレイヤーの手を入力
		System.out.print("Please input your hand! 0:Rock 1:Scissors 2:Paper\n Your hand is : ");
		int player_hand = Integer.parseInt(scan.nextLine());
		scan.close();

		// 相手の手を決定
		int enemy_hand = getRandomInt(3);
		System.out.println(" Enemy hand is: " + enemy_hand);

		System.out.print("Result: ");
		// 勝敗判定
        if(play_mode == 0){//Rock-Paper-Scissors
            if((player_hand == 0 && enemy_hand == 1) || (player_hand == 1 && enemy_hand == 2) || (player_hand == 2 && enemy_hand == 0)){
                System.out.println(YELLOW + "You win!");
            } else if((player_hand == 1 && enemy_hand == 0) || (player_hand == 2 && enemy_hand == 1) || (player_hand == 0 && enemy_hand == 2)){
                System.out.println(PURPLE + "Enemy win!");
            } else if((player_hand == enemy_hand)){
                System.out.println(GREEN + "Draw!");
            } else {
                System.out.println("error:Your input regarding your hand is incorrect");
            }
        } else if(play_mode == 1){//Osaka Rock-Paper-Scissors
            if((player_hand == 0 && enemy_hand == 1) || (player_hand == 1 && enemy_hand == 2) || (player_hand == 2 && enemy_hand == 0)){
                System.out.println(PURPLE + "Enemy win!");
            } else if((player_hand == 1 && enemy_hand == 0) || (player_hand == 2 && enemy_hand == 1) || (player_hand == 0 && enemy_hand == 2)){
                System.out.println(YELLOW + "You win!");
            } else if((player_hand == enemy_hand)){
                System.out.println(GREEN + "Draw!");
            } else {
                System.out.println("error:Your input regarding your hand is incorrect");
            }
        } else {
            System.out.println("error:Your input regarding game mode is incorrect");
        }
	}

	// 受け取った範囲でランダムな数値を生成
	private static int getRandomInt(int range) {
		Random random = new Random();
		int random_num = random.nextInt(range);
		return random_num;
	}
}
