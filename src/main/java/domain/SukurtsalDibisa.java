package domain;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlID;


@Entity
@XmlAccessorType(XmlAccessType.FIELD)
public class SukurtsalDibisa implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	private Dibisa dibisa;
	private float kopurua;
	private double irabazteKomisioa;
	@XmlID
	@Id
	private String izena;

	// Eraikitzailea
	public SukurtsalDibisa(Dibisa dibisa, int kopurua, double irabazteKomisioa,String izena) {
		super();
		this.dibisa = dibisa;
		this.kopurua = kopurua;
		this.irabazteKomisioa = irabazteKomisioa;
		this.izena=izena;
	}
	public SukurtsalDibisa() {
		
	}

	// Geter eta seterrak
	public Dibisa getDibisa() {
		return dibisa;
	}

	public void setDibisa(Dibisa dibisa) {
		this.dibisa = dibisa;
	}

	public float getKopurua() {
		return kopurua;
	}

	public void setKopurua(float kopurua) {
		this.kopurua = kopurua;
	}

	public double getIrabazteKomisioa() {
		return irabazteKomisioa;
	}

	public void setIrabazteKomisioa(double irabazteKomisioa) {
		this.irabazteKomisioa = irabazteKomisioa;
	}
	public String getIzena() {
		return this.izena;
	}
	public void setString(String izena) {
		this.izena=izena;
	}
	
	public String toString() {
		return this.getDibisa().getIzena();
	}
	
	public String datuakLortu() {
		return (this.dibisa.toString()+"  Kopurua: "+this.getKopurua()+"   Irabazte Komisioa: "+this.getIrabazteKomisioa());
	}

}
