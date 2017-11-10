package Game;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import Base.Panel;
public class TextFrame extends Panel{
	protected BufferedImage image;               // この変数に対応する画像が入るよ
	private NormaText text;
	
	public TextFrame() {
		super();
		//this.setBounds(75,180,200,200);     // 指定したx,y座標と縦横の大きさから表示する位置を決めるよ
		File f = new File("image/DQ_frame.png");     // Fileクラスに枠の画像を入れるよ
		this.image = Image(f);
		this.text = new NormaText("<html>バスピサロが現れた。<br></html>");
		this.add(this.text);
		this.text.setBounds(0,0,200,50);
	}
	public BufferedImage Image(File f) {
		BufferedImage image = null;              // 最初はnullにしておくよ
		try {
			  image = ImageIO.read(f);           // 画像を参照できれば画像をimage変数に入れるよ
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
		g.drawImage(this.image,0,0,200,50,null); //image変数の画像を表示するよ
    }
}
