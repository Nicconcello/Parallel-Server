package server;


import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class ThreadP implements Runnable{
	JTextField area;
	
	public ThreadP(JTextField area) {
		this.area = area;

	}

	@Override
	public void run() {
			for(int i = 0; i < 100; i++) {
				if(i % 2 == 0) {
					int msg = i;
					SwingUtilities.invokeLater(() -> area.setText("tp: " + msg + "\n"));
					try {
						Thread.sleep(1500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
	}

}

