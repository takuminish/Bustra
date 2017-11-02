import java.awt.Graphics;
import java.awt.Graphics2D;

import Game.GameWindow;
import Game.Drop.*;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import Base.Window;

// これがMain文だよ
public class Main {
    public static void main(String[] args) {
    	SwingUtilities.invokeLater(() -> {
			GameFrame gameframe = new GameFrame();           // ゲームを表示するフレームを作るよ
			GameWindow gamewindow = new GameWindow();        // ゲーム画面を表示するクラスを定義するよ
			gameframe.add(gamewindow);                       // フレームにゲーム画面を乗せるよ
			gameframe.pack();
            gameframe.setSize(500,600);                      // フレームの大きさを指定するよ
			gameframe.setVisible(true);
			gameframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		});
    }
}
