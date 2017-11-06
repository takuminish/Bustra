package Game;

import java.awt.event.MouseEvent;

import Base.Player;

public class GamePlayer extends Player{

	private GameManager manager;
	private GameEnvironment environment;
	
	public GamePlayer(GameManager manager) {
		super();
		environment = new GameEnvironment();
		this.manager = manager;
	}
	
	// マウスが押された時
    public void mousePressed(MouseEvent e){
    	int mouseX = e.getX();
    	int mouseY = e.getY();
    	dropHold(mouseX, mouseY);
    }
       
    // マウスが押された状態から離れた時
    public void mouseReleased(MouseEvent e){
    	dropLost();
    }
    
    // マウスをドラッグした時(クリックしたまま動かす)
    public void mouseDragged(MouseEvent e){
    	int mouseX = e.getX();
    	int mouseY = e.getY();
    	dropMove(mouseX,mouseY);
    }
    
    // GameManagerのメソッドを呼び出してドロップを持つよ
	public void dropHold(int mouseX,int mouseY) {
	    this.manager.holdManagement(mouseX, mouseY);
	}
	
	// GameManagerのメソッドを呼び出してドロップを動かすよ
	public void dropMove(int mouseX,int mouseY) {
	   this.manager.MoveManagement(mouseX, mouseY);
	}
	
	// GameManagerのメソッドを呼び出してドロップを放すよ
		public void dropLost() {
			this.manager.dropDelete(this.manager.comboDicision());
			
		    this.manager.LostManagement();
		}
	
	
}
