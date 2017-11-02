// Gameパッケージ
package Game;

import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JPanel;
import Base.Panel;
import Game.Drop.WaterDrop;
import Game.Drop.*;

// Panelクラスを継承したBoardクラスを作るよ
// ドロップを表示する盤面だよ(Boardクラスは複数のDropクラスを持つ)
public class Board extends Panel{
    
	private ArrayList<ArrayList<Drop>> board;             // Dropクラスの2次元配列
	private final int width;                              // 盤面の横の長さ
	private final int height;                             // 盤面の縦の長さ
	private final int dropDiameter;                       // ドロップの直径の長さ
	
	// コンストラクタ
	public Board(int width, int height, int dropdiameter) {
		
		this.width = width;                               // 指定した値を横のドロップの数にするよ
		this.height = height;                             // 指定した値を縦のドロップの数にするよ
		this.dropDiameter = dropdiameter;                 // 指定した値をドロップの直径の長さにするよ
    	 board = new ArrayList<ArrayList<Drop>>();        // Dropクラスの2次元配列を定義するよ
    	 
    	 // 二重for文で二次元配列にDropクラスの子クラス(火、水、木、闇、光)を入れていくよ
    	 for (int k1 = 0; k1 < this.height; k1++) {
    		 this.board.add(new ArrayList<Drop>());       // Dropクラスの配列の中にDropクラスの配列を作るよ
    		 for (int k2 = 0; k2 < this.width; k2++) {
    			 // ランダムな値によってどのドロップにするか決めるよ
    			 switch(random()) {
    			 case 0: this.board.get(k1).add(new FireDrop(k2 * this.dropDiameter, k1 * this.dropDiameter)); break;  // ランダムの値が0だったら火ドロップを格納するよ 
    			 case 1: this.board.get(k1).add(new WaterDrop(k2 * this.dropDiameter, k1 * this.dropDiameter)); break; // ランダムの値が1だったら水ドロップを格納するよ   
    			 case 2: this.board.get(k1).add(new WoodDrop(k2 * this.dropDiameter, k1 * this.dropDiameter)); break;  // ランダムの値が2だったら木ドロップを格納するよ
    			 case 3: this.board.get(k1).add(new DarkDrop(k2 * this.dropDiameter, k1 * this.dropDiameter)); break;  // ランダムの値が3だったら闇ドロップを格納するよ
    			 case 4: this.board.get(k1).add(new LightDrop(k2 * this.dropDiameter, k1 * this.dropDiameter)); break; // ランダムの値が4だったら光ドロップを格納するよ
    			 }
    		 }
    	 }
    }
	// 盤面を表示するよ
	@Override
	public void paintComponent(Graphics g) {
		this.setBounds(0, 0, this.width * this.dropDiameter, this.height * this.dropDiameter);  // 指定した位置と大きさで盤面を表示するよ
		// 二重for文でDropを表示していくよ
		for(int k1 = 0; k1 < this.height; k1++) {
			for (int k2 = 0; k2 < this.width; k2++) {
				this.add(this.board.get(k1).get(k2));             // board[k1][k2]のDropを盤面に乗せるよ
			}
		}
	}
	
	// int型のランダムな値を返すよ
	public int random() {
		return (int)(Math.random()* 5);
	}

	
}
