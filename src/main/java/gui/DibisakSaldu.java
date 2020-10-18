package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import domain.*;
import service.*;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class DibisakSaldu extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;

	private Kontua localBezero;
	private Sukurtsala localSuk;

	private DefaultComboBoxModel<SukurtsalDibisa> dibisaLista = new DefaultComboBoxModel<>();

	private SukurtsalDibisa localDibisa;

	private JTextField salduNahiDenKop;

	private transient BLFacade wsl;

	public void setLocalSuk(Sukurtsala newLocal) {
		this.localSuk = newLocal;
	}

	public void setLocalBez(Kontua bezero) {
		this.localBezero = bezero;
	}

	public void setWsl(BLFacade wsl) {
		this.wsl = wsl;
	}

	
	public DibisakSaldu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 567, 330);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel dibisenInfoIkusi = new JLabel("");
		dibisenInfoIkusi.setBounds(10, 42, 361, 133);
		contentPane.add(dibisenInfoIkusi);
		
		JLabel lblBezeroakSalduNahi = new JLabel("Bezeroak saldu nahi dituen dibisa kopurua");
		lblBezeroakSalduNahi.setBounds(10, 186, 237, 14);
		contentPane.add(lblBezeroakSalduNahi);
		
		JComboBox<SukurtsalDibisa> dibisaList = new JComboBox<>();
		dibisaList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				localDibisa=(SukurtsalDibisa)dibisaList.getSelectedItem();
				dibisenInfoIkusi.setText(localDibisa.datuakLortu());
				lblBezeroakSalduNahi.setText("Bezeroak saldu nahi dituen dibisa kopurua");
				
			}
		});
		dibisaList.setBounds(45, 11, 177, 20);
		contentPane.add(dibisaList);
		dibisaList.setModel(dibisaLista);
		
		
		
		JButton btnNewButton = new JButton("Informazioa Lortu");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				dibisaList.removeAllItems();
				for(SukurtsalDibisa dibisa:localSuk.getDibisak()) {
					dibisaList.addItem(dibisa);
					
				}
			}
		});
		btnNewButton.setBounds(247, 10, 177, 23);
		contentPane.add(btnNewButton);
		
		
		
		salduNahiDenKop = new JTextField();
		salduNahiDenKop.setBounds(316, 186, 86, 20);
		contentPane.add(salduNahiDenKop);
		salduNahiDenKop.setColumns(10);
		
		JButton btnBezeroarenInformazioaLortu = new JButton("Bezeroaren informazioa lortu");
		btnBezeroarenInformazioaLortu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				KontuInfo a=new KontuInfo();
				a.setLocalBezero(localBezero);
				a.setVisible(true);
				a.toFront();
			}
		});
		btnBezeroarenInformazioaLortu.setBounds(10, 257, 212, 23);
		contentPane.add(btnBezeroarenInformazioaLortu);
		
		JButton btnEragiketaGauzatu = new JButton("Eragiketa Gauzatu");
		btnEragiketaGauzatu.setEnabled(false);
		btnEragiketaGauzatu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					if(btnEragiketaGauzatu.isEnabled()==true) {
				EragiketaGauzatu a=new EragiketaGauzatu();
				a.setLocalBezero(localBezero);
				a.setLocalDibisa(localDibisa);
				a.setLocalSuk(localSuk);
				a.setWsl(wsl);
				a.setEragiketaMota("Salketa");
				a.setKopurua(Integer.parseInt(salduNahiDenKop.getText()));
				a.setVisible(true);
				setVisible(false);
					}
				}catch(NumberFormatException e) {
					lblBezeroakSalduNahi.setText("Mesedez egokia den zenbaki bat idatzi.");
				}
				}
		});
		btnEragiketaGauzatu.setBounds(378, 257, 163, 23);
		contentPane.add(btnEragiketaGauzatu);
		
		JButton btnNewButton_1 = new JButton("Atzera");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Aukeraketa a=new Aukeraketa();
				a.setWsl(wsl);
				a.setSukurtsal(localSuk);
				a.setBezero(localBezero);
				a.setSukurtsal(localSuk);
				a.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton_1.setBounds(230, 257, 141, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblBezeroarenGanantzia = new JLabel("New label");
		lblBezeroarenGanantzia.setBounds(10, 211, 212, 14);
		contentPane.add(lblBezeroarenGanantzia);
		
		JButton btnGanantzaiIkusi = new JButton("Ganantzai Ikusi");
		btnGanantzaiIkusi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblBezeroarenGanantzia.setText("Bezeroaren ganantzia="+ localDibisa.getDibisa().getTrukeBalioa()*Integer.parseInt(salduNahiDenKop.getText()));
				btnEragiketaGauzatu.setEnabled(true);
			}
		});
		btnGanantzaiIkusi.setBounds(378, 223, 173, 23);
		contentPane.add(btnGanantzaiIkusi);
		
		
		
	}
}
