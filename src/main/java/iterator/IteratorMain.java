package iterator;

import domain.Sukurtsala;
import factory.ServerStateFactory;
import service.BLFacade;

public class IteratorMain {

	public static void main(String[] args) {
		boolean isLocal=true;
		ServerStateFactory factory=new ServerStateFactory();
		BLFacade wsl= factory.zerbLortu(isLocal);

		ExtendedIterator i=wsl.getSukurtsalakIterator();
		
		i.goLast();
		while(i.hasPrevious()) {
			Sukurtsala a=i.previous();
			System.out.println(a.toString());
			
		}
		
		i.goFirst();
		while(i.hasNext()) {
			Sukurtsala a=i.next();
			System.out.println(a.toString());
		}
	}

}
