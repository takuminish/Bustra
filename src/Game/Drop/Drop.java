package Game.Drop;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

import Base.Panel;

// Panelクラスを継承したDropクラスを作るよ
public class Drop extends Panel{
	
	protected int id;                            // Dropの種類ごとにIDを割り振るよ
	private final int DIAMETER = 80;                // Dropの直径の大きさだよ

	private int x;                               // Dropはx座標を持つよ
	private int y;                               // Dropはy座標を持つよ
	protected BufferedImage image;               // この変数に対応する画像が入るよ
	
	// コンストラクタ
	public Drop(int x, int y) {
		this.x = x;                              // x座標を指定するよ
		this.y = y;                              // y座標を指定するよ
		this.setBounds(x, y, DIAMETER, DIAMETER);     // 指定したx,y座標と縦横の大きさから表示する位置を決めるよ
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
	
	// Dropの直径の長さを取ってくるよ
	public int getDiameter() {
		return this.DIAMETER;
	}

	// ドロップを表示するよ
	@Override
	public void paintComponent(Graphics g) {
		g.drawImage(this.image,0,0,this.getDiameter(),this.getDiameter(),null); //image変数の画像を表示するよ
	}
	

}
