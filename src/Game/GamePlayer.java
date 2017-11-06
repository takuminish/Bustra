package Game;

import java.awt.event.MouseEvent;

import Base.Player;

public class GamePlayer extends Player{

	private GameManager manager;
	private GameEnvironment environment;
	
	public GamePlayer(GameManager manager) {
		super();
		environment = new GameEnvironment();
		this.manager = manager;
	}
	
	// �}�E�X�������ꂽ��
    public void mousePressed(MouseEvent e){
    	int mouseX = e.getX();
    	int mouseY = e.getY();
    	dropHold(mouseX, mouseY);
    }
       
    // �}�E�X�������ꂽ��Ԃ��痣�ꂽ��
    public void mouseReleased(MouseEvent e){
    	dropLost();
    }
    
    // �}�E�X���h���b�O������(�N���b�N�����܂ܓ�����)
    public void mouseDragged(MouseEvent e){
    	int mouseX = e.getX();
    	int mouseY = e.getY();
    	dropMove(mouseX,mouseY);
    }
    
    // GameManager�̃��\�b�h���Ăяo���ăh���b�v������
	public void dropHold(int mouseX,int mouseY) {
	    this.manager.holdManagement(mouseX, mouseY);
	}
	
	// GameManager�̃��\�b�h���Ăяo���ăh���b�v�𓮂�����
	public void dropMove(int mouseX,int mouseY) {
	   this.manager.MoveManagement(mouseX, mouseY);
	}
	
	// GameManager�̃��\�b�h���Ăяo���ăh���b�v�������
		public void dropLost() {
			this.manager.dropDelete(this.manager.comboDicision());
			
		    this.manager.LostManagement();
		}
	
	
}
