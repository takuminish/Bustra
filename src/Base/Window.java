package Base;

import java.awt.Dimension;
import javax.swing.JPanel;

// Jpanel�N���X���p������Window�N���X������
// �Q�[����ʓ��̉�ʑS�̂�\���N���X����
public class Window extends JPanel{
	
	protected int width;                             // ��ʂ̉��̑傫��
	protected int height;                            // ��ʂ̏c�̑傫��
	
	// �R���X�g���N�^
	public Window(int width, int height) {
		super();
		this.width = width;                          // ��ʂ̉��̑傫�����w�肷���
		this.height = height;                        // ��ʂ̏c�̑傫�����w�肷���
		this.setDoubleBuffered(true);
		setLayout(null);
		//this.setBounds(0,0,this.width,this.height);  // ��ʂ�\������ʒu�Ƒ傫�����w�肷���
	}
}
