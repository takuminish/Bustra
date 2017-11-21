import java.awt.Graphics;
import java.awt.Graphics2D;

import Game.GameWindow;
import Game.Drop.*;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import Base.Window;
import Base.GameApp;
import Base.GameEnvironment;
import Base.GameFrame;

// これがMain文だよ
public class Main {
    public static void main(String[] args) {
    	SwingUtilities.invokeLater(() -> {
			GameFrame gameframe = new GameFrame();           // ゲームを表示するフレームを作るよ
			GameApp gameapp = new GameApp();
			gameframe.setLayout(null);
			gameframe.add(gameapp);                       // フレームにゲーム画面を乗せるよ
			gameapp.setBounds(0,0,GameEnvironment.WINDOWWIDTH,GameEnvironment.WINDOWHEIGHT);
			gameframe.pack();
            gameframe.setSize(GameEnvironment.WINDOWWIDTH,GameEnvironment.WINDOWHEIGHT);                      // フレームの大きさを指定するよ
			gameframe.setVisible(true);
			gameframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	});
    }
}
