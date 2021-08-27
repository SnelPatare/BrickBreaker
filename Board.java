
public class Board implements Observer{


	//Inherited method from Observer
		public void update() {
			
		}
		
		public Board(Observable o) {
			o.addObserver(this);
		}

}
