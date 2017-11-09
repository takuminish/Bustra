package Game;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JLabel;

import Base.Panel;
import Game.Enemy.Pisaro;

public class Field extends Panel{
    private NormaText norma;
    private JLabel text;
	private Pisaro pisaro;
    
    public Field() {
    	this.norma = new NormaText();
    	this.add(this.norma);
	    pisaro = new Pisaro();
        this.add(this.pisaro);
    }
    
    public void paintComponent(Graphics g) {
    	g.setColor(Color.BLACK);
    	g.fillRect(0, 0, getWidth(), getHeight());
    	this.setBounds(0, 0, 377, 250);  // Žw’è‚µ‚½ˆÊ’u‚Æ‘å‚«‚³‚Å”Õ–Ê‚ð•\Ž¦‚·‚é‚æ

    }
}
