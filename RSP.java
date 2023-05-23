import java.util.Random;
import java.util.Scanner;

public class RSP {
	public static void main(String[] args) {
		//プレイヤーの手を入力
		System.out.println("あなたの手を入力してください．0:グー 1:チョキ 2: パー");
		Scanner scan = new Scanner(System.in);
        int player_hand = Integer.parseInt(scan.nextLine());
        scan.close();
        System.out.println("あなたの手は" + player_hand + "です");
        
        //相手の手を決定
        int enemy_hand = getRandomInt(2);
        System.out.println("相手の手は" + enemy_hand + "です");
        
        //勝敗判定
        if(player_hand == enemy_hand) {
        	System.out.println("あいこです");
        }
        if(player_hand == 0 && enemy_hand == 1) {
        	System.out.println("あなたの勝ちです");
        }
        if(player_hand == 1 && enemy_hand == 2) {
        	System.out.println("あなたの勝ちです");
        }
        if(player_hand == 2 && enemy_hand == 0) {
        	System.out.println("あなたの勝ちです");
        }
        if(player_hand == 0 && enemy_hand == 1) {
        	System.out.println("相手の勝ちです");
        }
        if(player_hand == 2 && enemy_hand == 1) {
        	System.out.println("相手の勝ちです");
        }
        if(player_hand == 0 && enemy_hand == 2) {
        	System.out.println("相手の勝ちです");
        }
	}
	
	//受け取った範囲でランダムな数値を生成
	private static int getRandomInt(int range) {
		Random random = new Random();
        int random_num = random.nextInt(range);
		return random_num;
	}
}