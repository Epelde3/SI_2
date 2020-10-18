package dataAccess;

import java.util.ArrayList;
import java.util.List;

import domain.*;


public interface DataAccessInterface {

	void open(boolean initializemode);

	void close();

	Kontua getBezeroa(int id) throws NullPointerException;

	ArrayList<Dibisa> getSukurtsalekoDibisak(String helbidea);

	void erosketaEtaSaltzeaGauzatu(int id, float prezioa);

	void dibisakGehitu(Dibisa dibisa, float kopurua, String helbidea);

	//Kontuari eragiketa gehitzen dio eta kontuko dirua eguneratzen du.
	void eragiketaGehitu(Eragiketa erag, int id, double prezioa);

	List<Eragiketa> ergiketaKodLortu();

	List<Sukurtsala> sukurtsalakLortu();

	void diruaGehitu(int id, float kop);

	//Probak egiteko
	void proba();

	//DAtuak sartzeko
	void initializeDB();

	Sukurtsala getSukurtsala(String helbidea);

}