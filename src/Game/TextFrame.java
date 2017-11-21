package Game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;

import javax.imageio.ImageIO;

import Base.GameEnvironment;
import Base.Panel;
public class TextFrame extends Panel{
	protected BufferedImage image;               // この変数に対応する画像が入るよ
	private Text text;
	
	public TextFrame(String enemyName, int norma) {
		super();
		URL url = getClass().getClassLoader().getResource("DQ_frame.png");
		this.image = Image(url);
		this.text = new Text("<html>" + enemyName + "が現れた。<br>" + norma + "コンボ以上で攻撃成功!!</html>");
		this.add(this.text);
		this.text.setBounds(GameEnvironment.TEXTX,GameEnvironment.TEXTY,GameEnvironment.TEXTWIDTH,GameEnvironment.TEXTHEIGHT);
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
	
	public void ChangeText(String str) {
		this.text.change(str);
		
	}
	
    public void paintComponent(Graphics g) {
		g.drawImage(this.image,0,0,GameEnvironment.TEXTFRAMEWIDTH,GameEnvironment.TEXTFRAMEHEIGHT,null); //image変数の画像を表示するよ
    }
    
    public void gameover() {
    	this.text.change("プレイヤーはしんでしまった");
    	this.text.setForeground(Color.RED);
    	URL url = getClass().getClassLoader().getResource("DQ_frame_red.png");
		this.image = Image(url);
		repaint();
    }
}
