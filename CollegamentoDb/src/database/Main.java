package database;

public class Main {

	public static void main(String[] args) {
		Database db = new Database();
		
		try {
			db.testDb();
			
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
	}

}
