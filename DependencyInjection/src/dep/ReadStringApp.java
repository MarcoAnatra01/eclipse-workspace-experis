package dep;

public class ReadStringApp {

	private ReadStringInterface reader;
	
	public ReadStringApp(ReadStringInterface reader) {
		this.reader = reader;
	}
	
	public String read() {
		return this.reader.execute();
	}
}
