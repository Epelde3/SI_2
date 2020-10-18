package probak;

import dataAccess.DataAccess;
import dataAccess.DataAccessInterface;
import domain.*;

public class DatuBaseanDatuakSartu {

	
	public static void main(String[]args) {
		DataAccessInterface db = new DataAccess();
		System.getProperty("java.classpath");
		
		db.initializeDB();
		
	}
}
