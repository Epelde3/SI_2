package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import domain.*;
import service.*;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.Serializable;

public class EragiketaGauzatu extends JFrame implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;

	private Kontua localBezero;

	private Sukurtsala localSuk;

	private double prezioa;

	private SukurtsalDibisa localDibisa;

	private String eragiketaMota;

	private int kopurua;

	private BLFacade wsl;

	/**
	 * Launch the application.
	 */
	// public static void main(String[] args) {
	// EventQueue.invokeLater(new Runnable() {
	// public void run() {
	// try {
	// EragiketaGauzatu frame = new EragiketaGauzatu();
	// frame.setVisible(true);
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// }
	// });
	// }

	public void setLocalBezero(Kontua localBezero) {
		this.localBezero = localBezero;
	}

	public void setLocalSuk(Sukurtsala localSuk) {
		this.localSuk = localSuk;
	}

	public void setPrezioa(double prezioa) {
		this.prezioa = prezioa;
	}

	public void setLocalDibisa(SukurtsalDibisa localDibisa) {
		this.localDibisa = localDibisa;
	}

	public void setEragiketaMota(String eragiketaMota) {
		this.eragiketaMota = eragiketaMota;
	}

	public void setKopurua(int kopurua) {
		this.kopurua = kopurua;
	}

	public void setWsl(BLFacade wsl) {
		this.wsl = wsl;
	}

	/**
	 * Create the frame.
	 */
	public EragiketaGauzatu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 572, 437);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel eragiketaDeskripzioa = new JLabel("\"Eragiketa ikusi sakatu\"");
		eragiketaDeskripzioa.setBounds(28, 67, 518, 142);
		contentPane.add(eragiketaDeskripzioa);

		JButton eragiketabaztertu = new JButton("Eragiketa Baztertu");
		eragiketabaztertu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Hasiera a = new Hasiera();
				a.setVisible(true);
				setVisible(false);

			}
		});
		eragiketabaztertu.setBounds(271, 220, 161, 23);
		contentPane.add(eragiketabaztertu);

		JButton btnNewButton = new JButton("Bezeroaren informazioa ikusi");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				KontuInfo a = new KontuInfo();
				a.setVisible(true);
				a.setLocalBezero(localBezero);
				a.toFront();
			}
		});
		btnNewButton.setBounds(242, 11, 190, 23);
		contentPane.add(btnNewButton);

		JButton eragiketaGauzatu = new JButton("Eragiketa Gauzatu");
		eragiketaGauzatu.setEnabled(false);
		eragiketaGauzatu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// BLFacade bl=new BLFacadeImplementation();
				if (eragiketaGauzatu.isEnabled()) {
					wsl.erosketaGauzatu(localBezero.getId(), localDibisa.getDibisa(), kopurua,
							kopurua * localDibisa.getDibisa().getTrukeBalioa(), eragiketaDeskripzioa.getText(),
							eragiketaMota, localSuk.getHelbidea());

					// bl.erosketaGauzatu(localBezero.getId(), localDibisa.getDibisa(), kopurua,
					// prezioa,
					// eragiketaDeskripzioa.getText(), eragiketaMota);

					Hasiera a = new Hasiera();
					a.setSukurtsal(localSuk);
					a.setVisible(true);
					setVisible(false);
				}
			}
		});
		eragiketaGauzatu.setBounds(28, 227, 156, 23);
		contentPane.add(eragiketaGauzatu);

		JButton btnEragiketaIkusi = new JButton("Eragiketa Ikusi");
		btnEragiketaIkusi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (eragiketaMota.equals("Erosi")) {
					eragiketaDeskripzioa.setText("Gauzatu den eragiketa mota: " + eragiketaMota + "Bezeroak " + kopurua
							+ " " + localDibisa.getDibisa().getIzena() + " dibisa erosi ditu. " + "Prezioa: "
							+ prezioa);
				} else {
					// Eragiketa: bezeroak dibisak saldu ditu
					eragiketaDeskripzioa.setText("Gauzatu den eragiketa mota: " + eragiketaMota + " Bezroak" + kopurua
							+ " " + localDibisa.getDibisa().getIzena() + " " + "saldu dizkio sukurtsalari");
				}
				eragiketaGauzatu.setEnabled(true);
			}
		});
		btnEragiketaIkusi.setBounds(10, 11, 174, 23);
		contentPane.add(btnEragiketaIkusi);
	}
}
