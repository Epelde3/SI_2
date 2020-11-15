package gui;

import javax.swing.JTable;


import adapter.TableAdapter;
import dataAccess.DataAccess;
import domain.Kontua;
import service.BLFacade;
import service.BLFacadeImplementation;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import java.awt.Dimension;

public class Table extends JFrame implements ActionListener {
   private TableAdapter tableModel;
   private JTable table;
   private BLFacade wsl;
//   private SimpleBookList myList;
   public Table(BLFacade wsl) {
	   this.wsl=wsl;
      
      setBounds(500,500,400,300);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      
      
//      DataAccess da=new DataAccess(false);
//      BLFacade wsl=new BLFacadeImplementation(da);
      
      Kontua user=wsl.getBezero(12);
      
      tableModel = new TableAdapter(user);
      table = new JTable(tableModel);
      table.setAutoCreateRowSorter(true);
      JScrollPane scrollPane = new JScrollPane(table);
      scrollPane.setPreferredSize(new Dimension(1380,1280));
      JPanel panel = new JPanel();
      panel.add(scrollPane);
      add(panel,BorderLayout.CENTER);
   }
  

   public void setWsl(BLFacade wsl) {
		this.wsl=wsl;
	}

@Override
public void actionPerformed(ActionEvent arg0) {
	// TODO Auto-generated method stub
	
}
}
