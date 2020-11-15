package iterator;

import java.util.Iterator;

import domain.Sukurtsala;

public interface ExtendedIterator extends Iterator<Sukurtsala> {
	//uneko elementua itzultzen du eta aurrekora pasatzen da
	public Sukurtsala previous();
	//true aurreko elementua existitzen bada.
	public boolean hasPrevious();
	//Lehendabiziko elementuan kokatzen da.
	public void goFirst();
	//Azkeneko elementuan kokatzen da.
	public void goLast();

}
