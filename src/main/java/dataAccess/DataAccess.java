package dataAccess;

import java.util.ArrayList;
import java.util.List;
import javax.jws.WebMethod;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import domain.*;

public class DataAccess implements DataAccessInterface {
	private EntityManager db;
	private EntityManagerFactory emf;
	private String fileName="dibisak.odb";
	
	
	
	public  DataAccess() {
		new DataAccess(false);
	}
	
	public DataAccess(boolean initialize) {
		open(initialize);
	}
	
	
	
	/* (non-Javadoc)
	 * @see dataAccess.DataAccessInterface#open(boolean)
	 */
	@Override
	public void open(boolean initializemode) {//true bada datu basea hustu eta initialize deb exekutatuko da.
		
		
//		if(initializemode) {
//			fileName=fileName+";drop";
//			System.out.println("Datui basea ezabatu da.");
//		} 
		emf=Persistence.createEntityManagerFactory("objectdb:"+fileName);
		db=emf.createEntityManager();
		System.out.println("Datu basea ireki da");
	}
	
	/* (non-Javadoc)
	 * @see dataAccess.DataAccessInterface#close()
	 */
	@Override
	public void close() {
		db.close();
		System.out.println("Datu basea itxi egin da.");
		
	}
	
	/* (non-Javadoc)
	 * @see dataAccess.DataAccessInterface#getBezeroa(int)
	 */
	@Override
	public Kontua getBezeroa(int id) throws NullPointerException{
		
		return db.find(Kontua.class, id);
	}
	
	/* (non-Javadoc)
	 * @see dataAccess.DataAccessInterface#getSukurtsalekoDibisak(java.lang.String)
	 */
	@Override
	public ArrayList<Dibisa> getSukurtsalekoDibisak(String helbidea) {
		TypedQuery<Dibisa> query=db.createQuery("SELECT p FROM Dibisa p",Dibisa.class);
		ArrayList<Dibisa> lista=(ArrayList<Dibisa>) query.getResultList();//Iuel castingek problemak emangoittu
		return lista;
	}
	
	/* (non-Javadoc)
	 * @see dataAccess.DataAccessInterface#erosketaEtaSaltzeaGauzatu(int, float)
	 */
	@Override
	public void erosketaEtaSaltzeaGauzatu(int id, float prezioa) {
		db.getTransaction().begin();
		Kontua oraingoa=db.find(Kontua.class, id);
		oraingoa.setDiruKopuru(prezioa+oraingoa.getDiruKopuru());
		db.getTransaction().commit();
		
	}
	
	/* (non-Javadoc)
	 * @see dataAccess.DataAccessInterface#dibisakGehitu(domain.Dibisa, float, java.lang.String)
	 */
	@Override
	public void dibisakGehitu(Dibisa dibisa,float kopurua,String helbidea) {
		Sukurtsala lag=db.find(Sukurtsala.class,helbidea);
		db.getTransaction().begin();
		lag.sukurtsalDibisaTopatu(dibisa.getIzena()).setKopurua(lag.sukurtsalDibisaTopatu(dibisa.getIzena()).getKopurua()+kopurua);
		db.getTransaction().commit();
	}
	//Kontuari eragiketa gehitzen dio eta kontuko dirua eguneratzen du.
	/* (non-Javadoc)
	 * @see dataAccess.DataAccessInterface#eragiketaGehitu(domain.Eragiketa, int, double)
	 */
	@Override
	public void eragiketaGehitu(Eragiketa erag,int id,double prezioa) {
		open(false);
		Kontua lag=getBezeroa(id);
		db.getTransaction().begin();
		lag.eragiketaGehitu(erag);
		lag.setDiruKopuru(lag.getDiruKopuru()-prezioa);
		db.persist(lag);
		db.getTransaction().commit();
		
	}
	
	/* (non-Javadoc)
	 * @see dataAccess.DataAccessInterface#ergiketaKodLortu()
	 */
	@Override
	public List<Eragiketa> ergiketaKodLortu() {
		TypedQuery<Eragiketa> query=db.createQuery("SELECT e FROM Eragiketa e",Eragiketa.class);
		List<Eragiketa> a=query.getResultList();
		return a;
	}
	
	/* (non-Javadoc)
	 * @see dataAccess.DataAccessInterface#sukurtsalakLortu()
	 */
	@Override
	public List<Sukurtsala> sukurtsalakLortu(){
		TypedQuery<Sukurtsala> query=db.createQuery("SELECT s FROM Sukurtsala s",Sukurtsala.class);
		List<Sukurtsala> a=query.getResultList();
		return a;

	}
	
	/* (non-Javadoc)
	 * @see dataAccess.DataAccessInterface#diruaGehitu(int, float)
	 */
	@Override
	public void diruaGehitu(int id, float kop) {
		db.getTransaction().begin();
		Kontua lag=db.find(Kontua.class, id);
		lag.setDiruKopuru(lag.getDiruKopuru()+kop);
		db.getTransaction().commit();
		
	}
	
	//Probak egiteko
	/* (non-Javadoc)
	 * @see dataAccess.DataAccessInterface#proba()
	 */
	@Override
	public void proba() {
		db.getTransaction().begin();
		Kontua bezero=new Kontua("Melvin", 10 , 0);
		db.persist(bezero);
		db.getTransaction().commit();
		db.close();
	}
	
	//DAtuak sartzeko
	/* (non-Javadoc)
	 * @see dataAccess.DataAccessInterface#initializeDB()
	 */
	@Override
	public void initializeDB() {
		try {
			Dibisa dolar=new Dibisa("Dolar", 0.95);
			Dibisa Libra =new Dibisa("Libra",1.25);
			Dibisa Yen=new Dibisa("Yen",2);
			SukurtsalDibisa dolarSuk1= new SukurtsalDibisa(dolar, 100000, 0.5,"Dolar");
			db.getTransaction().begin();
			
			
			
			SukurtsalDibisa libraSuk2 = new SukurtsalDibisa(Libra, 5084, 0.23,"Libra");
			SukurtsalDibisa libraSuk3 = new SukurtsalDibisa(Yen, 6000, 0.6,"Yen");
			ArrayList<SukurtsalDibisa> dibisak=new ArrayList<SukurtsalDibisa>();
			dibisak.add(libraSuk2);
			dibisak.add(dolarSuk1);
			dibisak.add(libraSuk3);
			ArrayList<Kontua> bezeroak= new ArrayList<Kontua>();
			bezeroak.add(db.find(Kontua.class, 0));
			Sukurtsala suk1=new Sukurtsala(dibisak, "Bilbo");
			
			db.persist(dolar);
			db.persist(Libra);
			db.persist(Yen);
			db.persist(dolarSuk1);
			db.persist(libraSuk2);
			db.persist(libraSuk3);
			db.persist(suk1);
			
			
			
			db.getTransaction().commit();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/* (non-Javadoc)
	 * @see dataAccess.DataAccessInterface#getSukurtsala(java.lang.String)
	 */
	@Override
	public Sukurtsala getSukurtsala(String helbidea) {
		return db.find(Sukurtsala.class, helbidea);
	}

	@WebMethod
	public int eragiketaKodLortu() {
		open(false);
		int luzeera = ergiketaKodLortu().size();
		close();
		return luzeera + 1;
	}

}
