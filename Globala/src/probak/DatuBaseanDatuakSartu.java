package probak;

import dataAccess.DataAccess;
import dataAccess.DataAccessInterface;

public class DatuBaseanDatuakSartu {

	
	public static void main(String[]args) {
		DataAccessInterface db = new DataAccess();
		
		
		db.initializeDB();
		
	}
}
