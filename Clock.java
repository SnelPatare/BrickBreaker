import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.Timer;
public class Clock extends JLabel{
	private Timer gameClock;
	private String currentTime;
	private int mins = 1;
	private int secs = 59;
	
		
		public Clock() {
			
			super("01:59"); 
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
						setText(mins + ":" + secs);
					}
			  }
			}; 

		
}
