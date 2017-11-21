package Game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;

import javax.imageio.ImageIO;

import Base.GameEnvironment;
import Base.Panel;
public class PlayerFrame extends Panel{
	
	private BufferedImage image;
	private Text nameText;
	private Text HPText;
	private Text statusText;
	
	public PlayerFrame (int PlayerHP) {
		super();
		this.nameText = new Text("プレイヤー");
		this.HPText = new Text("Ｈ:  " + PlayerHP);
		this.statusText = new Text("ゆ:  ");
		URL url = getClass().getClassLoader().getResource("Play_frame.png");     // Fileクラスに枠の画像を入れるよ
		System.out.println(url);
		this.image = Image(url);
		this.add(this.nameText);
		this.nameText.setBounds(10,0,100,20);
		this.add(this.HPText);
		this.HPText.setBounds(10,30,100,20);
		this.add(this.statusText);
		this.statusText.setBounds(10,50,100,20);
	}
	public BufferedImage Image(URL url) {
		BufferedImage image = null;              // 最初はnullにしておくよ
		try {
			  image = ImageIO.read(url);           // 画像を参照できれば画像をimage変数に入れるよ
			} catch (Exception e) {
			  e.printStackTrace();               // エラー出力を行うよ
			  image = null;                      // エラーだったらimage変数はnullのままだよ
			}
		return image;                            // image変数を返すよ
	}
	
	public void paintComponent(Graphics g) {
		g.drawImage(this.image,0,0,75,75,null); //image変数の画像を表示するよ
    }
	
	public void setHPText(int PlayerHP) {
		this.HPText.change("H:  " + PlayerHP);		
	}
	
	public void gameover() {
    	this.statusText.change("ゆ:  しに");
    	this.statusText.setForeground(Color.RED);
    	this.HPText.setForeground(Color.RED);
    	this.nameText.setForeground(Color.RED);
		URL url = getClass().getClassLoader().getResource("Play_frame_red.png");     // Fileクラスに枠の画像を入れるよ
		this.image = Image(url);
		repaint();
    }
}