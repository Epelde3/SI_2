package iterator;

import java.util.List;

import domain.Sukurtsala;

public class SukurtsalIterator implements ExtendedIterator {
	List<Sukurtsala> list;
	int position;
	public  SukurtsalIterator(List<Sukurtsala> lista) {
		this.list=lista;
	}

	@Override
	public boolean hasNext() {
		return this.position<this.list.size();
	}

	@Override
	public Sukurtsala next() {
		Sukurtsala suk=list.get(position);
		position++;
		return suk;
	}

	@Override
	public Sukurtsala previous() {
		Sukurtsala suk=list.get(position);
		position--;
		return suk;
	}

	@Override
	public boolean hasPrevious() {
		
		return this.position>=0;
	}

	@Override
	public void goFirst() {
		this.position=0;

	}

	@Override
	public void goLast() {
		this.position=this.list.size()-1;

	}

}
