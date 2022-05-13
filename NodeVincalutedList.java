
public class NodeVincalutedList<T> {
	
	private T info;
	private NodeVincalutedList<T> next;

	public NodeVincalutedList() {
		this.info = null;
		this.next = null;
	}
	
	public NodeVincalutedList(T info, NodeVincalutedList<T> next) {
		this.setInfo(info);
		this.setNext(next);
	}
	
	public NodeVincalutedList<T> getNext() {
		return next;
	}

	public void setNext(NodeVincalutedList<T> next) {
		this.next = next;
	}

	public T getInfo() {
		return info;
	}

	public void setInfo(T info) {
		this.info = info;
	}
	
}
