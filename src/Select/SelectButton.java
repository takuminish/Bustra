package Select;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import Base.SoundPlayer;

public class SelectButton extends JButton implements MouseListener{

	SoundPlayer SelectSound;
	public SelectButton(String normal,String rollOver,String pressed) {
	    super();
	    URL normalURL = getClass().getClassLoader().getResource(normal);
	    URL rollOverURL = getClass().getClassLoader().getResource(rollOver);
	    URL pressedURL = getClass().getClassLoader().getResource(pressed);
	    this.setIcon(new ImageIcon(normalURL));
	    this.setPressedIcon(new ImageIcon(pressedURL));
	    this.setRolloverIcon(new ImageIcon(rollOverURL));
		this.setContentAreaFilled(false);
		addMouseListener(this);
		this.SelectSound = new SoundPlayer("select.wav");
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("Enter");
		this.SelectSound.init();
		this.SelectSound.play();
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
