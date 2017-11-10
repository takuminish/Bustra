package Game.Enemy;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import Base.GameEnvironment;
import Base.Panel;
public class Enemy extends Panel{
	
	protected BufferedImage image;               // この変数に対応する画像が入るよ
	private GameEnvironment environment;
	protected int id;                            // Dropの種類ごとにIDを割り振るよ
	private int x;                               // Dropはx座標を持つよ
	private int y;                               // Dropはy座標を持つよ
	private int width;
	private int height;
	
	public Enemy() {
		this.x = 100;
		this.y = 25;
		this.width = 150;
		this.height = 150;
	}
	
	// 画像をimage変数に入れる(画像ファイルを引数とする)
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

		public void paintComponent(Graphics g) {
			
			this.setBounds(this.x, this.y, this.width, this.height);     // 指定したx,y座標と縦横の大きさから表示する位置を決めるよ
			g.drawImage(this.image,0,0,this.width,this.height,null); //image変数の画像を表示するよ
		}
}
