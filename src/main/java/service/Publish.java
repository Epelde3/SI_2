package service;

import javax.xml.ws.Endpoint;

import dataAccess.DataAccess;

public class Publish {

	public static void main(String[] args) {
		DataAccess db=new DataAccess(true);
		Endpoint.publish("http://0.0.0.0:9999/ws", new BLFacadeImplementation(db));
		System.out.println("Desplegatua izan da");
	}		

}
