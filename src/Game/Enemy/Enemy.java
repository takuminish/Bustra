package Game.Enemy;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import javax.swing.Timer;

import javax.imageio.ImageIO;

import Base.GameEnvironment;
import Base.Panel;
public class Enemy extends Panel implements ActionListener{
	
	protected BufferedImage image;               // この変数に対応する画像が入るよ
	protected int id;                            // Dropの種類ごとにIDを割り振るよ
	private int x;                               // Dropはx座標を持つよ
	private int y;                               // Dropはy座標を持つよ
	private int width;
	private int height;
	protected String name;
	protected int hp;
	protected  ArrayList<Integer> damagenorma;
	protected 	Timer timer = new Timer(10 , this);
	protected URL url;
	
	int a = 1;
	int s = 0;
	public Enemy() {
		this.x = 100;
		this.y = 25;
		this.width = 150;
		this.height = 150;
		this.damagenorma = new ArrayList<>();
		
	}
	
	// 画像をimage変数に入れる(画像ファイルを引数とする)
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
			
			g.drawImage(this.image,0,0,this.width,this.height,null); //image変数の画像を表示するよ
		}
		
		public void Damage() {
			this.hp--;
			timer.start();
			System.out.println(this.hp);
		}
		
		public int getNorma() {
			return this.damagenorma.get(this.hp-1);
		}
		
		public int getHp() {
			return this.hp;
		}
		
		public void clear() {
			this.url = getClass().getClassLoader().getResource("clear.png");
			this.image = this.Image(this.url);          // Dropクラスに定義されている関数からimageに画像を入れるよ
			repaint();
		}

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			if (this.s >= 2) {
				this.timer.stop();
				this.s = 0;
			} else {
				s++;
				if (a == 1) {
					URL url = getClass().getClassLoader().getResource("black.png");
					this.image = this.Image(url);          // Dropクラスに定義されている関数からimageに画像を入れるよ
					a = 2;
				} else {
					this.image = Image(this.url);
					a = 1;
				}
				repaint();
			}
		}
		
		public String getName() {
			return this.name;
		}
		
		public void setNorma() {}
		
}
