package domain;


import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlID;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.CascadeType;
import javax.persistence.Entity;

import java.util.ArrayList;
import java.io.Serializable;

@XmlAccessorType(XmlAccessType.FIELD)
@Entity
public class EragiketaList implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@XmlID
	@Id
	private  int id=1;
	@OneToMany(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
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