package Game.Thread;

import Base.GameEnvironment;

public class SleepThread implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		GameEnvironment.sleep(1000);
	}

}
