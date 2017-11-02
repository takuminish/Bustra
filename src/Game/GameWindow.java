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
		super();		
		board = new Board(6,5);        // ��6�h���b�v�A�c5�h���b�v�̔Ֆʂ�����
	}
	// �Q�[����ʂ�\�������
	@Override
    public void paint(Graphics g){
        super.paint(g);
        this.setBounds(0, 0, 800, 600);  // �w�肵���ʒu�Ƒ傫���̈ʒu�ɕ\�������
        this.add(this.board);            // �Ֆʂ��Q�[����ʂɏ悹���
        
    }
}
