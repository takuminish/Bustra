package Game;

import java.awt.Color;
import java.awt.Graphics;

import Base.Window;
import Game.Drop.FireDrop;

public class GameWindow extends Window{
	
	private Board board;

	public GameWindow() {
		super();		
		board = new Board(6,5);
	}
	
    public void paint(Graphics g){
        super.paint(g);
        this.setBounds(0, 0, 800, 600);
        this.add(this.board);
        
    }
}
