package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import dataAccess.DataAccess;
import dataAccess.DataAccessInterface;
import domain.Kontua;
import domain.Sukurtsala;
import service.BLFacade;
import service.BLFacadeImplementation;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.MalformedURLException;
import java.net.URL;

public class Hasiera extends JFrame {

	private static final long serialVersionUID = 1L;

	// Ondorengo atributuak erabiliko dira sortzen dire UI bakoitzak Sukurtsal bera
	// dutela bermatzeko. Segurunez static gebe-re ondo ibilikoa.
	private Sukurtsala localSukur;
	
	private Kontua localBezero;
	
	private BLFacade wsl;
	
	public void setSukurtsal(Sukurtsala sukur) {
		this.localSukur=sukur;
	}
	
	public void setBezero(Kontua bezero) {
		this.localBezero=bezero;
	}
	
	public void setWsl(BLFacade wsl) {
		this.wsl=wsl;
	}

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Hasiera frame = new Hasiera();
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
	public Hasiera() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel errorOutput = new JLabel("");
		errorOutput.setBounds(10, 216, 414, 34);
		contentPane.add(errorOutput);

		JLabel lblIdatziBezeroarenKontuaren = new JLabel("Idatzi bezeroaren kontuaren ID:");
		lblIdatziBezeroarenKontuaren.setBounds(10, 90, 191, 14);
		contentPane.add(lblIdatziBezeroarenKontuaren);

		textField = new JTextField();
		textField.setBounds(200, 87, 224, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		
		
		//Negozio logika lortu web zerbitzuetatik
		try {
//			URL url=new URL("http://localhost:9999/ws?wsdl");
//            QName qname=new QName("http://service/","BLFacadeImplementationService");
//            Service service=Service.create(url,qname);
//	         wsl=service.getPort(BLFacade.class);
			
			DataAccessInterface da=new DataAccess(true);
			wsl=new BLFacadeImplementation(da);
		} catch (Exception e1) {

			e1.printStackTrace();
		}
        
        
		//Hasierako sukurtsala adierazi
		if(localSukur==null) 
		localSukur=wsl.getSukurtsala("Donostia");
		
		JButton btnJarraitu = new JButton("Jarraitu");
		btnJarraitu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				
				try {
					//Honela bezeroa eskuratzen da
					localBezero=wsl.getBezero(Integer.parseInt(textField.getText()));
					if(localBezero==null) {
						errorOutput.setText("ID hori duen bezerorik ez da existitzen");
					}else {
					Aukeraketa a = new Aukeraketa();
					a.setSukurtsal(localSukur);
					a.setBezero(localBezero);
					a.setWsl(wsl);
					a.setVisible(true);
					setVisible(false);
					}
				} catch (Exception e) {
					e.printStackTrace();
					errorOutput.setText("ID hori duen bezerorik ez da existitzen");
				}

			}
		});
		btnJarraitu.setBounds(130, 169, 114, 23);
		contentPane.add(btnJarraitu);
		
		JLabel lblSukurtsalIzenagero = new JLabel("Sukurtsal Helbidea= "+localSukur.getHelbidea());
		lblSukurtsalIzenagero.setBounds(10, 11, 191, 14);
		contentPane.add(lblSukurtsalIzenagero);
		
		JButton btnSukurtsalaAldatu = new JButton("Sukurtsala Aldatu");
		btnSukurtsalaAldatu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SukurtsalAldatu a=new SukurtsalAldatu();
				a.setWsl(wsl);
				a.setVisible(true);
				setVisible(false);
			}
		});
		btnSukurtsalaAldatu.setBounds(216, 7, 149, 23);
		contentPane.add(btnSukurtsalaAldatu);

	}
}
