import java.util.Random;
import java.util.Scanner;

public class RSP {
	public static void main(String[] args) {
		

		// プレイヤーの手を入力
		Scanner scan = new Scanner(System.in);
        int player_hand;
        int playcontinue;
        do{
            do{//0~2で自分の手を入力（それ以外の手は再入力）
                System.out.print("Please input your hand! 0:Rock 1:Scissors 2:Paper\n Your hand is : ");
                player_hand = Integer.parseInt(scan.nextLine());
            }while(player_hand != 0 && player_hand != 1 && player_hand != 2);
            
    
            // 相手の手を決定
            int enemy_hand = getRandomInt(2);
            System.out.println(" Enemy hand is: " + enemy_hand);
            System.out.print("Result: ");

            // 勝敗判定
            judje(player_hand, enemy_hand);
            
            System.out.print("Do you continue this game? 1:Yes\n");
            playcontinue = Integer.parseInt(scan.nextLine());
        }while (playcontinue == 1);
        
        scan.close();
	}

	// 受け取った範囲でランダムな数値を生成
	private static int getRandomInt(int range) {
		Random random = new Random();
		int random_num = random.nextInt(range);
		return random_num;
	}

    public static void judje(int player_hand,int enemy_hand) {
        // テキストに使う色の宣言
		final String GREEN = "\u001b[00;32m";
		final String YELLOW = "\u001b[00;33m";
		final String PURPLE = "\u001b[00;34m";
        switch (player_hand) {
            case 0://Rock
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
            case 1://Seaser
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
            case 2://Paper
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
}
