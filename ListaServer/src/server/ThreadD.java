package server;

import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class ThreadD implements Runnable{
	JTextField area;
	
	public ThreadD(JTextField area) {
		this.area = area;

	}

	@Override
	public void run() {
			for(int i = 0; i < 100; i++) {
				if(i % 2 != 0) {
					int msg = i;
					SwingUtilities.invokeLater(() -> area.setText("td: " + msg + "\n"));
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
	}

}
