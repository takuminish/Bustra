package Game;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import Base.Panel;
public class TextFrame extends Panel{
	protected BufferedImage image;               // ���̕ϐ��ɑΉ�����摜�������
	private NormaText text;
	
	public TextFrame() {
		super();
		//this.setBounds(75,180,200,200);     // �w�肵��x,y���W�Əc���̑傫������\������ʒu�����߂��
		File f = new File("image/DQ_frame.png");     // File�N���X�ɘg�̉摜�������
		this.image = Image(f);
		this.text = new NormaText("<html>�o�X�s�T�������ꂽ�B<br></html>");
		this.add(this.text);
		this.text.setBounds(0,0,200,50);
	}
	public BufferedImage Image(File f) {
		BufferedImage image = null;              // �ŏ���null�ɂ��Ă�����
		try {
			  image = ImageIO.read(f);           // �摜���Q�Ƃł���Ή摜��image�ϐ��ɓ�����
			} catch (Exception e) {
			  e.printStackTrace();               // �G���[�o�͂��s����
			  image = null;                      // �G���[��������image�ϐ���null�̂܂܂���
			}
		return image;                            // image�ϐ���Ԃ���
	}
	
	public void ChangeText(String str) {
		this.text.change(str);
		
	}
	
    public void paintComponent(Graphics g) {
		g.drawImage(this.image,0,0,200,50,null); //image�ϐ��̉摜��\�������
    }
}
