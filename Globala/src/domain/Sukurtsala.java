package domain;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlID;

@Entity
@XmlAccessorType(XmlAccessType.FIELD)
public class Sukurtsala implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@OneToMany(fetch=FetchType.EAGER,cascade=CascadeType.ALL)	
	private ArrayList<SukurtsalDibisa> dibisak;
	@XmlID//Gakoa
	@Id
	private String helbidea;
//	@OneToMany(fetch=FetchType.EAGER,cascade=CascadeType.ALL)	
//	private ArrayList<Kontua> bezeroList;
	

	public Sukurtsala(ArrayList<SukurtsalDibisa> dibisak, String helbidea) {
		super();
		this.dibisak = dibisak;
		this.helbidea = helbidea;
		
	}
	
	public Sukurtsala() {
		
	}

	public ArrayList<SukurtsalDibisa> getDibisak() {
		return dibisak;
	}

	public void setDibisak(ArrayList<SukurtsalDibisa> dibisak) {
		this.dibisak = dibisak;
	}

	public String getHelbidea() {
		return helbidea;
	}

	public void setHelbidea(String helbidea) {
		this.helbidea = helbidea;
	}

//	public ArrayList<Kontua> getBezeroList() {
//		
//		return bezeroList;
//	}
//
//	public void setBezeroList(ArrayList<Kontua> bezeroList) {
//		this.bezeroList = bezeroList;
//	}
	
	public SukurtsalDibisa sukurtsalDibisaTopatu(String izena) {
		SukurtsalDibisa a=null;
		for (SukurtsalDibisa lag : dibisak) {
			if(lag.getIzena().equals(izena)) {
				 a=lag;
			}
		}
		return a;
	}
	@Override
	public String toString() {
		return this.helbidea;
	}

}
