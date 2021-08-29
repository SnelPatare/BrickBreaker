import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.Timer;
public class Clock extends JLabel{
	private Timer gameClock;
	private String currentTime;
	private int mins = 0;
	private int secs = 0;
	
		
		public Clock() {
			
			super("0:00"); 
			this.gameClock = new Timer(1000, updateClockAction);
			this.gameClock.start();
			
		}
		
		ActionListener updateClockAction = new ActionListener() {
			  public void actionPerformed(ActionEvent e) {
				  secs++;
					if(secs%60 == 0) {
						mins++;
						secs = 0;
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
