package Game.Thread;

import Base.GameEnvironment;
import Game.Manager.BoardManager;

public class DropThread implements Runnable{

	private BoardManager BManager;
	
	public DropThread(BoardManager BManager) {
		this.BManager = BManager;
	}
	@Override
	public void run() {
		GameEnvironment.sleep(10000);
		// TODO Auto-generated method stub
		//this.BManager.LostManagement();
		System.out.println("sleep");
	}

}
