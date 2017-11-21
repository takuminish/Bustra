package Game.Thread;

import java.lang.Thread;

public class TimerThread implements Runnable {
	private static int time = 10;

	@Override
	public void run() {
		while (time > 0) {
			try {
				Thread.sleep(1000);
				time -= 1;
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static int getTime() {
		return time;
	}
}