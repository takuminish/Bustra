package Title;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.net.URL;

import javax.imageio.ImageIO;

import Base.Panel;

public class TitleLogo extends Panel{

	private BufferedImage image; 
	
	public TitleLogo() {
		this.image = Image(getClass().getClassLoader().getResource("logo.png"));
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
		
		g.drawImage(this.image,0,0,350,150,null); //image変数の画像を表示するよ
	}
}
