
public class Pila<T> {

	private MySimpleLinkedList<T> list;
	
	public Pila(MySimpleLinkedList<T> list) {
		this.list = list;
	}

	public void push(T o) {
		list.insertFront(o);
	}
	
	public T pop() {
		return list.extractFront();
	}
	
	
	
}
