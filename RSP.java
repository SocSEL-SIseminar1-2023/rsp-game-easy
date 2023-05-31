import java.util.Random;
import java.util.Scanner;

public class RSP {
	public static void main(String[] args) {
        int player_hand, enemy_hand;
        int judge, sum_player, sum_enemy, goal, stars;
        int identify_rock, identify_sci, identify_pap;
        int[] steps = {3, 6, 6};
        String[] display_rsp = {"Rock", "Scissors", "Paper"};
        String[] display_glico = {"Glico", "Chocolate", "Pineapple"};
        Scanner scan = new Scanner(System.in);
        
        //ゴールの設定
        while (true) {
            System.out.print("Please set the number of steps for the goal.>> ");
            goal = scan.nextInt();
            if (goal <= 0) {
                System.out.println("Your input is not accepted");
                continue;
            } else {
                break;
            }
        }
        System.out.println();
        
        //変数の初期化及び、初期確立の設定
        sum_enemy = 0;
        sum_player = 0;
        identify_rock = 1;
        identify_sci = 3;
        identify_pap = 5;
        
        //CPUもしくはPlAYERがゴールするまでループ
        while (true) {
            
            // プレイヤーの手を入力
            while (true) {
                System.out.print("Please input your hand! 0:Rock 1:Scissors 2:Paper\nYour hand is>> ");
                player_hand = scan.nextInt();
                if ((player_hand != 0) && (player_hand != 1) && (player_hand != 2)) {
                    System.out.println("Your input is not accepted");
                    continue;
                } else {
                    break;
                }
            }
            // 相手の手を決定
            enemy_hand = getRandomInt(identify_rock, identify_sci, identify_pap);
        
            // 勝敗判定
            judge = (player_hand - enemy_hand + 3) % 3;
            if (judge == 0) {
                System.out.println("Yourhand is " + display_rsp[player_hand] + ", enemyhand is " + display_rsp[enemy_hand] + ". Draw!");
            } else {
                if (judge == 1) {
                    System.out.println("Yourhand is " + display_rsp[player_hand] + ", enemyhand is " + display_rsp[enemy_hand] + ". Lose!");
                    System.out.println("Enemy moves " + steps[enemy_hand] + " steps with " + display_glico[enemy_hand] + ".\n");
                    sum_enemy = sum_enemy + steps[enemy_hand];
                } else {
                    System.out.println("Yourhand is " + display_rsp[player_hand] + ", enemyhand is " + display_rsp[enemy_hand] + ". Win!");
                    System.out.println("You move " + steps[player_hand] + " steps with " + display_glico[player_hand] + ".\n");
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
                //相手の手の学習
                if (player_hand == 0) {
                    identify_pap = 2 * identify_pap - identify_sci;
                } else if (player_hand == 1) {
                    identify_sci = identify_sci + identify_rock;
                    identify_pap = identify_pap + identify_rock;
                    identify_rock = 2 * identify_rock;
                } else {
                    identify_pap = identify_pap + identify_sci - identify_rock;
                    identify_sci = 2 * identify_sci - identify_rock;
                }
            } else {
                //結果出力
                if (sum_enemy >= goal) {
                    System.out.println("Goal is " + goal + " steps, and enemy takes " + sum_enemy + " steps to win!");
                } else {
                    System.out.println("Goal is " + goal + " steps, and you take " + sum_player + " steps to win!");
                }
                break;
            }
        }
	}

	// 受け取った範囲でランダムな数値を生成
	private static int getRandomInt(int identify_rock, int identify_sci, int identify_pap) {
        int enemy_hand;
		Random random = new Random();
		int random_num = random.nextInt(identify_pap);
        if (random_num < identify_rock) {
            enemy_hand = 0;
        } else if (random_num < identify_sci) {
            enemy_hand = 1;
        } else {
            enemy_hand = 2;
        }
		return enemy_hand;
	}
}
