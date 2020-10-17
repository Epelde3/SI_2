package probak;

import javax.persistence.EntityManager;

import dataAccess.*;

public class DatuBaseProba {
	
	public static void main(String[]args) {
		DataAccessInterface db=new DataAccess();
		db.initializeDB();		
		
	}
	

}
