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

// ���ꂪMain������
public class Main {
    public static void main(String[] args) {
    	SwingUtilities.invokeLater(() -> {
			GameFrame gameframe = new GameFrame();           // �Q�[����\������t���[��������
			GameApp gameapp = new GameApp();
			gameframe.setLayout(null);
			gameframe.add(gameapp);                       // �t���[���ɃQ�[����ʂ��悹���
			gameapp.setBounds(0,0,GameEnvironment.WINDOWWIDTH,GameEnvironment.WINDOWHEIGHT);
			gameframe.pack();
            gameframe.setSize(GameEnvironment.WINDOWWIDTH,GameEnvironment.WINDOWHEIGHT);                      // �t���[���̑傫�����w�肷���
			gameframe.setVisible(true);
			gameframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	});
    }
}
