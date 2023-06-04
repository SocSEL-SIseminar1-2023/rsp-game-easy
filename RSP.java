import java.util.Random;
import java.util.Scanner;

public class RSP {
	public static void main(String[] args) {
		// テキストに使う色の宣言
        final String BLACK = "\u001b[00;10m";
        final String RED = "\u001b[00;31m";
		final String GREEN = "\u001b[00;32m";
		final String YELLOW = "\u001b[00;33m";
		final String PURPLE = "\u001b[00;34m";
        
        //現状の勝敗結果を管理する変数の宣言
        int win = 0, draw = 0, lose = 0;

	//必勝モードか判定するフラグの宣言
        boolean nmode = false;

        Scanner scan = new Scanner(System.in);

        //再戦機能の追加
        while(true){

		    // プレイヤーの手を入力
            System.out.print("Please input your hand! 0:Rock 1:Scissors 2:Paper\n Your hand is : ");
            int player_hand;
		    while(true){//0から2までの整数値を入力しなかった場合に再度入力要求する
		        String check_input = scan.nextLine();

                if((check_input.equals("0"))||(check_input.equals("1"))||(check_input.equals("2"))){
                    player_hand = Integer.parseInt(check_input);
                    break;
                } else {
                    System.out.print("Please input again!\n Your hand is : ");
                }
            }

		// 相手の手を決定
		//必勝モードか否か
            if(nmode){
                System.out.print(" Enemy hand is: ");
                switch(player_hand){
                    case 0:
                        System.out.println("1");
                        break;
                    case 1:
                        System.out.println("2");
                        break;
                    case 2:
                        System.out.println("0");
                        break;
                    default:
                        break;
                }
                System.out.println("Result: "+ YELLOW + "You win!");
                win++;
            } else {

		        int enemy_hand = getRandomInt(3);//相手が0か1しか返さないバグの修正
		        System.out.println(" Enemy hand is: " + enemy_hand);

		        System.out.print("Result: ");
		        // 勝敗判定
		        switch (player_hand) {
			        case 0:
				        switch (enemy_hand) {
					        case 0:
						        System.out.println(GREEN + "Draw!");
                                draw++;
						        break;
					        case 1:
						        System.out.println(YELLOW + "You win!");
                                win++;
						        break;
					        case 2:
						        System.out.println(PURPLE + "Enemy win!");
                                lose++;
						        break;
					        default:
						        break;
				        }
				        break;
			        case 1://正しい判定結果になっていなかったので修正
				        switch (enemy_hand) {
					        case 0:
                                System.out.println(PURPLE + "Enemy win!");
                                lose++;
					        	break;
					        case 1:
                                System.out.println(GREEN + "Draw!");
                                draw++;
					        	break;
				    	    case 2:
                                System.out.println(YELLOW + "You win!");
                                win++;
					        	break;
				    	    default:
					        	break;
				        }
				        break;
			        case 2:
				        switch (enemy_hand) {
					        case 0:
						        System.out.println(YELLOW + "You win!");
                                win++;
					        	break;
					        case 1:
					        	System.out.println(PURPLE + "Enemy win!");
                                lose++;
					        	break;
					        case 2:
					        	System.out.println(GREEN + "Draw!");
                                draw++;
					        	break;
					        default:
					        	break;
				        }
			    	    break;
			        default:
			    	    break;
		        }
            }

            //累計勝敗結果
            System.out.println(BLACK + "latest result: win/" + win + ", draw/" + draw + ", lose/" + lose);

            //累計敗北数が3の倍数になるたびに、必勝モードになる
            if(lose != 0 && lose % 3 == 0){
                nmode = true;
                System.out.println(RED + "HELPING: Nursing Mode in coming!!");
            } else {
                nmode = false;
            }

            //再戦確認
            System.out.print(BLACK + "input 'r' to retry or other ward to end games: ");
            String check_revenge = scan.nextLine();

            if((check_revenge.equals("r"))){
                System.out.println("Let's play again!\n");
            } else{
                System.out.println("Thank you for playing!\n");
                break;
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
