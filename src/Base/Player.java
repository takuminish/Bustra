package Base;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;

// Panel�N���X���p�����A�}�E�X������\�ɂ���Player�N���X������
public class Player extends Panel implements MouseListener,MouseMotionListener{
	
	// �R���X�g���N�^
	public Player() {

	}
	
	// �}�E�X���p�l���̏�ɏ������(����͎g��Ȃ�)
	public void mouseEntered(MouseEvent e){}

	// �}�E�X���p�l���̊O�ɏo����(����͎g��Ȃ�)
	public void mouseExited(MouseEvent e){}

	// �}�E�X�������ꂽ��(�Q�[����ʂŎg�p)
    public void mousePressed(MouseEvent e){}
       
    // �}�E�X�������ꂽ��Ԃ��痣�ꂽ��
    public void mouseReleased(MouseEvent e){}

    // �}�E�X���N���b�N���ꂽ��
    public void mouseClicked(MouseEvent e){}
	  
    // �}�E�X���h���b�O������(�N���b�N�����܂ܓ�����)
    public void mouseDragged(MouseEvent e){}

    // �}�E�X�𓮂�������(����͎g��Ȃ�)
    public void mouseMoved(MouseEvent e){}
}
