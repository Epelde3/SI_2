package bezeroZerbitzua;

import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import dataAccess.DataAccess;
import service.*;

public class BezeroZerb {
	
	public static void main(String[]args) throws Exception{
		 URL url=new URL("http://localhost:9999/ws?wsdl");
         QName qname=new QName("http://service/","BLFacadeImplementationService");
         Service service=Service.create(url,qname);
         BLFacade wsl=service.getPort(BLFacade.class);
         System.err.println(wsl.getBezero(0).toString());
         DataAccess da=new DataAccess(true);
         wsl=new BLFacadeImplementation(da);
         
         
		
	}

}
