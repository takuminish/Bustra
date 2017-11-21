package Title;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.net.URL;

import javax.imageio.ImageIO;

import Base.Panel;

public class TitleDrop extends Panel{

	private BufferedImage image; 
	private int width;
	private int height;
	
	public TitleDrop(String path,int width, int height) {
		this.image = Image(getClass().getClassLoader().getResource(path));
	    this.width = width;
	    this.height = height;
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
		
		g.drawImage(this.image,0,0,this.width,this.height,null); //image�ϐ��̉摜��\�������
	}
}
