package Game;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import Base.GameEnvironment;
import Base.Player;
import Game.Manager.BoardManager;
import Game.Manager.FieldManager;

public class GamePlayer{

	private BoardManager Bmanager;
	private FieldManager Fmanager;
	
	public GamePlayer(FieldManager Fmanager, BoardManager Bmanager) {
		super();
		this.Bmanager = Bmanager;
		this.Fmanager = Fmanager;
	}
}
