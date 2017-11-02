package Game;

import java.awt.event.MouseEvent;

import Base.Player;

public class GamePlayer extends Player{

	public GamePlayer() {
		super();
	}
	
	// マウスが押された時
    public void mousePressed(MouseEvent e){
    	int mouseX = e.getX();
    	int mouseY = e.getY();
    	
    	System.out.println(mouseX + "," + mouseY);
    }
       
    // マウスが押された状態から離れた時
    public void mouseReleased(MouseEvent e){}
    
    // マウスをドラッグした時(クリックしたまま動かす)
    public void mouseDragged(MouseEvent e){}
	
	
}
