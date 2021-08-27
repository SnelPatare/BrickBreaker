
public interface Observable {
	void addObserver(Observer o);	
	void removeObserver(Observer o);
	void updateObserver(Observer o);	
}
