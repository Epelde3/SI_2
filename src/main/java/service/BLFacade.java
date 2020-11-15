package service;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import domain.*;
import iterator.ExtendedIterator;

@WebService
public interface BLFacade {
	// Id bat emanda, id hori duen bezeroa itzultzen du
	@WebMethod
	public Kontua getBezero(int id);

	// Bezero baten kontuan adierzaten den dibisa kopurua gehitzen da.
	@WebMethod
	public void dibisakEguneratu(Dibisa dibisa, float kopurua,String helbidea);

	// Bezero batek dibisak erosteko prozesua gauzatzen du.
	@WebMethod
	public void erosketaGauzatu(int id, Dibisa dibisa, int kop, double prezioa, String deskripzioa, String mota,String helbidea) throws Exception;

	// Sukurtsala lortuko du datu basetik
	@WebMethod
	public Sukurtsala getSukurtsala(String helbidea);

	// Sukurtsal guztien lista itzultzen du.
	@WebMethod
	public List<Sukurtsala> getSukurtsalak();
	
	//Sukurtsalen iteradorea itzultzen du.
	@WebMethod
	public ExtendedIterator getSukurtsalakIterator();

	// Eragiketaren prezioa kalkulatzen du
	@WebMethod
	public double prezioaKalkulatu(SukurtsalDibisa dibisa, int kopurua);
	//Salketa baten kopurua kalkulatzen du.
	@WebMethod	
	public float diruaGehitu(int id,Dibisa dibisa,float kop);

}
