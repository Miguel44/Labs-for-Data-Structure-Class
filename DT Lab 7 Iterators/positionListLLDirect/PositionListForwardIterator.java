package positionListLLDirect;

import java.util.Iterator;

import positionInterfaces.PositionList;
import positionInterfaces.PositionListIteratorMaker;

public class PositionListForwardIterator<E> implements  PositionListIteratorMaker<E>  {

	public Iterator<E> makeIterator(PositionList<E> pl) {
		return new PositionListElementsIterator<E>(pl);
	}

}
