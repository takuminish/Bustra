package Game;

import java.awt.event.MouseEvent;

import Base.Player;

public class GamePlayer extends Player{

	private int dropDiameter;
	
	public GamePlayer(int diameter) {
		super();
		this.dropDiameter = diameter;
	}
	
	// �}�E�X�������ꂽ��
    public void mousePressed(MouseEvent e){
    	int mouseX = e.getX();
    	int mouseY = e.getY();
    	int dropX = mouseX / this.dropDiameter;
    	int dropY = mouseY / this.dropDiameter;
    }
       
    // �}�E�X�������ꂽ��Ԃ��痣�ꂽ��
    public void mouseReleased(MouseEvent e){}
    
    // �}�E�X���h���b�O������(�N���b�N�����܂ܓ�����)
    public void mouseDragged(MouseEvent e){}
	
	
}
