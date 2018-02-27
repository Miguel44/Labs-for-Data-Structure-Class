package positionInterfaces;

import java.util.Iterator;

public interface PositionListIteratorMaker<E> {
	Iterator<E> makeIterator(PositionList<E> pl); 

}
