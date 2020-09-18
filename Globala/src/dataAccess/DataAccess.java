package dataAccess;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import domain.Dibisa;
import domain.Eragiketa;
import domain.Kontua;
import domain.SukurtsalDibisa;
import domain.Sukurtsala;

public class DataAccess {
	private EntityManager db;
	private EntityManagerFactory emf;
	private String fileName="dibisak.odb";
	
	public  DataAccess() {
		emf=Persistence.createEntityManagerFactory("objectdb:"+fileName);
		db=emf.createEntityManager();
		System.out.println("Datu basea ireki da");
	}
	
	public void close() {
		db.close();
		System.out.println("Datu basea itxi egin da.");
		
	}
	
	public Kontua getBezeroa(int id) throws NullPointerException{
		
		return db.find(Kontua.class, id);
	}
	
	public ArrayList<Dibisa> getSukurtsalekoDibisak(String helbidea) {
		TypedQuery<Dibisa> query=db.createQuery("SELECT p FROM Dibisa p",Dibisa.class);
		ArrayList<Dibisa> lista=(ArrayList<Dibisa>) query.getResultList();//Iuel castingek problemak emangoittu
		return lista;
	}
	
	public void erosketaEtaSaltzeaGauzatu(int id, float prezioa) {
		db.getTransaction().begin();
		Kontua oraingoa=db.find(Kontua.class, id);
		oraingoa.setDiruKopuru(prezioa+oraingoa.getDiruKopuru());
		db.getTransaction().commit();
		
	}
	
	public void dibisakGehitu(Dibisa dibisa,float kopurua,String helbidea) {
		Sukurtsala lag=db.find(Sukurtsala.class,helbidea);
		System.out.println(helbidea);
		db.getTransaction().begin();
		lag.sukurtsalDibisaTopatu(dibisa.getIzena()).setKopurua(lag.sukurtsalDibisaTopatu(dibisa.getIzena()).getKopurua()+kopurua);
		db.getTransaction().commit();
		System.out.println(helbidea);
	}
	//Kontuari eragiketa gehitzen dio eta kontuko dirua eguneratzen du.
	public void eragiketaGehitu(Eragiketa erag,int id,double prezioa) {
		Kontua lag=db.find(Kontua.class, id);
		db.getTransaction().begin();
		lag.eragiketaGehitu(erag);
		lag.setDiruKopuru(lag.getDiruKopuru()-prezioa);
		db.persist(lag);
		db.getTransaction().commit();
		
	}
	
	public List<Eragiketa> ergiketaKodLortu() {
		TypedQuery<Eragiketa> query=db.createQuery("SELECT e FROM Eragiketa e",Eragiketa.class);
		List<Eragiketa> a=query.getResultList();
		return a;
	}
	
	public List<Sukurtsala> sukurtsalakLortu(){
		TypedQuery<Sukurtsala> query=db.createQuery("SELECT s FROM Sukurtsala s",Sukurtsala.class);
		List<Sukurtsala> a=query.getResultList();
		return a;

	}
	
	public void diruaGehitu(int id, float kop) {
		db.getTransaction().begin();
		Kontua lag=db.find(Kontua.class, id);
		lag.setDiruKopuru(lag.getDiruKopuru()+kop);
		db.getTransaction().commit();
		
	}
	
	//Probak egiteko
	public void proba() {
		db.getTransaction().begin();
		Kontua bezero=new Kontua("Melvin", 10 , 0);
		db.persist(bezero);
		db.getTransaction().commit();
		db.close();
	}
	
	//DAtuak sartzeko
	public void datuakSartu() {
		try {
//			Dibisa dolar=new Dibisa("Dolar", 0.95);
//			Dibisa Libra =new Dibisa("Libra",1.25);
			Dibisa Yen=new Dibisa("Yen",2);
//			SukurtsalDibisa dolarSuk1= new SukurtsalDibisa(dolar, 100000, 0.5,"Dolar");
			db.getTransaction().begin();
			
			
			
//			SukurtsalDibisa libraSuk2 = new SukurtsalDibisa(Libra, 5084, 0.23,"Libra");
			SukurtsalDibisa libraSuk3 = new SukurtsalDibisa(Yen, 6000, 0.6,"Yen");
			ArrayList<SukurtsalDibisa> dibisak=new ArrayList<SukurtsalDibisa>();
//			dibisak.add(libraSuk2);
//			dibisak.add(dolarSuk1);
			dibisak.add(libraSuk3);
//			ArrayList<Kontua> bezeroak= new ArrayList<Kontua>();
//			bezeroak.add(db.find(Kontua.class, 0));
			Sukurtsala suk1=new Sukurtsala(dibisak, "Bilbo");
			
//			db.persist(dolar);
//			db.persist(Libra);
//			db.persist(Yen);
//			db.persist(dolarSuk1);
//			db.persist(libraSuk2);
//			db.persist(libraSuk3);
			db.persist(suk1);
			
			
			
			db.getTransaction().commit();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Sukurtsala getSukurtsala(String helbidea) {
		return db.find(Sukurtsala.class, helbidea);
	}

}
