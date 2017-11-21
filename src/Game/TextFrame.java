package Game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;

import javax.imageio.ImageIO;

import Base.GameEnvironment;
import Base.Panel;
public class TextFrame extends Panel{
	protected BufferedImage image;               // ���̕ϐ��ɑΉ�����摜�������
	private Text text;
	
	public TextFrame(String enemyName, int norma) {
		super();
		URL url = getClass().getClassLoader().getResource("DQ_frame.png");
		this.image = Image(url);
		this.text = new Text("<html>" + enemyName + "�����ꂽ�B<br>" + norma + "�R���{�ȏ�ōU������!!</html>");
		this.add(this.text);
		this.text.setBounds(GameEnvironment.TEXTX,GameEnvironment.TEXTY,GameEnvironment.TEXTWIDTH,GameEnvironment.TEXTHEIGHT);
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
	
	public void ChangeText(String str) {
		this.text.change(str);
		
	}
	
    public void paintComponent(Graphics g) {
		g.drawImage(this.image,0,0,GameEnvironment.TEXTFRAMEWIDTH,GameEnvironment.TEXTFRAMEHEIGHT,null); //image�ϐ��̉摜��\�������
    }
    
    public void gameover() {
    	this.text.change("�v���C���[�͂���ł��܂���");
    	this.text.setForeground(Color.RED);
    	URL url = getClass().getClassLoader().getResource("DQ_frame_red.png");
		this.image = Image(url);
		repaint();
    }
}
