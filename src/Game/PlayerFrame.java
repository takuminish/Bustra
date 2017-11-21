package Game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;

import javax.imageio.ImageIO;

import Base.GameEnvironment;
import Base.Panel;
public class PlayerFrame extends Panel{
	
	private BufferedImage image;
	private Text nameText;
	private Text HPText;
	private Text statusText;
	
	public PlayerFrame (int PlayerHP) {
		super();
		this.nameText = new Text("�v���C���[");
		this.HPText = new Text("�g:  " + PlayerHP);
		this.statusText = new Text("��:  ");
		URL url = getClass().getClassLoader().getResource("Play_frame.png");     // File�N���X�ɘg�̉摜�������
		System.out.println(url);
		this.image = Image(url);
		this.add(this.nameText);
		this.nameText.setBounds(10,0,100,20);
		this.add(this.HPText);
		this.HPText.setBounds(10,30,100,20);
		this.add(this.statusText);
		this.statusText.setBounds(10,50,100,20);
	}
	public BufferedImage Image(URL url) {
		BufferedImage image = null;              // �ŏ���null�ɂ��Ă�����
		try {
			  image = ImageIO.read(url);           // �摜���Q�Ƃł���Ή摜��image�ϐ��ɓ�����
			} catch (Exception e) {
			  e.printStackTrace();               // �G���[�o�͂��s����
			  image = null;                      // �G���[��������image�ϐ���null�̂܂܂���
			}
		return image;                            // image�ϐ���Ԃ���
	}
	
	public void paintComponent(Graphics g) {
		g.drawImage(this.image,0,0,75,75,null); //image�ϐ��̉摜��\�������
    }
	
	public void setHPText(int PlayerHP) {
		this.HPText.change("H:  " + PlayerHP);		
	}
	
	public void gameover() {
    	this.statusText.change("��:  ����");
    	this.statusText.setForeground(Color.RED);
    	this.HPText.setForeground(Color.RED);
    	this.nameText.setForeground(Color.RED);
		URL url = getClass().getClassLoader().getResource("Play_frame_red.png");     // File�N���X�ɘg�̉摜�������
		this.image = Image(url);
		repaint();
    }
}