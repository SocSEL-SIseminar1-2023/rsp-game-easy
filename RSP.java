import java.util.Random;
import java.util.Scanner;

public class RSP2 {
	public static void main(String[] args) {
        int player_hand, enemy_hand;
        int judge, sum_player, sum_enemy, goal, stars;
        int[] steps = {3, 6, 6};
        String[] display_rsp = {"グー", "チョキ", "パー"};
        String[] display_guriko = {"グリコ", "チョコレート", "パイナップル"};
        Scanner scan = new Scanner(System.in);
        
        //ゴールの設定
        while (true) {
            System.out.print("ゴールの歩数を設定してください。>> ");
            goal = scan.nextInt();
            if (goal <= 0) {
                System.out.println("1歩以上を入力してください。>> ");
                continue;
            } else {
                break;
            }
        }
        System.out.println();
        
        //変数の初期化及び、初期確立の設定
        sum_enemy = 0;
        sum_player = 0;
        
        //CPUもしくはPlAYERがゴールするまでループ
        while (true) {
            
            // プレイヤーの手を入力
            while (true) {
                System.out.print("あなたの手を入力してください。  0:グー  1:チョキ  2:パー\nあなた >> ");
                player_hand = scan.nextInt();
                if ((player_hand != 0) && (player_hand != 1) && (player_hand != 2)) {
                    System.out.println("0,1,2で入力してください。");
                    continue;
                } else {
                    break;
                }
            }
            // 相手の手を決定
            enemy_hand = getRandomInt(2);
        
            // 勝敗判定
            judge = (player_hand - enemy_hand + 3) % 3;
            if (judge == 0) {
                System.out.println("あなたは" + display_rsp[player_hand] + "を出しCPUは" + display_rsp[enemy_hand] + "を出したので" + "あいこです。");
            } else {
                if (judge == 1) {
                    System.out.println("あなたは" + display_rsp[player_hand] + "を出しCPUは" + display_rsp[enemy_hand] + "を出したので" + "あなたの負けです。");
                    System.out.println("CPUは" + display_guriko[enemy_hand] + "で" + steps[enemy_hand] + "歩進みます。\n");
                    sum_enemy = sum_enemy + steps[enemy_hand];
                } else {
                    System.out.println("あなたは" + display_rsp[player_hand] + "を出しCPUは" + display_rsp[enemy_hand] + "を出したので" + "あなたの勝ちです。");
                    System.out.println("あなたは" + display_guriko[player_hand] + "で" + steps[player_hand] + "歩進みます。\n");
                    sum_player = sum_player + steps[player_hand];
                }
                System.out.println("          |      1/4     1/2     3/4       |");
                System.out.println("----------+-------+-------+-------+--------+----------");
                System.out.print("  Player  |");
                if (sum_player > goal) {
                    for (int i = 0; i < 16; i++) {
                        System.out.print(" *");
                    }
                } else {
                    stars = 16 * sum_player / goal;
                    for (int i = 0; i < stars; i++) {
                        System.out.print(" *");
                    }
                    for (int i = 0; i < 16 - stars; i++) {
                        System.out.print("  ");
                    }
                }
                System.out.println("|  " + sum_player + "/" + goal);
                System.out.print("  CPU     |");
                if (sum_enemy > goal) {
                    for (int i = 0; i < 16; i++) {
                        System.out.print(" *");
                    }
                } else {
                    stars = 16 * sum_enemy / goal;
                    for (int i = 0; i < stars; i++) {
                        System.out.print(" *");
                    }
                    for (int i = 0; i < 16 - stars; i++) {
                        System.out.print("  ");
                    }
                }
                System.out.println("|  " + sum_enemy + "/" + goal + "\n");
            }
        
            //どちらかがゴールをしていないかの確認
            if ((sum_enemy < goal) && (sum_player < goal)) {
                System.out.println("あなたは" + sum_player + "歩進み、CPUは" + sum_enemy + "歩進みました。");
            } else {
                //結果出力
                if (sum_enemy >= goal) {
                    System.out.println("ゴールは" + goal + "歩で、合計" + sum_enemy + "歩進んだCPUの勝ちです。");
                } else {
                    System.out.println("ゴールは" + goal + "歩で、合計" + sum_player + "歩進んだあなたの勝ちです。");
                }
                break;
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
