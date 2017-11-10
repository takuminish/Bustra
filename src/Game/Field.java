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
        this.frame = new TextFrame();
        this.add(this.frame);
        this.add(this.pisaro);
        this.pisaro.setBounds(0,0,150,150);
        this.frame.setBounds(0,200,200,100);
    }
    public void TextChange(String str) {
    	this.frame.ChangeText(str);
    }
    public void paintComponent(Graphics g) {
    	this.setBounds(0, 0, 360, 260);  // Žw’è‚µ‚½ˆÊ’u‚Æ‘å‚«‚³‚Å”Õ–Ê‚ð•\Ž¦‚·‚é‚æ
    	g.setColor(Color.BLACK);
    	g.fillRect(0, 0, getWidth(), getHeight());

    }
}
