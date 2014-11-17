import java.io.FileNotFoundException;
import java.io.IOException;


public interface Event {
	void show() throws FileNotFoundException, IOException;
	Event next();
}
