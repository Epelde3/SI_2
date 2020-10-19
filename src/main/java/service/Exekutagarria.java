package service;

import javax.xml.ws.Endpoint;

import dataAccess.DataAccess;
import gui.*;

public class Exekutagarria {

	public static void main(String[] args) {
		DataAccess dao=new DataAccess();
		Endpoint.publish("http://0.0.0.0:9999/ws", new BLFacadeImplementation(dao));
		System.out.println("Desplegatua izan da");
		
		Hasiera a=new Hasiera();
		a.setVisible(true);

	}

}
