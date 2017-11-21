package Game.Drop;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import Base.GameEnvironment;
import Base.Panel;

// Panelクラスを継承したDropクラスを作るよ
public class Drop extends Panel{
	
	protected int id;                            // Dropの種類ごとにIDを割り振るよ
	private final int diameter;                  // Dropの直径の大きさだよ
	private int x;                               // Dropはx座標を持つよ
	private int y;                               // Dropはy座標を持つよ
	protected BufferedImage image;               // この変数に対応する画像が入るよ
	protected BufferedImage invisibleImage;
	private Boolean hold = false;                // 現在マウスで持っているかどうかの状態を表す             
	private Boolean visible = true;
	
	// コンストラクタ
	public Drop(int x, int y) {
		this.x = x;                                             // x座標を指定するよ
		this.y = y;                                             // y座標を指定するよ
		this.diameter = GameEnvironment.DROPDIAMETER;
	}
	
	// 画像をimage変数に入れる(画像ファイルを引数とする)
	public BufferedImage Image(URL url) {
		BufferedImage image = null;              // 最初はnullにしておくよ
		try {
			  image = ImageIO.read(url);           // 画像を参照できれば画像をimage変数に入れるよ
			  invisibleImage = ImageIO.read( getClass().getClassLoader().getResource("invisible.png"));
			} catch (Exception e) {
			  e.printStackTrace();               // エラー出力を行うよ
			  image = null;                      // エラーだったらimage変数はnullのままだよ
			}
		return image;                            // image変数を返すよ
	}

	// ドロップの状態を返すよ
	public boolean getHold() {
		return this.hold;
	}
	
	public void paint() {
		this.paint(this.getGraphics());
	}

	// ドロップを表示するよ
	@Override
	public void paintComponent(Graphics g) {
		if (this.visible) {
			this.setBounds(0, 0, this.diameter, this.diameter);     // 指定したx,y座標と縦横の大きさから表示する位置を決めるよ
			g.drawImage(this.image,(this.x % this.diameter) - (this.diameter / 2),(this.y % this.diameter) - (this.diameter / 2),this.diameter,this.diameter,null); //image変数の画像を表示するよ
		} else {
			this.setBounds(0, 0, this.diameter, this.diameter);     // 指定したx,y座標と縦横の大きさから表示する位置を決めるよ
			g.drawImage(this.invisibleImage,(this.x % this.diameter) - (this.diameter / 2),(this.y % this.diameter) - (this.diameter / 2),this.diameter,this.diameter,null); //image変数の画像を表示するよ
		}
	}
	
	// ドロップを削除するよ
	public void setInvisible() {
		this.visible = false;
	}
	
	// ドロップを持つよ
	public void hold(int x, int y) {
		this.hold = true;
		this.x = x;
		this.y = y;
		repaint();
	}
	
	
	// ドロップを動かすよ
	public void move(int x, int y) {
		this.x = x;
	    this.y = y;
		repaint();
	}
	
	// ドロップを放すよ
		public void lost(int x, int y) {
			if (this.hold == true) {
			    this.x = x;
			    this.y = y;
			}
			this.hold = false;
			System.out.println("a");
			repaint();
		}
		
		public boolean getVisible() {
			return this.visible;
		}
		
		public int getId() {
			return this.id;
		}
		public void setId() {
			this.id = -1;
		}
}