package Select;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import Base.GameApp;
import Base.GameScene;
import Base.SoundPlayer;
import Base.Window;

public class SelectWindow extends Window implements ActionListener{
	
	private JLabel label;
	private SelectButton easy;
	private JButton normal;
	private JButton hard;
	private JButton back;
	private GameApp g;
	private SoundPlayer clickSound;
	
	public SelectWindow(int width, int height,GameApp g) {
		super(width,height);

		this.g = g;
		this.setBackground(Color.BLACK);
		this.easy = new SelectButton("easy.png","easy.png","easy.png");
		this.normal = new SelectButton("normal.png","normal.png","normal.png");
		this.hard = new SelectButton("hard.png","hard.png","hard.png");
		this.back = new SelectButton("back.png","back.png","back.png");
		this.clickSound = new SoundPlayer("enter.wav");
		this.add(this.easy);
		this.add(normal);
		this.add(hard);
		this.add(back);
		this.easy.addActionListener(
				 (ActionEvent e) -> {
						GameApp.scene = GameScene.game;
						this.clickSound.init();
						this.clickSound.play();
						g.change(this,"easy");

	                }
	        );
		this.normal.addActionListener(
				 (ActionEvent e) -> {
						GameApp.scene = GameScene.game;
						this.clickSound.init();
						this.clickSound.play();
						g.change(this,"normal");
	                }
	        );
		this.hard.addActionListener(
				 (ActionEvent e) -> {
						GameApp.scene = GameScene.game;
						this.clickSound.init();
						this.clickSound.play();
						g.change(this,"hard");
	                }
	        );
		this.back.addActionListener(
				 (ActionEvent e) -> {
						GameApp.scene = GameScene.title;
						this.clickSound.init();
						this.clickSound.play();
						g.change(this,"title");
	                }
	        );
		this.easy.setBounds(20,100,300,70);
		this.normal.setBounds(20,220,300,70);
		this.hard.setBounds(20,340,300,70);
		this.back.setBounds(260,0,100,40);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
}