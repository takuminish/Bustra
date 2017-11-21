// Game�p�b�P�[�W
package Game;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JPanel;

import Base.GameEnvironment;
import Base.Panel;
import Game.Drop.*;

// Panel�N���X���p������Board�N���X������
// �h���b�v��\������Ֆʂ���(Board�N���X�͕�����Drop�N���X������)
public class Board extends Panel{
    
	private ArrayList<ArrayList<Drop>> board;             // Drop�N���X��2�����z��
	private final int width;                              // �Ֆʂ̉��̒���
	private final int height;                             // �Ֆʂ̏c�̒���
	private final int dropDiameter;                       // �h���b�v�̒��a�̒���
	
	// �R���X�g���N�^
	public Board() { 
        this.width = GameEnvironment.BOARDWIDTH;               // �Ֆʂ̉��̃h���b�v�̐����擾����� 
	    this.height = GameEnvironment.BOARDHEIGHT;              // �Ֆʂ̏c�̃h���b�v�̐����擾�����
		this.dropDiameter = GameEnvironment.DROPDIAMETER;            // �h���b�v�̑傫�����擾�����
    	 board = new ArrayList<ArrayList<Drop>>();        // Drop�N���X��2�����z����`�����
    	// this.setBounds(0, this.environment.getBoardPosition(), this.width * this.dropDiameter, this.height * this.dropDiameter);  // �w�肵���ʒu�Ƒ傫���ŔՖʂ�\�������
 
    	 // ��dfor���œ񎟌��z���Drop�N���X�̎q�N���X(�΁A���A�؁A�ŁA��)�����Ă�����
    	 for (int k1 = 0; k1 < this.height; k1++) {
    		 this.board.add(new ArrayList<Drop>());       // Drop�N���X�̔z��̒���Drop�N���X�̔z�������
    		 for (int k2 = 0; k2 < this.width; k2++) {
    			 // �����_���Ȓl�ɂ���Ăǂ̃h���b�v�ɂ��邩���߂��
    			 switch(random()) {
    			 case 0: this.board.get(k1).add(new FireDrop(this.dropDiameter / 2,this.dropDiameter / 2)); break;  // �����_���̒l��0��������΃h���b�v���i�[����� 
    			 case 1: this.board.get(k1).add(new WaterDrop(this.dropDiameter / 2,this.dropDiameter / 2)); break; // �����_���̒l��1�������琅�h���b�v���i�[�����   
    			 case 2: this.board.get(k1).add(new WoodDrop(this.dropDiameter / 2,this.dropDiameter / 2)); break;  // �����_���̒l��2��������؃h���b�v���i�[�����
    			 case 3: this.board.get(k1).add(new DarkDrop(this.dropDiameter / 2,this.dropDiameter / 2)); break;  // �����_���̒l��3��������Ńh���b�v���i�[�����
    			 case 4: this.board.get(k1).add(new LightDrop(this.dropDiameter / 2,this.dropDiameter / 2)); break; // �����_���̒l��4����������h���b�v���i�[�����
    			 }
    		 }
    	 }
    }
	// �Ֆʂ�\�������
	@Override
	public void paintComponent(Graphics g) {
		
		for(int k1 = 0; k1 < this.height; k1++) {
			for (int k2 = 0; k2 < this.width; k2++) {
				if (((k1 * this.height + k2) % 2) == 0) {
					g.setColor(new Color(124,96,53));
				} else {
					g.setColor(new Color(107,73,45));
				}
				g.fillRect(k2 * this.dropDiameter, k1 * this.dropDiameter , this.dropDiameter, this.dropDiameter);
			}
		}
		
		// ��dfor����Drop��\�����Ă�����
		for(int k1 = 0; k1 < this.height; k1++) {
			for (int k2 = 0; k2 < this.width; k2++) {
				this.add(this.board.get(k1).get(k2));             // board[k1][k2]��Drop��Ֆʂɏ悹���
				this.board.get(k1).get(k2).setBounds(k2 * this.dropDiameter, k1 * this.dropDiameter, this.dropDiameter, this.dropDiameter);
			}
		}
	}
	
	// int�^�̃����_���Ȓl��Ԃ���
	public int random() {
		return (int)(Math.random()* 5);
	}

    
    // �Ֆʂ̏�Ԃ�Ԃ���
    public ArrayList<ArrayList<Drop>> getBoard() {
    	return this.board;
    }
    
    // �����Ă���h���b�v��X���W��Ԃ���
    public int getHoldDropX() {
    	
    	int x = 0;
    	// ��dfor���ɂ�莝���Ă���h���b�v(drop.hold��true)��T���AX���W��Ԃ���
    	for (int k1 = 0; k1 < this.height; k1++) {
    		for (int k2 = 0; k2 < this.width; k2++) {
    			if (this.board.get(k1).get(k2).getHold() == true) {
    				x = k2;
    			}
    		}
    	}
    	return x;
    }
    
 // �����Ă���h���b�v��Y���W��Ԃ���
    public int getHoldDropY() {
    	
    	int y = 0;
    	// ��dfor���ɂ�莝���Ă���h���b�v(drop.hold��true)��T���AY���W��Ԃ���
    	for (int k1 = 0; k1 < this.height; k1++) {
    		for (int k2 = 0; k2 < this.width; k2++) {
    			if (this.board.get(k1).get(k2).getHold() == true) {
    				y = k1;
    			}
    		}
    	}
    	return y;
    }
    
    // �Ֆʂ̃h���b�v�����ւ����
    public void dropSwap(int x1, int y1, int x2, int y2) {
    	if (x1 < 0 || x2 < 0) return;
    	if (y1 < 0 || y2 < 0)  return;
    	if (x1 > this.width - 1 || x2 > this.width - 1) return;
    	if (y1 > this.height - 1 || y2 > this.height - 1) return;
    	Drop tmp; // ����ւ��p�̈ꎞ�C���X�^���X
    	// �ʒu�̓���ւ�
    	tmp = this.board.get(y1).get(x1);   
    	this.board.get(y1).set(x1, this.board.get(y2).get(x2)); 
    	this.board.get(y2).set(x2, tmp);
    	
    	this.board.get(y1).get(x1).move(30, 30);  // �h���b�v�̈ړ��𔽉f
    }
    
 // �Ֆʂ̃h���b�v��������
    public void dropDelete(ArrayList<Integer> x, ArrayList<Integer> y) {
    	
    	Drop tmp;
    	int dropX;  // �h���b�v��x���W
    	int dropY;  // �h���b�v��y���W
    	
    	// for���ɂ��P���h���b�v�𖳌��h���b�v�ɕς����
    	for (int k1 = 0; k1 < x.size(); k1++) {
    		dropX = x.get(k1);
    		dropY = y.get(k1);
    	    this.board.get(dropY).get(dropX).setInvisible();  // �񎟌��z���1�v�f���i�[�����
        }  	
    }

}
