package domain;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlAccessorType(XmlAccessType.FIELD)
@Entity
public class Kontua implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	

	@XmlID
	@XmlJavaTypeAdapter(IntegerAdapter.class)
	@Id
	@GeneratedValue
	private Integer id;
	// @OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private ArrayList<Eragiketa> eragiketaList;
	
	private String kontuIzena;

	private double diruKopuru;

	// Eraikitzailea
	public Kontua(String kontuIzena, float diruKopuru, Integer id) {
		super();
		this.kontuIzena = kontuIzena;
		this.diruKopuru = diruKopuru;
		this.id = id;
	}

	public Kontua() {

	}

	// Trantzakzio bat gauzatzen denean gehitu egingo da eragiketaList-era
	public void eragiketaGehitu(Eragiketa eragiketa) {
		if (this.eragiketaList == null) {
			eragiketaList = new ArrayList<Eragiketa>();
		}
		eragiketaList.add(eragiketa);
	}

	// Geter eta setterrak
	public String getKontuIzena() {
		return kontuIzena;
	}

	public void setKontuIzena(String kontuIzena) {
		this.kontuIzena = kontuIzena;
	}

	public double getDiruKopuru() {
		return diruKopuru;
	}

	public void setDiruKopuru(double diruKopuru) {
		this.diruKopuru = diruKopuru;
	}

	public int getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public ArrayList<Eragiketa> getEragiketaList() {
		return this.eragiketaList;
	}

	public void setEragiketaList(ArrayList<Eragiketa> eragiketaLista) {
		this.eragiketaList = eragiketaLista;
	}

	@Override
	public String toString() {
		return this.getKontuIzena() + " " + this.getDiruKopuru() + " " + this.getId();

	}
}
