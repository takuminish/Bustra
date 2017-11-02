package Game;

import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;
import Base.Panel;
import Game.Drop.WaterDrop;
import Game.Drop.*;

public class Board extends Panel{
    
	private ArrayList<ArrayList<Drop>> board;
	private final int width;
	private final int height;
	
	
	public Board(int width, int height) {
		
		this.width = width;
		this.height = height; 
    	 board = new ArrayList<ArrayList<Drop>>();
    	 
    	 for (int k1 = 0; k1 < this.height; k1++) {
    		 this.board.add(new ArrayList<Drop>());
    		 for (int k2 = 0; k2 < this.width; k2++) {
    			 int ran = (int)(Math.random()* 5);
    			 switch(ran) {
    			 case 0: this.board.get(k1).add(new FireDrop(k2 * 80, k1 * 80)); break; 
    			 case 1: this.board.get(k1).add(new WaterDrop(k2 * 80, k1 * 80)); break;
    			 case 2: this.board.get(k1).add(new WoodDrop(k2 * 80, k1 * 80)); break;
    			 case 3: this.board.get(k1).add(new DarkDrop(k2 * 80, k1 * 80)); break;
    			 case 4: this.board.get(k1).add(new LightDrop(k2 * 80, k1 * 80)); break;
    			 }
    		 }
    	 }
    }
	
	@Override
	public void paintComponent(Graphics g) {
		this.setBounds(0, 0, this.width * 80, this.height * 80);
		for(int k1 = 0; k1 < this.height; k1++) {
			for (int k2 = 0; k2 < this.width; k2++) {
				this.add(this.board.get(k1).get(k2));
			}
		}
		// repaint();
	}
	
}
