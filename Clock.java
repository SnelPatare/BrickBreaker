import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Timer;
public class Clock extends JLabel{
	private Timer gameClock;
	//private int mins = 00;
	//private int secs = 10;
	private int secs = 00;	
	private final int MIN_SEC = 60;
	int gameTime = 10 * MIN_SEC; 
	
		
		public Clock() {
			
			super("10:00"); 
			this.gameClock = new Timer(1000, updateClockAction);
			this.gameClock.start();
			
		}
		
		ActionListener updateClockAction = new ActionListener() {
			  public void actionPerformed(ActionEvent e) {
				  gameTime--;
				  int min = gameTime / MIN_SEC;
				  int sec = gameTime % MIN_SEC;
				  
				  String str = String.format( "%02d", min) + ":" + String.format( "%02d", sec );  
				  setText(str);
					if ( gameTime == 0) {
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
