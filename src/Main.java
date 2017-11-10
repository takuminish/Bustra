import java.awt.Graphics;
import java.awt.Graphics2D;

import Game.GameWindow;
import Game.Drop.*;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import Base.Window;
import Base.GameEnvironment;

// これがMain文だよ
public class Main {
    public static void main(String[] args) {
    	GameEnvironment environment = new GameEnvironment();
    	SwingUtilities.invokeLater(() -> {
			GameFrame gameframe = new GameFrame();           // ゲームを表示するフレームを作るよ
			gameframe.setLayout(null);
			GameWindow gamewindow = new GameWindow(environment.getWindowWidth(),environment.getWindowHeight());        // ゲーム画面を表示するクラスを定義するよ
			gameframe.add(gamewindow);                       // フレームにゲーム画面を乗せるよ
			gamewindow.setBounds(0,0,environment.getWindowWidth(),environment.getWindowHeight());
			gameframe.pack();
            gameframe.setSize(environment.getWindowWidth(),environment.getWindowHeight());                      // フレームの大きさを指定するよ
			gameframe.setVisible(true);
			gameframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//	gameframe.setResizable(false);
    	});
    }
}
