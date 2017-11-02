package Game;

import java.awt.event.MouseEvent;

import Base.Player;

public class GamePlayer extends Player{

	private int dropDiameter;
	
	public GamePlayer(int diameter) {
		super();
		this.dropDiameter = diameter;
	}
	
	// マウスが押された時
    public void mousePressed(MouseEvent e){
    	int mouseX = e.getX();
    	int mouseY = e.getY();
    	int dropX = mouseX / this.dropDiameter;
    	int dropY = mouseY / this.dropDiameter;
    }
       
    // マウスが押された状態から離れた時
    public void mouseReleased(MouseEvent e){}
    
    // マウスをドラッグした時(クリックしたまま動かす)
    public void mouseDragged(MouseEvent e){}
	
	
}
