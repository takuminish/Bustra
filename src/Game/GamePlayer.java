package Game;

import java.awt.event.MouseEvent;

import Base.Player;

public class GamePlayer extends Player{

	public GamePlayer() {
		super();
	}
	
	// �}�E�X�������ꂽ��
    public void mousePressed(MouseEvent e){
    	int mouseX = e.getX();
    	int mouseY = e.getY();
    	
    	System.out.println(mouseX + "," + mouseY);
    }
       
    // �}�E�X�������ꂽ��Ԃ��痣�ꂽ��
    public void mouseReleased(MouseEvent e){}
    
    // �}�E�X���h���b�O������(�N���b�N�����܂ܓ�����)
    public void mouseDragged(MouseEvent e){}
	
	
}
