import java.awt.Graphics;
import java.awt.Graphics2D;

import Game.GameWindow;
import Game.Drop.*;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import Base.Window;

// ���ꂪMain������
public class Main {
    public static void main(String[] args) {
    	SwingUtilities.invokeLater(() -> {
			GameFrame gameframe = new GameFrame();           // �Q�[����\������t���[��������
			GameWindow gamewindow = new GameWindow();        // �Q�[����ʂ�\������N���X���`�����
			gameframe.add(gamewindow);                       // �t���[���ɃQ�[����ʂ��悹���
			gameframe.pack();
            gameframe.setSize(500,600);                      // �t���[���̑傫�����w�肷���
			gameframe.setVisible(true);
			gameframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		});
    }
}
