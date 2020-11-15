package service;

import factory.ServerStateFactory;
import gui.*;

public class Exekutagarria {

	public static void main(String[] args) {
		try {
			BLFacade wsl;
			boolean local=true;
			ServerStateFactory factory=new ServerStateFactory();
			wsl=factory.zerbLortu(local);
			Hasiera a=new Hasiera();
			a.setWsl(wsl);
			a.setVisible(true);
		} catch (Exception e1) {

			e1.printStackTrace();
		}

	}

}
