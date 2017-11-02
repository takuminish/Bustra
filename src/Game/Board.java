// Game�p�b�P�[�W
package Game;

import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JPanel;
import Base.Panel;
import Game.Drop.WaterDrop;
import Game.Drop.*;

// Panel�N���X���p������Board�N���X������
// �h���b�v��\������Ֆʂ���(Board�N���X�͕�����Drop�N���X������)
public class Board extends Panel{
    
	private ArrayList<ArrayList<Drop>> board;             // Drop�N���X��2�����z��
	private final int width;                              // �Ֆʂ̉��̒���
	private final int height;                             // �Ֆʂ̏c�̒���
	private final int dropDiameter;                       // �h���b�v�̒��a�̒���
	
	// �R���X�g���N�^
	public Board(int width, int height, int dropdiameter) {
		
		this.width = width;                               // �w�肵���l�����̃h���b�v�̐��ɂ����
		this.height = height;                             // �w�肵���l���c�̃h���b�v�̐��ɂ����
		this.dropDiameter = dropdiameter;                 // �w�肵���l���h���b�v�̒��a�̒����ɂ����
    	 board = new ArrayList<ArrayList<Drop>>();        // Drop�N���X��2�����z����`�����
    	 
    	 // ��dfor���œ񎟌��z���Drop�N���X�̎q�N���X(�΁A���A�؁A�ŁA��)�����Ă�����
    	 for (int k1 = 0; k1 < this.height; k1++) {
    		 this.board.add(new ArrayList<Drop>());       // Drop�N���X�̔z��̒���Drop�N���X�̔z�������
    		 for (int k2 = 0; k2 < this.width; k2++) {
    			 // �����_���Ȓl�ɂ���Ăǂ̃h���b�v�ɂ��邩���߂��
    			 switch(random()) {
    			 case 0: this.board.get(k1).add(new FireDrop(k2 * this.dropDiameter, k1 * this.dropDiameter)); break;  // �����_���̒l��0��������΃h���b�v���i�[����� 
    			 case 1: this.board.get(k1).add(new WaterDrop(k2 * this.dropDiameter, k1 * this.dropDiameter)); break; // �����_���̒l��1�������琅�h���b�v���i�[�����   
    			 case 2: this.board.get(k1).add(new WoodDrop(k2 * this.dropDiameter, k1 * this.dropDiameter)); break;  // �����_���̒l��2��������؃h���b�v���i�[�����
    			 case 3: this.board.get(k1).add(new DarkDrop(k2 * this.dropDiameter, k1 * this.dropDiameter)); break;  // �����_���̒l��3��������Ńh���b�v���i�[�����
    			 case 4: this.board.get(k1).add(new LightDrop(k2 * this.dropDiameter, k1 * this.dropDiameter)); break; // �����_���̒l��4����������h���b�v���i�[�����
    			 }
    		 }
    	 }
    }
	// �Ֆʂ�\�������
	@Override
	public void paintComponent(Graphics g) {
		this.setBounds(0, 0, this.width * this.dropDiameter, this.height * this.dropDiameter);  // �w�肵���ʒu�Ƒ傫���ŔՖʂ�\�������
		// ��dfor����Drop��\�����Ă�����
		for(int k1 = 0; k1 < this.height; k1++) {
			for (int k2 = 0; k2 < this.width; k2++) {
				this.add(this.board.get(k1).get(k2));             // board[k1][k2]��Drop��Ֆʂɏ悹���
			}
		}
	}
	
	// int�^�̃����_���Ȓl��Ԃ���
	public int random() {
		return (int)(Math.random()* 5);
	}

	
}
