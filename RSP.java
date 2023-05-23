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
        switch(player_hand) {
        	case 0:
        		switch(enemy_hand) {
	        		case 0:
	        			System.out.println("あいこです");
	        			break;
	        		case 1:
	        			System.out.println("あなたの勝ちです");
	        			break;
	        		case 2:
	        			System.out.println("相手の勝ちです");
	        			break;
	        		default:
	        			break;
        		}
        		break;
        	case 1:
        		switch(enemy_hand) {
        		case 0:
        			System.out.println("あいこです");
        			break;
        		case 1:
        			System.out.println("相手の勝ちです");
        			break;
        		case 2:
        			System.out.println("あなたの勝ちです");
        			break;
        		default:
        			break;
	    		}
	    		break;
        	case 2:
        		switch(enemy_hand) {
        		case 0:
        			System.out.println("あなたの勝ちです");
        			break;
        		case 1:
        			System.out.println("相手の勝ちです");
        			break;
        		case 2:
        			System.out.println("あいこです");
        			break;
        		default:
        			break;
	    		}
	    		break;
	    	default:
	    		break;
        }
	}
	
	//受け取った範囲でランダムな数値を生成
	private static int getRandomInt(int range) {
		Random random = new Random();
        int random_num = random.nextInt(range);
		return random_num;
	}
}