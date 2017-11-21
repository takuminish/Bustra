package Title;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Color;
import javax.swing.border.BevelBorder;

import Base.GameApp;
import Base.GameEnvironment;
import Base.GameScene;
import Base.SoundPlayer;
import Base.Window;
import Game.Drop.DarkDrop;
import Game.Drop.Drop;
import Game.Drop.FireDrop;
import Game.Drop.LightDrop;
import Game.Drop.WaterDrop;
import Game.Drop.WoodDrop;

public class TitleWindow extends Window implements MouseListener {

	private TitleLogo logo;
	private TitleDrop[] drop = new TitleDrop[5];
	private GameApp g;
	private SoundPlayer clickSound;

	public TitleWindow(int width, int height, GameApp g) {
		super(width, height);
		addMouseListener(this);
		this.g = g;
		this.clickSound = new SoundPlayer("enter.wav");
		this.setBackground(Color.BLACK);
		drop[0] = new TitleDrop("fire.png", 80, 80);
		drop[1] = new TitleDrop("wood.png", 80, 80);
		drop[2] = new TitleDrop("water.png", 80, 80);
		drop[3] = new TitleDrop("dark.png", 80, 80);
		drop[4] = new TitleDrop("light.png", 80, 80);
		this.add(drop[0]);
		this.add(drop[1]);
		this.add(drop[2]);
		this.add(drop[3]);
		this.add(drop[4]);
		int r = 100;
		for (int k = 0; k < 5; k++) {
			double kakudo = (((k * 2 * Math.PI) / 5) - (Math.PI / 2));
			drop[k].setBounds((int) ((((GameEnvironment.WINDOWWIDTH / 2) - 50) + (r * Math.cos(kakudo)))),
					(int) (((GameEnvironment.WINDOWHEIGHT / 2) + (r * Math.sin(kakudo)))), 80, 80);
			System.out.println(kakudo);
		}
		logo = new TitleLogo();
		this.add(logo);
		logo.setBounds((GameEnvironment.WINDOWWIDTH / 2) - 185, (GameEnvironment.WINDOWHEIGHT / 2) - 250, 350, 150);

	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		GameApp.scene = GameScene.select;
		clickSound.init();
		clickSound.play();
		g.change(this, "select");
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

}
