package Game;

import java.awt.Color;
import java.awt.Graphics;

import Base.Window;
import Game.Drop.FireDrop;

// Window�N���X���p������GameWindow�N���X������
// �Q�[����ʂ�\������N���X����(GameWindow�N���X��Board�N���X�AField�N���X�AGameManager�N���X������)
public class GameWindow extends Window{
	
	private Board board;               // Board�N���X������
	private GameManager manager;       // GameManager�N���X������
	private GamePlayer gamePlayer;     // GamePlayer�N���X������
	private GameEnvironment environment;

	public GameWindow() {
		super(800,600);	                  // �Q�[����ʂ̑傫�����w�肷���
		
		environment = new GameEnvironment();                           // �Q�[����ʂɕK�v�Ȓl���擾�����
		int boardWidth = environment.getBourdWidth();                  // �Ֆʂ̉��̃h���b�v�̐����擾����� 
		int boardHeight = environment.getBourdHeight();                // �Ֆʂ̏c�̃h���b�v�̐����擾�����
		int dropDiameter = environment.getDropDiameter();              // �h���b�v�̑傫�����擾�����
		board = new Board(boardWidth,boardHeight,dropDiameter);        // ��6�h���b�v�A�c5�h���b�v�A�h���b�v�̒��a80�̔Ֆʂ�����
		manager = new GameManager(board);        // GameManager�N���X���`�����
		gamePlayer = new GamePlayer();           // GamePlayer�N���X���`�����
		addMouseListener(gamePlayer);            // MouseListener���g����悤�ɂ����
		addMouseMotionListener(gamePlayer);      // MouseMotionListener���g����悤�ɂ����
	}
	// �Q�[����ʂ�\�������
	@Override
    public void paint(Graphics g){
        super.paint(g);
        this.add(this.board);            // �Ֆʂ��Q�[����ʂɏ悹���
        
    }
}
