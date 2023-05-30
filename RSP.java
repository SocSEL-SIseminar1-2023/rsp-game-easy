import java.util.Random;
import java.util.Scanner;


public class RSP {
	public static void main(String[] args) {
		// テキストに使う色の宣言
		final String GREEN = "\u001b[00;32m";
		final String YELLOW = "\u001b[00;33m";
		final String PURPLE = "\u001b[00;34m";

        int player_hand;
        Scanner scan = new Scanner(System.in);
        while(true){
            try{
                // プレイヤーの手を入力
                System.out.print("Please input your hand! 0:Rock 1:Scissors 2:Paper\n Your hand is : ");
                player_hand = Integer.parseInt(scan.nextLine());
                if(player_hand < 0 || player_hand > 2){
                    System.out.println("指定された範囲の値ではない数値が入力されました。正しい値を入力してください");
                    continue;
                }
                break;
            }catch(Exception e){
                System.out.println("型が異なる値が入力されました。正しい値を入力してください。");
            }
        }
        scan.close();

		// 相手の手を決定
		int enemy_hand = getRandomInt(2);
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
						break;
					case 2:
						System.out.println(PURPLE + "Enemy win!");
						break;
					default:
						break;
				}
				break;
			case 1:
				switch (enemy_hand) {
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
				switch (enemy_hand) {
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
	}

	// 受け取った範囲でランダムな数値を生成
	private static int getRandomInt(int range) {
		Random random = new Random();
		int random_num = random.nextInt(range);
		return random_num;
	}
}
