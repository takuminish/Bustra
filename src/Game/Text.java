package Game;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JLabel;

public class Text extends JLabel{

	public Text(String str) {
		super(str);
    	this.setForeground(Color.WHITE);
	}
	
	public void change(String str) {
		
		this.setText(str);
	}

}