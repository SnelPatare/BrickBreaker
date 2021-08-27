
public class Paddle implements Observer{
	
	//Inherited method from Observer
	public void update() {
		
	}
	
	public Paddle (Observable o) {
		/*Rest of constructor
		*
		*
		*
		*
		*
		*
		*/
		o.addObserver(this);
	}

}
