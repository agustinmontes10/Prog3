import java.util.Iterator;

public class IteradorLinkedList implements Iterator<NodeVincalutedList>{

	private NodeVincalutedList cursor;
	
	public <T> IteradorLinkedList(NodeVincalutedList<T> cursor) {
		this.cursor = cursor;
		
	}
	
	@Override
	public boolean hasNext() {
		if(cursor.getNext() != null) {
			return true;
		}
		return false;
		
	}

	@Override
	public NodeVincalutedList next() {
		if(hasNext()) {
			cursor = cursor.getNext();
		}
		
		return cursor;
	}

}
