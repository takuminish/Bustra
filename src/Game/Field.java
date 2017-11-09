package Game;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JLabel;

import Base.Panel;
import Game.Enemy.Pisaro;

public class Field extends Panel{

	private Pisaro pisaro;
	private TextFrame frame;
    
    public Field() {

	    this.pisaro = new Pisaro();
        this.add(this.pisaro);
        this.frame = new TextFrame();
        this.add(this.frame);
    }
    
    public void paintComponent(Graphics g) {
    	g.setColor(Color.BLACK);
    	g.fillRect(0, 0, getWidth(), getHeight());
    	this.setBounds(0, 0, 377, 260);  // Žw’è‚µ‚½ˆÊ’u‚Æ‘å‚«‚³‚Å”Õ–Ê‚ð•\Ž¦‚·‚é‚æ

    }
}
