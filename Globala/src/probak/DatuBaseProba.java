package probak;

import javax.persistence.EntityManager;

import dataAccess.DataAccess;

import dataAccess.*;

public class DatuBaseProba {
	
	public static void main(String[]args) {
		DataAccess db=new DataAccess();
		db.initializeDB();		
		
	}
	

}
