package domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlID;
//comentario gehitu da

@Entity
@XmlAccessorType(XmlAccessType.FIELD)
public class Dibisa implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@XmlID
	@Id
	private String izena;
	private double trukeBalioa;

	// Eraikitailea
	public Dibisa(String izena, double trukeBalioa) {
		super();
		this.izena = izena;
		this.trukeBalioa = trukeBalioa;
	}
	public Dibisa() {
		
	}

	// Geter eta seterrak
	public String getIzena() {
		return izena;
	}

	public void setIzena(String izena) {
		this.izena = izena;
	}

	public double getTrukeBalioa() {
		return trukeBalioa;
	}

	public void setTrukeBalioa(float trukeBalioa) {
		this.trukeBalioa = trukeBalioa;
	}
	@Override
	public String toString() {
		return ("Izena: "+this.getIzena()+" Truke Balioa: "+this.getTrukeBalioa());
	}

}
