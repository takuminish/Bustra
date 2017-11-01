import java.awt.Graphics;
import java.awt.Graphics2D;
import Game.Drop.*;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import Base.Window;
public class Main {
    public static void main(String[] args) {
    	SwingUtilities.invokeLater(() -> {
			GameFrame gameframe = new GameFrame();
			Window gamewindow = new Window();

			gameframe.add(gamewindow);
			gameframe.pack();
			gameframe.setVisible(true);


			gameframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		});
    }
    
    public void paint(Graphics g){
        Graphics2D g2 = (Graphics2D)g;
        FireDrop drop = new FireDrop(40,40);
        if (drop.Image != null){
            g2.drawImage(drop.Image, 0, 0, this);
          }
    
    }
}
