import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Timer;
public class Clock extends JLabel{
	private Timer gameClock;
	private int mins = 00;
	private int secs = 10;
	
		
		public Clock() {
			
			super("00:10"); 
			this.gameClock = new Timer(1000, updateClockAction);
			this.gameClock.start();
			
		}
		
		ActionListener updateClockAction = new ActionListener() {
			  public void actionPerformed(ActionEvent e) {
				  secs--;
					if(secs == 0) {
						mins--;
						secs = 59;
					}
					if(secs < 10) {
						if(mins < 10) {
							setText("0" + mins + ":" + "0" + secs);
						}
						setText(mins + ":0" + secs);
					}
					else {
						if(mins < 10)
						{
							setText("0" + mins + ":" + secs);
						}
						else {
						setText(mins + ":" + secs);
						}
					}
					if (secs == 01 && mins == 00) {
						Board.isPlay=false;
						JOptionPane jop = new JOptionPane("Time Out");
						JDialog dialog = jop.createDialog("Error Message");
						dialog.setLayout(new BorderLayout());
						dialog.setVisible(true);
						gameClock.stop();
					}
			  }
			}; 

		
}
