package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import domain.*;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class KontuInfo extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	
	private Kontua localBezero;

	private DefaultComboBoxModel<Eragiketa> eragList = new DefaultComboBoxModel<Eragiketa>();
	
	public void setLocalBezero(Kontua bezero) {
		this.localBezero=bezero;
	}
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					KontuInfo frame = new KontuInfo();
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
	public KontuInfo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel eragiketaInfo = new JLabel("");
		eragiketaInfo.setBounds(10, 175, 378, 60);
		contentPane.add(eragiketaInfo);
				
		JComboBox<Eragiketa> eragiketaList = new JComboBox<Eragiketa>();
		eragiketaList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				eragiketaInfo.setText(((Eragiketa)eragiketaList.getSelectedItem()).getDeskripzioa());
			}
		});
		eragiketaList.setBounds(10, 105, 323, 20);
		contentPane.add(eragiketaList);
		eragiketaList.setModel(eragList);
		
		JLabel kontuIzena = new JLabel("Kontu Izena:");
		kontuIzena.setBounds(10, 15, 120, 14);
		contentPane.add(kontuIzena);
		
		JLabel diruKopLbl = new JLabel("Diru kopurua:");
		diruKopLbl.setBounds(10, 40, 99, 14);
		contentPane.add(diruKopLbl);
		
		
		JLabel lblId = new JLabel("Kontuaren ID:");
		lblId.setBounds(10, 64, 99, 14);
		contentPane.add(lblId);
		
		JButton btnNewButton = new JButton("Informazioa Eskuratu");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ArrayList<Eragiketa> lag=localBezero.getEragiketaList();
				for(Eragiketa erag:lag) {
					eragiketaList.addItem(erag);
					kontuIzena.setText("Kontu Izena: "+localBezero.getKontuIzena());
					diruKopLbl.setText("Diru kopurua: "+localBezero.getDiruKopuru());
					lblId.setText("Kontuaren ID: "+localBezero.getId());
				}
			}
		});
		btnNewButton.setBounds(252, 11, 172, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Atzera");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
			}
		});
		btnNewButton_1.setBounds(262, 36, 162, 23);
		contentPane.add(btnNewButton_1);
	}
}
