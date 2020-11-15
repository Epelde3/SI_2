package factory;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Endpoint;
import javax.xml.ws.Service;

import dataAccess.DataAccess;
import service.BLFacade;
import service.BLFacadeImplementation;

public class ServerStateFactory {
	

	public BLFacade zerbLortu(boolean local) {
		BLFacade wsl=null;
		DataAccess da=new DataAccess(true);
		if(local) {
			
			wsl=new BLFacadeImplementation(da);
			
		}else {
			URL url;
			try {
				url = new URL("http://localhost:9999/ws?wsdl");
				QName qname = new QName("http://service/", "BLFacadeImplementationService");
				Endpoint.publish("http://0.0.0.0:9999/ws", new BLFacadeImplementation(da));
				Service service = Service.create(url, qname);
				wsl = service.getPort(BLFacade.class);
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
			
			
		}
		return wsl;
	}
}
