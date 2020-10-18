package bezeroZerbitzua;

import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import service.*;

public class BezeroZerb {
	
	public static void main(String[]args) throws Exception{
		 URL url=new URL("http://localhost:9999/ws?wsdl");
         QName qname=new QName("http://service/","BLFacadeImplementationService");
         Service service=Service.create(url,qname);
         BLFacade wsl=service.getPort(BLFacade.class);
         System.out.println(wsl.getBezero(0).toString());
         
         
		
	}

}
