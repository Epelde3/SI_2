package service;

import javax.xml.ws.Endpoint;

import gui.*;

public class Exekutagarria {

	public static void main(String[] args) {
		Endpoint.publish("http://0.0.0.0:9999/ws", new BLFacadeImplementation(null));
		System.out.println("Desplegatua izan da");
		
		Hasiera a=new Hasiera();
		a.setVisible(true);

	}

}
