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
import Game.Thread.DropThread;
import Game.Thread.SleepThread;

// Window�N���X���p������GameWindow�N���X������
// �Q�[����ʂ�\������N���X����(GameWindow�N���X��Board�N���X�AField�N���X�AGameManager�N���X������)
public class GameWindow extends Window{

	private Board board;               // Board�N���X������
	private Field field;
	private BoardManager Bmanager;
	private FieldManager Fmanager;

	public GameWindow(int width,int height,String deficult) {

		super(width,height);	                  // �Q�[����ʂ̑傫�����w�肷���
		this.board = new Board();
		this.field = new Field(3,deficult);
		this.Bmanager = new BoardManager(this.board);
		this.Fmanager = new FieldManager(this.field,3);
		setFocusable(true);
		this.add(this.board);            // �Ֆʂ��Q�[����ʂɏ悹���
		this.add(this.field);            // ��̉�ʂ��Q�[����ʂɏ悹���
		this.board.setBounds(GameEnvironment.BOARDX,GameEnvironment.BOARDY,GameEnvironment.BOARDWIDTH * GameEnvironment.DROPDIAMETER,GameEnvironment.BOARDHEIGHT * GameEnvironment.DROPDIAMETER);
		this.field.setBounds(GameEnvironment.FIELDX,GameEnvironment.FIELDY,GameEnvironment.FIELDWIDTH,GameEnvironment.FIELDHEIGHT);
	}
	// �Q�[����ʂ�\�������
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
	}

	public void dropHold(int mouseX,int mouseY) {
		mouseY -= GameEnvironment.BOARDY;
		this.Bmanager.holdManagement(mouseX, mouseY);
	}

	// GameManager�̃��\�b�h���Ăяo���ăh���b�v�𓮂�����
	public void dropMove(int mouseX,int mouseY) {
		mouseY -= GameEnvironment.BOARDY;
		this.Bmanager.MoveManagement(mouseX, mouseY);
	}

	// GameManager�̃��\�b�h���Ăяo���ăh���b�v�������
	public void dropLost() {
		this.Bmanager.LostManagement();
		this.Bmanager.comboDicision(() ->  this.Fmanager.DamageDecision(this.Bmanager.getCombo()));
	}
}
