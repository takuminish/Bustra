package Game;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JLabel;

import Base.Window;
import Game.Drop.FireDrop;
import Base.GameEnvironment;
import Game.Enemy.*;
import Game.Manager.GameManager;
import Game.Manager.*;
// Window�N���X���p������GameWindow�N���X������
// �Q�[����ʂ�\������N���X����(GameWindow�N���X��Board�N���X�AField�N���X�AGameManager�N���X������)
public class GameWindow extends Window{
	
	private Board board;               // Board�N���X������
	private BoardManager manager;       // GameManager�N���X������
	private GamePlayer gamePlayer;     // GamePlayer�N���X������
	private Field field;
	public GameWindow(int width,int height) {

		super(width,height);	                  // �Q�[����ʂ̑傫�����w�肷���
		field = new Field();
		board = new Board();                              // ��6�h���b�v�A�c5�h���b�v�A�h���b�v�̒��a80�̔Ֆʂ�����
		manager = new BoardManager(board);                            // GameManager�N���X���`�����
		gamePlayer = new GamePlayer(manager);           // GamePlayer�N���X���`�����
		addMouseListener(gamePlayer);            // MouseListener���g����悤�ɂ����
		addMouseMotionListener(gamePlayer);      // MouseMotionListener���g����悤�ɂ����
		addKeyListener(gamePlayer);      // MouseMotionListener���g����悤�ɂ����
		setFocusable(true);
	}
	// �Q�[����ʂ�\�������
	@Override
    public void paint(Graphics g){
        super.paint(g);
        this.add(this.board);            // �Ֆʂ��Q�[����ʂɏ悹���
        this.add(this.field);            // ��̉�ʂ��Q�[����ʂɏ悹���
    }
}
