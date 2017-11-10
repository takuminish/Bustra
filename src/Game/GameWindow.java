package Game;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JLabel;

import Base.Window;
import Game.Drop.FireDrop;
import Base.GameEnvironment;
import Game.Enemy.*;
import Game.Manager.BoardManager;
import Game.Manager.FieldManager;
// Window�N���X���p������GameWindow�N���X������
// �Q�[����ʂ�\������N���X����(GameWindow�N���X��Board�N���X�AField�N���X�AGameManager�N���X������)
public class GameWindow extends Window{
	
	private Board board;               // Board�N���X������
	private BoardManager Bmanager;       // GameManager�N���X������
	private FieldManager Fmanager;
	private GamePlayer gamePlayer;     // GamePlayer�N���X������
	private Field field;
	public GameWindow(int width,int height) {

		super(width,height);	                  // �Q�[����ʂ̑傫�����w�肷���
		field = new Field();
		board = new Board();                              // ��6�h���b�v�A�c5�h���b�v�A�h���b�v�̒��a80�̔Ֆʂ�����
		Bmanager = new BoardManager(board);                            // GameManager�N���X���`�����
		Fmanager = new FieldManager(field);
		gamePlayer = new GamePlayer(Bmanager,Fmanager);           // GamePlayer�N���X���`�����
		addMouseListener(gamePlayer);            // MouseListener���g����悤�ɂ����
		addMouseMotionListener(gamePlayer);      // MouseMotionListener���g����悤�ɂ����
		addKeyListener(gamePlayer);      // MouseMotionListener���g����悤�ɂ����
		setFocusable(true);
        this.add(this.board);            // �Ֆʂ��Q�[����ʂɏ悹���
        this.add(this.field);            // ��̉�ʂ��Q�[����ʂɏ悹���
        this.board.setBounds(0,300,300,300);
        this.field.setBounds(0,0,300,300);

	}
	// �Q�[����ʂ�\�������
	@Override
    public void paint(Graphics g){
        super.paint(g);
    }
}
