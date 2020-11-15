package domain;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlAccessorType(XmlAccessType.FIELD)
@Entity
public class Kontua implements Serializable {
	@OneToMany(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	private EragiketaList eragiketaList;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@XmlID
	@XmlJavaTypeAdapter(IntegerAdapter.class)
	@Id
	@GeneratedValue
	private Integer id;
	private String kontuIzena;

	private double diruKopuru;

	// Eraikitzailea
	public Kontua(String kontuIzena, float diruKopuru, Integer id, EragiketaList kontuaProduct) {
		super();
		this.kontuIzena = kontuIzena;
		this.diruKopuru = diruKopuru;
		this.id = id;
		this.eragiketaList = kontuaProduct;
	}

	public Kontua() {

	}

	// Trantzakzio bat gauzatzen denean gehitu egingo da eragiketaList-era
	public void eragiketaGehitu(Eragiketa eragiketa) {
		this.eragiketaList.eragiketaGehitu(eragiketa);
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
		return this.eragiketaList.getEragiketaList();
	}

	public void setEragiketaList(ArrayList<Eragiketa> eragiketaLista) {
		eragiketaList.setEragiketaList(eragiketaLista);
	}

	@Override
	public String toString() {
		return this.getKontuIzena() + " " + this.getDiruKopuru() + " " + this.getId();

	}
}
