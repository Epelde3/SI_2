package adapter;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import domain.Eragiketa;
import domain.Kontua;

public class TableAdapter extends AbstractTableModel {

	Kontua user;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TableAdapter(Kontua user) {
		this.user = user;
	}

	@Override
	public int getColumnCount() {
		return 3;
	}
	@Override
	public String getColumnName(int col){
		if(col==0) {
			return "Mota";
		}else if(col==1){
			return "Deskripzioa";
		}else {
			return "Kodigoa";
		}
		
	}

	@Override
	public int getRowCount() {
		return user.getEragiketaList().size();
	}

	@Override
	public Object getValueAt(int arg0, int arg1) {
		Object temp=null;
		ArrayList<Eragiketa> myList = user.getEragiketaList();
		if(arg1==0) {
			temp=myList.get(arg0).getMota(); 
		}else if(arg1==1) {
			temp=myList.get(arg0).getDeskripzioa(); 
		}else if(arg1==2){
			temp=myList.get(arg0).getKodigoa(); 
		}
		return temp;
	}

}
