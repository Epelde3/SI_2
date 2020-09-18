package domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlAccessorType(XmlAccessType.FIELD)
@Entity
public class Eragiketa implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Atributuak
	private String mota;
	private String deskripzioa;
	@XmlID
	@Id
	@XmlJavaTypeAdapter(IntegerAdapter.class)
	private  Integer kodigoa;

	
	public Eragiketa(String mota, String deskripzioa,int kodigoa) {
		this.mota = mota;
		this.deskripzioa = deskripzioa;
		this.kodigoa = kodigoa;
	}
	
	public Eragiketa() {
		
	}

	// Geter eta seterrak
	public String getMota() {
		return mota;
	}
	
	

	public void setMota(String mota) {
		this.mota = mota;
	}

	public String getDeskripzioa() {
		return deskripzioa;
	}

	public void setDeskripzioa(String deskripzioa) {
		this.deskripzioa = deskripzioa;
	}

	public int getKodigoa() {
		return kodigoa;
	}

	public void setKodigoa(int kodigoa) {
		this.kodigoa = kodigoa;
	}
	@Override
	public String toString() {
		return ("ID: "+this.getKodigoa());
	}

}
