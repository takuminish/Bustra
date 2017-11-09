// Gameパッケージ
package Game;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JPanel;

import Base.GameEnvironment;
import Base.Panel;
import Game.Drop.*;

// Panelクラスを継承したBoardクラスを作るよ
// ドロップを表示する盤面だよ(Boardクラスは複数のDropクラスを持つ)
public class Board extends Panel{
    
	private ArrayList<ArrayList<Drop>> board;             // Dropクラスの2次元配列
	private final int width;                              // 盤面の横の長さ
	private final int height;                             // 盤面の縦の長さ
	private final int dropDiameter;                       // ドロップの直径の長さ
	private GameEnvironment environment;
	
	// コンストラクタ
	public Board() {
		environment = new GameEnvironment();
        this.width = environment.getBourdWidth();                // 盤面の横のドロップの数を取得するよ 
	    this.height = environment.getBourdHeight();              // 盤面の縦のドロップの数を取得するよ
		this.dropDiameter = environment.getDropDiameter();            // ドロップの大きさを取得するよ
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
		
		
		this.setBounds(0, this.environment.getBoardPosition(), this.width * this.dropDiameter, this.height * this.dropDiameter);  // 指定した位置と大きさで盤面を表示するよ
		for(int k1 = 0; k1 < this.height; k1++) {
			for (int k2 = 0; k2 < this.width; k2++) {
				if (((k1 * this.height + k2) % 2) == 0) {
					g.setColor(new Color(124,96,53));
				} else {
					g.setColor(new Color(107,73,45));
				}
				g.fillRect(k2 * this.dropDiameter, k1 * this.dropDiameter , this.dropDiameter, this.dropDiameter);
			}
		}
		
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

    
    // 盤面の状態を返すよ
    public ArrayList<ArrayList<Drop>> getBoard() {
    	return this.board;
    }
    
    // 持っているドロップのX座標を返すよ
    public int getHoldDropX() {
    	
    	int x = 0;
    	// 二重for文により持っているドロップ(drop.holdがtrue)を探し、X座標を返すよ
    	for (int k1 = 0; k1 < this.height; k1++) {
    		for (int k2 = 0; k2 < this.width; k2++) {
    			if (this.board.get(k1).get(k2).getHold() == true) {
    				x = k2;
    			}
    		}
    	}
    	return x;
    }
    
 // 持っているドロップのY座標を返すよ
    public int getHoldDropY() {
    	
    	int y = 0;
    	// 二重for文により持っているドロップ(drop.holdがtrue)を探し、Y座標を返すよ
    	for (int k1 = 0; k1 < this.height; k1++) {
    		for (int k2 = 0; k2 < this.width; k2++) {
    			if (this.board.get(k1).get(k2).getHold() == true) {
    				y = k1;
    			}
    		}
    	}
    	return y;
    }
    
    // 盤面のドロップを入れ替えるよ
    public void dropSwap(int x1, int y1, int x2, int y2) {
    	Drop tmp; // 入れ替え用の一時インスタンス
    	
    	// 位置の入れ替え
    	tmp = this.board.get(y1).get(x1);                      
    	this.board.get(y1).set(x1,this.board.get(y2).get(x2)); 
    	this.board.get(y2).set(x2,tmp);
    	
    	this.board.get(y1).get(x1).move(x1 * this.dropDiameter, y1 * this.dropDiameter);  // ドロップの移動を反映
    }
    
 // 盤面のドロップを消すよ
    public void dropDelete(ArrayList<Drop> drop) {
    	
    	Drop tmp;
    	int dropX;  // ドロップのx座標
    	int dropY;  // ドロップのy座標
    	
    	// for文により１つずつドロップを無効ドロップに変えるよ
    	for (int k1 = 0; k1 < drop.size(); k1++) {
    		dropX = drop.get(k1).getX();
    		dropY = drop.get(k1).getY();
    		System.out.println(dropX + "," + dropY);
    	    tmp = this.board.get(dropY / this.dropDiameter).get(dropX / this.dropDiameter);  // 二次元配列の1要素を格納するよ
		    this.board.get(dropY / this.dropDiameter).set(dropX / this.dropDiameter, tmp.setInvisible());// 無効ドロップに変更するよ
		    this.board.get(dropY / this.dropDiameter).get(dropX / this.dropDiameter).move(dropX,dropY);
		    
        }
    	repaint();
    }

}
