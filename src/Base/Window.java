package Base;

import java.awt.Dimension;
import javax.swing.JPanel;

// Jpanelクラスを継承したWindowクラスを作るよ
// ゲーム画面等の画面全体を表すクラスだよ
public class Window extends JPanel{
	
	protected int width;                             // 画面の横の大きさ
	protected int height;                            // 画面の縦の大きさ
	
	// コンストラクタ
	public Window(int width, int height) {
		super();
		this.width = width;                          // 画面の横の大きさを指定するよ
		this.height = height;                        // 画面の縦の大きさを指定するよ
		this.setDoubleBuffered(true);
		setLayout(null);
		//this.setBounds(0,0,this.width,this.height);  // 画面を表示する位置と大きさを指定するよ
	}
}
