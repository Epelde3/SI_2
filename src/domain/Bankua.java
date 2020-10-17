package domain;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlID;
@Entity
@XmlAccessorType(XmlAccessType.FIELD)
public class Bankua implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@XmlID
	@Id
	private String bankuIzena;
	
	@OneToMany(fetch=FetchType.EAGER)
	private ArrayList<Sukurtsala> sukurtsalLista;
	
	@OneToMany(fetch=FetchType.EAGER)
	private ArrayList<Kontua> bezeroLista;
	
	

	public String getBankuIzena() {
		return bankuIzena;
	}

	public void setBankuIzena(String bankuIzena) {
		this.bankuIzena = bankuIzena;
	}

	public ArrayList<Sukurtsala> getSukurtsalLista() {
		return sukurtsalLista;
	}

	public void setSukurtsalLista(ArrayList<Sukurtsala> sukurtsalLista) {
		this.sukurtsalLista = sukurtsalLista;
	}

	public ArrayList<Kontua> getBezeroLista() {
		return bezeroLista;
	}

	public void setBezeroLista(ArrayList<Kontua> bezeroLista) {
		this.bezeroLista = bezeroLista;
	}
	

}
