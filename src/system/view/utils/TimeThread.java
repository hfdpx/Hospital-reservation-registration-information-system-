package system.view.utils;

import javax.swing.JLabel;

/**
 * 线程控制时间进行刷新
 * 
 * 
 * @author yb
 * @date 2018-1-17
 */
public class TimeThread implements Runnable {
	JLabel lblBottom2;

	public TimeThread(JLabel lblBottom2) {
		this.lblBottom2 = lblBottom2;

	}

	public void run() {
		try {
			while (true) {
				lblBottom2.setText(ShowTime.getTime());
				// System.out.println("");
				Thread.sleep(1000);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
