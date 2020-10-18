package probak;

import javax.persistence.EntityManager;

import dataAccess.DataAccess;
import dataAccess.DataAccessInterface;

public class DatuBaseProba {
	
	public static void main(String[]args) {
		DataAccessInterface db=new DataAccess();
		db.initializeDB();		
		
	}
	

}
