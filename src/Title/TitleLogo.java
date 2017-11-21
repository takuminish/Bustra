package Title;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.net.URL;

import javax.imageio.ImageIO;

import Base.Panel;

public class TitleLogo extends Panel{

	private BufferedImage image; 
	
	public TitleLogo() {
		this.image = Image(getClass().getClassLoader().getResource("logo.png"));
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
		
		g.drawImage(this.image,0,0,350,150,null); //image�ϐ��̉摜��\�������
	}
}
