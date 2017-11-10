package Game;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import Base.GameEnvironment;
import Base.Player;
import Game.Manager.BoardManager;
import Game.Manager.FieldManager;

public class GamePlayer extends Player{

	private BoardManager Bmanager;
	private FieldManager Fmanager;
	private GameEnvironment environment;
	
	public GamePlayer(BoardManager Bmanager, FieldManager Fmanager) {
		super();
		this.environment = new GameEnvironment();
		this.Bmanager = Bmanager;
		this.Fmanager = Fmanager;
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
    	int mouseY = e.getY() - this.environment.getBoardPosition();
    	dropMove(mouseX,mouseY);
    }
    
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if ( e.getKeyCode() == KeyEvent.VK_ENTER ) {
	    	this.Fmanager.ChangeText("aaaaaaa");
	    }
	}
    
    // GameManagerのメソッドを呼び出してドロップを持つよ
	public void dropHold(int mouseX,int mouseY) {
		mouseY -= this.environment.getBoardPosition();
	    this.Bmanager.holdManagement(mouseX, mouseY);
	}
	
	// GameManagerのメソッドを呼び出してドロップを動かすよ
	public void dropMove(int mouseX,int mouseY) {
	   this.Bmanager.MoveManagement(mouseX, mouseY);
	}
	
	// GameManagerのメソッドを呼び出してドロップを放すよ
		public void dropLost() {
			this.Bmanager.dropDelete(this.Bmanager.comboDicision());
			
		    this.Bmanager.LostManagement();
		}
	
	
}
