package Base;

import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;

import Base.GameEnvironment;
import Base.Panel;
import Game.*;
import Game.Manager.*;
import Select.SelectWindow;
import Title.TitleWindow;

public class GameApp extends Panel implements MouseListener, MouseMotionListener, KeyListener {

	private GameWindow gameWindow;
	private TitleWindow titleWindow;
	private SelectWindow selectWindow;
	private GamePlayer player;
	private boolean normalClick = false;
	private int Flag = 0;
	public static GameScene scene = GameScene.title;

	public GameApp() {

		this.titleWindow = new TitleWindow(GameEnvironment.WINDOWWIDTH, GameEnvironment.WINDOWHEIGHT,this);
		this.selectWindow = new SelectWindow(GameEnvironment.WINDOWWIDTH, GameEnvironment.WINDOWHEIGHT, this);
		this.add(this.titleWindow);
		this.titleWindow.setBounds(0, 0, GameEnvironment.WINDOWWIDTH, GameEnvironment.WINDOWHEIGHT);
		addMouseListener(this); // MouseListenerを使えるようにするよ
		addMouseMotionListener(this); // MouseMotionListenerを使えるようにするよ
		addKeyListener(this); // MouseMotionListenerを使えるようにするよ
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		if (this.scene == GameScene.game) {
			if (this.normalClick) {
				this.gameWindow.dropMove(e.getX(), e.getY());
			}
		}
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
	   if (this.scene == GameScene.gameClear || this.scene == GameScene.gameOver) {
			System.out.println("aaaa");
			this.remove(gameWindow);
			this.add(selectWindow);
			this.selectWindow.setBounds(0, 0, GameEnvironment.WINDOWWIDTH, GameEnvironment.WINDOWHEIGHT);
			this.scene = GameScene.select;
		}
		repaint();
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		Thread timeThread = new Thread(() -> {
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			if (Flag == 1) {
				this.scene = GameScene.combo;
				this.gameWindow.dropLost();// ドロップをはなす
			}
			Flag = 0;
		});
		if (this.scene == GameScene.game) {
			if (e.getY() > GameEnvironment.BOARDY) {
				if (Flag == 0) {
					Flag = 1;
					this.normalClick = true;
					timeThread.start();
					this.gameWindow.dropHold(e.getX(), e.getY());
				}
			}
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		if (this.scene == GameScene.game) {
			if (this.normalClick) {
				if (Flag == 1) {
					this.scene = GameScene.combo;
					this.gameWindow.dropLost();
					this.normalClick = false;
					Flag = 0;
				}
			}
		}
	}

	public void change(JPanel p, String str2) {
		if (str2.equals("title")) {
			this.remove(p);
			this.add(this.titleWindow);
			this.titleWindow.setBounds(0, 0, GameEnvironment.WINDOWWIDTH, GameEnvironment.WINDOWHEIGHT);
			repaint();
		}
		if (str2.equals("select")) {
			this.remove(p);
			this.add(this.selectWindow);
			this.selectWindow.setBounds(0, 0, GameEnvironment.WINDOWWIDTH, GameEnvironment.WINDOWHEIGHT);
			repaint();
		}
		if (str2.equals("easy")) {
			this.remove(p);
			this.gameWindow = new GameWindow(GameEnvironment.WINDOWWIDTH, GameEnvironment.WINDOWHEIGHT, "easy");
			this.add(this.gameWindow);
			this.gameWindow.setBounds(0, 0, GameEnvironment.WINDOWWIDTH, GameEnvironment.WINDOWHEIGHT);
			repaint();
		}
		if (str2.equals("normal")) {
			this.remove(p);
			this.gameWindow = new GameWindow(GameEnvironment.WINDOWWIDTH, GameEnvironment.WINDOWHEIGHT, "normal");
			this.add(this.gameWindow);
			this.gameWindow.setBounds(0, 0, GameEnvironment.WINDOWWIDTH, GameEnvironment.WINDOWHEIGHT);
			repaint();
		}
		if (str2.equals("hard")) {
			this.remove(p);
			this.gameWindow = new GameWindow(GameEnvironment.WINDOWWIDTH, GameEnvironment.WINDOWHEIGHT, "hard");
			this.add(this.gameWindow);
			this.gameWindow.setBounds(0, 0, GameEnvironment.WINDOWWIDTH, GameEnvironment.WINDOWHEIGHT);
			repaint();
		}
	}

}
