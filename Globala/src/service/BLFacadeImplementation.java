package service;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;
import dataAccess.DataAccess;
import domain.Dibisa;
import domain.Eragiketa;
import domain.Kontua;
import domain.SukurtsalDibisa;
import domain.Sukurtsala;

@WebService(endpointInterface = "service.BLFacade")
public class BLFacadeImplementation implements BLFacade {
	
	DataAccess dbManager;
	
	public BLFacadeImplementation(DataAccess da) {
		System.out.println("Creating BLFacadeImplementation instance with DataAccess parameter");
//				ConfigXML c=ConfigXML.getInstance();
//				if (c.getDataBaseOpenMode().equals("initialize")) {
				da.open(true);
				da.initializeDB();
				da.close();
				dbManager=da;
	
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

	@WebMethod
	public int eragiketaKodLortu() {
		dbManager.open(false);
		int luzeera = dbManager.ergiketaKodLortu().size();
		dbManager.close();
		return luzeera + 1;
	}

	@WebMethod // sukurtsaleko dibisak eguneratzen ditu. Eta bezeroari eragiketa gehitzen dio.
	public void erosketaGauzatu(int id, Dibisa dibisa, int kop, double prezioa, String deskripzioa, String mota,
			String helbidea) {
		if (mota.equals("Erosi")) {
			dibisakEguneratu(dibisa, -kop, helbidea);
			// Bezeroari eragiketa sortu
			Eragiketa erag = new Eragiketa(mota, deskripzioa, eragiketaKodLortu());
			DataAccess db = new DataAccess();
			db.eragiketaGehitu(erag, id, prezioa);
			db.close();
		} else if (mota.equals("Salketa")) {
			// dibisak gehitu
			System.out.println("asfd");
			dibisakEguneratu(dibisa, kop, helbidea);
			Eragiketa erag = new Eragiketa(mota, deskripzioa, eragiketaKodLortu());
			DataAccess db = new DataAccess();

			diruaGehitu(id, dibisa, kop);
			db.eragiketaGehitu(erag, id, 0);
			db.close();

		} else {
			System.out.println("Error");
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

	@WebMethod
	public List<Sukurtsala> getSukurtsalak() {
		dbManager.open(false);
		List<Sukurtsala> a = dbManager.sukurtsalakLortu();
		dbManager.close();
		return a;

	}

	@WebMethod
	public float diruaGehitu(int id, Dibisa dibisa, float kop) {
	dbManager.open(false);
		dbManager.diruaGehitu(id, (float) (kop * dibisa.getTrukeBalioa()));
		return (float) (kop * dibisa.getTrukeBalioa());

	}

}
