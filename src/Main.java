import java.awt.Graphics;
import java.awt.Graphics2D;

import Game.GameWindow;
import Game.Drop.*;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import Base.Window;
import Base.GameEnvironment;

// ���ꂪMain������
public class Main {
    public static void main(String[] args) {
    	GameEnvironment environment = new GameEnvironment();
    	SwingUtilities.invokeLater(() -> {
			GameFrame gameframe = new GameFrame();           // �Q�[����\������t���[��������
			gameframe.setLayout(null);
			GameWindow gamewindow = new GameWindow(environment.getWindowWidth(),environment.getWindowHeight());        // �Q�[����ʂ�\������N���X���`�����
			gameframe.add(gamewindow);                       // �t���[���ɃQ�[����ʂ��悹���
			gamewindow.setBounds(0,0,environment.getWindowWidth(),environment.getWindowHeight());
			gameframe.pack();
            gameframe.setSize(environment.getWindowWidth(),environment.getWindowHeight());                      // �t���[���̑傫�����w�肷���
			gameframe.setVisible(true);
			gameframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//	gameframe.setResizable(false);
    	});
    }
}
