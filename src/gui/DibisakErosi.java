package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import domain.Kontua;
import domain.SukurtsalDibisa;
import domain.Sukurtsala;
import service.BLFacade;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

//Bezeroak gure dibisak erosiko ditu
public class DibisakErosi extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;

	private Kontua localBezero;

	private SukurtsalDibisa localDibisa;

	private Sukurtsala localSukur;
	
	private JTextField kopurua;
	
	private Double prezioaErag;
	
	private BLFacade wsl;

	private DefaultComboBoxModel<SukurtsalDibisa> dibisalist = new DefaultComboBoxModel<SukurtsalDibisa>();

	public void setBezero(Kontua bezeroa) {
		this.localBezero = bezeroa;
	}

	public void setSukurtsal(Sukurtsala sukurtsal) {
		this.localSukur = sukurtsal;
	}
	
	public Double getPrezioa() {
		return prezioaErag;
	}

	public void setPrezioa(Double prezioa) {
		this.prezioaErag = prezioa;
	}
	public void setWsl(BLFacade wsl) {
		this.wsl=wsl;
	}
	

	/**
	 * Launch the application.
	 */
	// public static void main(String[] args) {
	// EventQueue.invokeLater(new Runnable() {
	// public void run() {
	// try {
	// DibisakErosi frame = new DibisakErosi();
	// frame.setVisible(true);
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// }
	// });
	// }

	

	/**
	 * Create the frame.
	 */
	public DibisakErosi() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 489, 370);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel prezioa = new JLabel("Eragiketaren prezioa:");
		prezioa.setBounds(30, 306, 176, 14);
		contentPane.add(prezioa);

		

		JButton bezeroarenInfo = new JButton("Bezeroaren informazioa ikusi");
		bezeroarenInfo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				KontuInfo a=new KontuInfo();
				a.setLocalBezero(localBezero);
				a.setVisible(true);
				a.toFront();
			}
		});
		
		bezeroarenInfo.setBounds(294, 265, 169, 23);
		contentPane.add(bezeroarenInfo);

		JLabel lblNewLabel = new JLabel("Aukeratu sukurtsaleko dibisa bat.");
		lblNewLabel.setBounds(110, 11, 198, 31);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Adierazi bezeroak erosiko duen dibisa kopurua");
		lblNewLabel_1.setBounds(10, 223, 239, 14);
		contentPane.add(lblNewLabel_1);

		kopurua = new JTextField();
		kopurua.setBounds(246, 220, 74, 20);
		contentPane.add(kopurua);
		kopurua.setColumns(10);

		

		
		
		JButton btnEragiketaGauzatu = new JButton("Eragiketa Gauzatu");
		btnEragiketaGauzatu.setEnabled(false);
		btnEragiketaGauzatu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(btnEragiketaGauzatu.isEnabled()) {
					
				EragiketaGauzatu a=new EragiketaGauzatu();
				a.setEragiketaMota("Erosi");
				a.setVisible(true);
				setVisible(false);
				a.setLocalBezero(localBezero);
				a.setLocalDibisa(localDibisa);
				a.setLocalSuk(localSukur);
				a.setPrezioa(prezioaErag);
				a.setWsl(wsl);
				a.setKopurua(Integer.parseInt(kopurua.getText()));
					
				}
			}
		});
		btnEragiketaGauzatu.setBounds(277, 302, 186, 23);
		contentPane.add(btnEragiketaGauzatu);
		
		JLabel lblErroreak = new JLabel("");
		lblErroreak.setBounds(10, 187, 310, 14);
		contentPane.add(lblErroreak);
		
		JButton btnPrezioaLortu = new JButton("Prezioa lortu");
		btnPrezioaLortu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {//Try catch falta da
				// orain prezioa kalkulatu
				try {
//				BLFacade bl = new BLFacadeImplementation();
					System.out.println(localDibisa.toString());
				prezioaErag=wsl.prezioaKalkulatu(localDibisa, Integer.parseInt(kopurua.getText()));
				prezioa.setText("Eragiketaren Prezioa= "
						+ prezioaErag);
				btnEragiketaGauzatu.setEnabled(true);
				}catch(NumberFormatException err) {
					lblErroreak.setText("Baliozkoa den zenbaki bat idatz mesedez.");
				}
				

			}
		});
		btnPrezioaLortu.setBounds(20, 265, 131, 23);
		contentPane.add(btnPrezioaLortu);
		
		JLabel dibisaIzen = new JLabel("");
		dibisaIzen.setBounds(10, 85, 121, 14);
		contentPane.add(dibisaIzen);
		
		JLabel irabazteKomisio = new JLabel("");
		irabazteKomisio.setBounds(10, 110, 141, 14);
		contentPane.add(irabazteKomisio);
		
		JLabel dibisaKop = new JLabel("");
		dibisaKop.setBounds(189, 85, 186, 14);
		contentPane.add(dibisaKop);
		
		JLabel trukeBalioa = new JLabel("");
		trukeBalioa.setBounds(189, 110, 239, 14);
		contentPane.add(trukeBalioa);
		
		
		
		JComboBox<SukurtsalDibisa> dibisaLista = new JComboBox<>();
		dibisaLista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				localDibisa = (SukurtsalDibisa) dibisaLista.getSelectedItem();
				dibisaIzen.setText("Izena; "+localDibisa.getIzena());
				irabazteKomisio.setText("Irabazte Komisioa: "+localDibisa.getIrabazteKomisioa());
				dibisaKop.setText("Kopurua: "+localDibisa.getKopurua());
				trukeBalioa.setText("Truke Balioa: "+localDibisa.getDibisa().getTrukeBalioa());
				if(localDibisa.getKopurua()<=0) {
					btnEragiketaGauzatu.setEnabled(false);
					lblNewLabel_1.setText("Sukurtsalak momentu honetan ez du dibisa mota hori.");
					
				}

			}
		});
		dibisaLista.setModel(dibisalist);

		dibisaLista.setBounds(120, 53, 176, 20);
		contentPane.add(dibisaLista);
		
		JButton btnNewButton = new JButton("Datuak Lortu");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dibisaLista.removeAllItems();
				for (SukurtsalDibisa dibisa : localSukur.getDibisak()) {
					dibisaLista.addItem(dibisa);
				}
			}
		});
		btnNewButton.setBounds(342, 15, 121, 23);
		contentPane.add(btnNewButton);
		
		JButton btnAtzera = new JButton("Atzera");
		btnAtzera.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Aukeraketa a=new Aukeraketa();
				a.setBezero(localBezero);
				a.setSukurtsal(localSukur);
				a.setWsl(wsl);
				a.setVisible(true);
				setVisible(false);
			}
		});
		btnAtzera.setBounds(0, 15, 89, 23);
		contentPane.add(btnAtzera);
		
		
		
		
	}
}
