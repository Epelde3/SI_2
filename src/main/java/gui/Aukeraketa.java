package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import domain.*;
import service.*;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Aukeraketa extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	
	private Kontua localBezero;
	
	private Sukurtsala localSuk;
	
	private BLFacade wsl;
	
	public Sukurtsala getSuk() {
		return this.localSuk;
	}
	
	public Kontua localBezero() {
		return this.localBezero;
	}
	public void setBezero(Kontua bezero) {
		this.localBezero=bezero;
	}
	
	public void setSukurtsal(Sukurtsala suk) {
		this.localSuk=suk;
	}
	public void setWsl(BLFacade wsl) {
		this.wsl=wsl;
	}

	
	/**
	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Aukeraketa frame = new Aukeraketa();
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
	public Aukeraketa() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 324);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Bezeroak dibisak saldu nahi ditu.");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				DibisakSaldu a=new DibisakSaldu();
				a.setLocalBez(localBezero);
				a.setLocalSuk(localSuk);
				a.setWsl(wsl);
				a.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(106, 11, 234, 99);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Bezeroak dibisak erosi nahi ditu.");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DibisakErosi a=new DibisakErosi();
				a.setBezero(localBezero);
				a.setSukurtsal(localSuk);
				a.setWsl(wsl);
				a.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton_1.setBounds(106, 121, 234, 104);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Bezeroaren informazioa ikusi");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				KontuInfo a=new KontuInfo();
				a.setLocalBezero(localBezero);
				a.setVisible(true);
				a.toFront();
			}
		});
		btnNewButton_2.setBounds(104, 236, 236, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Atzera");
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Hasiera a=new Hasiera();
				a.setWsl(wsl);
				a.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton_3.setBounds(106, 262, 234, 23);
		contentPane.add(btnNewButton_3);
	}
}
