import java.util.Iterator;

public class MySimpleLinkedList<T> implements Iterable<NodeVincalutedList> {

	private NodeVincalutedList<T> first;
	private int size;
	
	public MySimpleLinkedList() {
		this.first = null;
		this.size = 0;
	}
	
	public void insertFront(T info) {
		NodeVincalutedList<T> tmp = new NodeVincalutedList<T>(info,null);
		tmp.setNext(this.first);
		this.first = tmp;
		size++;
	}
	
	public T extractFront() {
		NodeVincalutedList<T> aux = this.first;
		this.first = first.getNext();
		size--;
		return (T) aux;
	}

	public boolean isEmpty() {
		return first == null;
	}
	
	public T get(int index) {
		NodeVincalutedList aux = first;
		int i = 0;
		while(i < index) {
			i++;
			aux = aux.getNext();
		}
		return (T) aux.getInfo();
	}
	
	public int size() {
		return size;
	}
	
	public int indexOf(NodeVincalutedList node) {
		NodeVincalutedList aux = first;
		int i = 0;
		while(first.getNext() != null) { 
			if(aux == node) {
				return i;
			}
			aux = aux.getNext();
			i++;
		}
		return -1;
	}
	
	@Override
	public String toString() {
		NodeVincalutedList aux = first;
		String toString = "";
		while(aux != null) {
			toString += aux.getInfo() + ", ";
			aux = aux.getNext();
		}
		return toString;
	}

	@Override
	public Iterator<NodeVincalutedList> iterator() {
		Iterator it = new IteradorLinkedList(first);
		return it;
	}
	
}
