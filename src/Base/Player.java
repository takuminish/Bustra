package Base;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;

// Panelクラスを継承し、マウス操作を可能にしたPlayerクラスを作るよ
public class Player extends Panel implements MouseListener,MouseMotionListener{
	
	// コンストラクタ
	public Player() {

	}
	
	// マウスがパネルの上に乗った時(今回は使わない)
	public void mouseEntered(MouseEvent e){}

	// マウスがパネルの外に出た時(今回は使わない)
	public void mouseExited(MouseEvent e){}

	// マウスが押された時(ゲーム画面で使用)
    public void mousePressed(MouseEvent e){}
       
    // マウスが押された状態から離れた時
    public void mouseReleased(MouseEvent e){}

    // マウスがクリックされた時
    public void mouseClicked(MouseEvent e){}
	  
    // マウスをドラッグした時(クリックしたまま動かす)
    public void mouseDragged(MouseEvent e){}

    // マウスを動かした時(今回は使わない)
    public void mouseMoved(MouseEvent e){}
}
