package domain;


import javax.persistence.OneToMany;
import javax.persistence.FetchType;
import javax.persistence.CascadeType;
import java.util.ArrayList;
import java.io.Serializable;

public class KontuaProduct implements Serializable {
	private ArrayList<Eragiketa> eragiketaList;

	public ArrayList<Eragiketa> getEragiketaList() {
		return eragiketaList;
	}

	public void setEragiketaList(ArrayList<Eragiketa> eragiketaList) {
		this.eragiketaList = eragiketaList;
	}

	public void eragiketaGehitu(Eragiketa eragiketa) {
		if (this.eragiketaList == null) {
			eragiketaList = new ArrayList<Eragiketa>();
		}
		eragiketaList.add(eragiketa);
	}
}