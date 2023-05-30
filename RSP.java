import javax.swing.JFrame;
import java.net.*;
import java.io.*;
import javax.swing.*;
import java.lang.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
 
public class RSP extends JFrame implements MouseListener,MouseMotionListener{
    
    private JLayeredPane c;
    private static JLabel ene, me, result;
    private JButton block, scissors, paper, udown, num;
    
    
	public RSP(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("じゃんけんゲーム");
		setSize(340,600);
        c = new JLayeredPane();
        this.getContentPane().add(c);
		c.setLayout(null);//自動レイアウトの設定を行わない
        
        
        block = new JButton();
        block.setText("グー");
        c.add(block);
        block.setBounds(20,500,80,50);
        block.addMouseListener(this);
        block.setActionCommand(Integer.toString(0));
        
        scissors = new JButton();
        scissors.setText("チョキ");
        c.add(scissors);
        scissors.setBounds(120,500,80,50);
        scissors.addMouseListener(this);
        scissors.setActionCommand(Integer.toString(1));
        
        paper = new JButton();
        paper.setText("パー");
        c.add(paper);
        paper.setBounds(220,500,80,50);
        paper.addMouseListener(this);
        paper.setActionCommand(Integer.toString(2));
        
        me = new JLabel();
        me.setText("YOU");
        c.add(me);
        me.setFont(new Font(Font.DIALOG_INPUT, Font.PLAIN, 25));
        me.setBounds(140,400,100,100);
        
        ene = new JLabel();
        ene.setText("ENEMY");
        c.add(ene);
        ene.setFont(new Font(Font.DIALOG_INPUT, Font.PLAIN, 25));
        ene.setBounds(140,50,100,100);
        
        result = new JLabel();
        result.setText("RESULT");
        c.add(result);
        result.setFont(new Font(Font.DIALOG_INPUT, Font.PLAIN, 25));
        result.setBounds(140,200,300,100);
        
		c.setVisible(true);
        
    }
    
    public static void main(String[] args) {
        
        RSP rsp = new RSP();
        rsp.setVisible(true);
        
    }
    
    public void mouseClicked(MouseEvent e) {//ボタンをクリックしたときの処理
        JButton theButton = (JButton)e.getComponent();//クリックしたオブジェクトを得る．型が違うのでキャストする
        String index = theButton.getActionCommand();//ボタンの配列の番号を取り出す
        int temp = Integer.parseInt(index);
        
        //自分の手がグー
        if(temp == 0){
            int ene_hand = getRandomInt(2);
            setenemy(ene_hand);
            me.setText("グー");
            judege(temp,ene_hand);
        }
        
        //自分の手がチョキ
        if(temp == 1){
            int ene_hand = getRandomInt(2);
            setenemy(ene_hand);
            me.setText("チョキ");
            judege(temp,ene_hand);
        }
        
        //自分の手がパー
        if(temp == 2){
            int ene_hand = getRandomInt(2);
            setenemy(ene_hand);
            me.setText("パー");
            judege(temp,ene_hand);
        }
    }
    
    public void mouseEntered(MouseEvent e) {//マウスがオブジェクトに入ったときの処理
	}
	public void mouseExited(MouseEvent e) {//マウスがオブジェクトから出たときの処理
	}
	public void mousePressed(MouseEvent e) {//マウスでオブジェクトを押したときの処理（クリックとの違いに注意）
	}
	public void mouseReleased(MouseEvent e) {//マウスで押していたオブジェクトを離したときの処理
	}
	public void mouseDragged(MouseEvent e) {//マウスでオブジェクトとをドラッグしているときの処理
	}
	public void mouseMoved(MouseEvent e) {//マウスがオブジェクト上で移動したときの処理
	}
    
    
    
    // 受け取った範囲でランダムな数値を生成
	private static int getRandomInt(int range) {
		Random random = new Random();
		int random_num = random.nextInt(range);
		return random_num;
	}
    
    //敵の手の設定
    private static void setenemy(int ene_hand){
        if(ene_hand == 0){
            ene.setText("グー");
        } else if(ene_hand == 1){
            ene.setText("チョキ");
        } else {
            ene.setText("パー");
        }
    }
    
    //自分の手の設定
    private static void setme(int me_hand){
        if(me_hand == 1){
            me.setText("グー");
        } else if(me_hand == 2){
            me.setText("チョキ");
        } else {
            me.setText("パー");
        }
    }
    
    
    //勝敗判定
    private static void judege (int player_hand,int enemy_hand){
        
    	switch (player_hand) {
		case 0:
			switch (enemy_hand) {
				case 0:
					result.setText("Draw!");
					break;
				case 1:
					result.setText("You win!");
					break;
				case 2:
					result.setText("Enemy win!");
					break;
				default:
					break;
			}
			break;
		case 1:
			switch (enemy_hand) {
				case 0:
					result.setText("Enemy win");
					break;
				case 1:
					result.setText("Draw!");
					break;
				case 2:
					result.setText("You win!");
					break;
				default:
					break;
			}
			break;
		case 2:
			switch (enemy_hand) {
				case 0:
					result.setText("You win!");
					break;
				case 1:
					result.setText("Enemy win");
					break;
				case 2:
					result.setText("Draw!");
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


