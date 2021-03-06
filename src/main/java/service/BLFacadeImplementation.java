package service;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import dataAccess.DataAccess;
import dataAccess.DataAccessInterface;
import domain.*;
import iterator.ExtendedIterator;
import iterator.SukurtsalIterator;

@WebService(endpointInterface = "service.BLFacade")
public class BLFacadeImplementation implements BLFacade {

	DataAccess dbManager;

	public BLFacadeImplementation(DataAccess da) {
		System.out.println("Creating BLFacadeImplementation instance with DataAccess parameter");
		// ConfigXML c=ConfigXML.getInstance();
		// if (c.getDataBaseOpenMode().equals("initialize")) {
		da.open(false);
		// da.initializeDB();
		da.close();
		dbManager = da;

	}

	@WebMethod // Id hori duen bezeroa itzultzen du. Exception bat: id hori duen bezerorik ez
				// da existitzen.
	public Kontua getBezero(int id) throws NullPointerException {
		dbManager.open(false);
		Kontua a = dbManager.getBezeroa(id);
		dbManager.close();
		return a;

	}

	@WebMethod // Bezeroak emandako dibisak gehitzen ditu dagokion dibisan.
	public void dibisakEguneratu(Dibisa dibisa, float kopurua, String helbidea) {

		dbManager.open(false);
		dbManager.dibisakGehitu(dibisa, kopurua, helbidea);

		dbManager.close();

	}

	@WebMethod // sukurtsaleko dibisak eguneratzen ditu. Eta bezeroari eragiketa gehitzen dio.
	public void erosketaGauzatu(int id, Dibisa dibisa, int kop, double prezioa, String deskripzioa, String mota,
			String helbidea) throws Exception {
		if (mota.equals("Erosi")) {
			dibisakEguneratu(dibisa, -kop, helbidea);
			// Bezeroari eragiketa sortu
			Eragiketa erag = new Eragiketa(mota, deskripzioa, dbManager.eragiketaKodLortu());
			dbManager.open(false);

			dbManager.eragiketaGehitu(erag, id, prezioa);
			dbManager.close();
		} else if (mota.equals("Salketa")) {
			// dibisak gehitu
			dibisakEguneratu(dibisa, kop, helbidea);
			Eragiketa erag = new Eragiketa(mota, deskripzioa, dbManager.eragiketaKodLortu());
			DataAccess db = new DataAccess();

			diruaGehitu(id, dibisa, kop);
			db.eragiketaGehitu(erag, id, 0);
			db.close();

		} else {
			throw new Exception("Eragiketa okerra");
		}

	}

	@WebMethod
	public Sukurtsala getSukurtsala(String helbidea) {
		dbManager.open(false);
		Sukurtsala a = dbManager.getSukurtsala(helbidea);
		dbManager.close();
		return a;
	}

	@WebMethod // Eragiketaren prezioa kalkulatzen du
	public double prezioaKalkulatu(SukurtsalDibisa dibisa, int kopurua) {
		double prezioa = ((double) kopurua) / dibisa.getDibisa().getTrukeBalioa();
		return prezioa + prezioa * dibisa.getIrabazteKomisioa();

	}

	//Honen gainean aplikatu behar da iterator da.
	@WebMethod
	public List<Sukurtsala> getSukurtsalak() {
		dbManager.open(false);
		List<Sukurtsala> a = dbManager.sukurtsalakLortu();
		dbManager.close();
		return a;

	}
	public ExtendedIterator getSukurtsalakIterator(){
		
		dbManager.open(false);
		List<Sukurtsala> lista=dbManager.sukurtsalakLortu();
		SukurtsalIterator iterator=new SukurtsalIterator(lista);
		return iterator;
		
	}

	@WebMethod
	public float diruaGehitu(int id, Dibisa dibisa, float kop) {
		dbManager.open(false);
		dbManager.diruaGehitu(id, (float) (kop * dibisa.getTrukeBalioa()));
		return (float) (kop * dibisa.getTrukeBalioa());

	}

}
