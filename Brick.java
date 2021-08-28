import java.awt.Rectangle;

public class Brick implements Observer{
	//Inherited method from Observer
		public void update() {
			
		}
		
		public Brick(Observable o) {
			o.addObserver(this);
		}

		public Rectangle getBounds() {
			return new Rectangle(0, 0);
		}
		

}
