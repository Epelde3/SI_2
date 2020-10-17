package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import domain.SukurtsalDibisa;
import domain.Sukurtsala;
import service.BLFacade;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SukurtsalAldatu extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	
	private BLFacade wsl;
	
	private  DefaultComboBoxModel<Sukurtsala> sukurtsalList = new DefaultComboBoxModel<Sukurtsala>();
	
	private Sukurtsala localSuk;

	public void setWsl(BLFacade wsl) {
		this.wsl=wsl;
	}
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					SukurtsalAldatu frame = new SukurtsalAldatu();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public SukurtsalAldatu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		JButton btnAtzera = new JButton("Atzera");
		btnAtzera.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Hasiera a=new Hasiera();
				a.setWsl(wsl);
				a.setVisible(true);
				setVisible(false);
			}
		});
		btnAtzera.setBounds(324, 45, 100, 23);
		contentPane.add(btnAtzera);
		
		JComboBox<Sukurtsala> sukurtsalLista = new JComboBox<Sukurtsala>();
		sukurtsalLista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				localSuk=(Sukurtsala) sukurtsalLista.getSelectedItem();
				
			}
		});
		sukurtsalLista.setBounds(10, 12, 176, 20);
		contentPane.add(sukurtsalLista);
		sukurtsalLista.setModel(sukurtsalList);
		
		JLabel lblSukurtsalInfo = new JLabel("");
		lblSukurtsalInfo.setBounds(10, 129, 127, 14);
		contentPane.add(lblSukurtsalInfo);
		
		JButton btnDatuakLortu = new JButton("Datuak lortu");
		btnDatuakLortu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				sukurtsalLista.removeAllItems();
				for (Sukurtsala suk : wsl.getSukurtsalak()) {
					sukurtsalLista.addItem(suk);					
				}
			}
		});
		btnDatuakLortu.setBounds(314, 11, 110, 23);
		contentPane.add(btnDatuakLortu);
		
		JButton btnSukurtsalaAldatu = new JButton("Sukurtsala Aldatu");
		btnSukurtsalaAldatu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Hasiera a=new Hasiera();
				a.setSukurtsal(localSuk);
				a.setVisible(true);
				setVisible(false);
			}
		});
		btnSukurtsalaAldatu.setBounds(271, 227, 153, 23);
		contentPane.add(btnSukurtsalaAldatu);
	}
}
