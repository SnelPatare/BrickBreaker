
public class Clock implements Observer{
	//Inherited method from Observer
		public void update() {
			
		}
		
		public Clock(Observable o) {
			o.addObserver(this);
		}

}
