package Game;

import java.awt.Color;
import java.awt.Graphics;

import Base.Window;
import Game.Drop.FireDrop;

// Window�N���X���p������GameWindow�N���X������
// �Q�[����ʂ�\������N���X����(GameWindow�N���X��Board�N���X��Field�N���X������)
public class GameWindow extends Window{
	
	private Board board;               // Board�N���X������

	public GameWindow() {
		super(800,600);	                  // �Q�[����ʂ̑傫�����w�肷���	
		board = new Board(6,5,80);        // ��6�h���b�v�A�c5�h���b�v�A�h���b�v�̒��a80�̔Ֆʂ�����
	}
	// �Q�[����ʂ�\�������
	@Override
    public void paint(Graphics g){
        super.paint(g);
        this.add(this.board);            // �Ֆʂ��Q�[����ʂɏ悹���
        
    }
}
