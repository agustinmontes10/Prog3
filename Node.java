
public class Node {
	
	private Integer value;
	private Node nodeIzq;
	private Node nodeDer; 
	
	public Node(Integer value) {
		this.value = value;
		nodeIzq = null;
		nodeDer = null;
	}
	
	public void insert (Integer value) {
		
		if(value > this.value) {
			if(nodeDer != null) {
				nodeDer.insert(value);
			}
				else {
				nodeDer = new Node(value);
			}
		}
		else if(value < this.value) {
			if(nodeIzq != null) {
				nodeIzq.insert(value);
			}
			else {
				nodeIzq = new Node(value);
			}
		}
		
		else {
			System.out.println("/ Nodo ya existente");
		}
		
		
		
	}
	
	public Integer getValue() {
		return this.value;
	}
	
	public boolean hasElem(Integer valueBuscado) {
		
		if(this.value == valueBuscado) {
			return true;
		}
		
		else if(valueBuscado > this.value && nodeDer.getValue() != null)
			return nodeDer.hasElem(valueBuscado);
		
		else if(valueBuscado < this.value && nodeIzq.getValue() != null)
			return nodeIzq.hasElem(valueBuscado);
		

		return false;
	}
	
	public boolean isEmpty() {
		return this.nodeIzq.getValue() == null && this.nodeDer.getValue() == null;
	}
	
	public String printPreOrder() {
		String toString = "'" + this.getValue() + "' -> ";
		
		
		if(nodeIzq != null)
			toString += nodeIzq.printPreOrder();
		
		if(nodeDer != null)
			toString += nodeDer.printPreOrder();
	
		return toString;
	}
	
	public String printPosOrder() {
		
		String toString = "";
		
		if(nodeIzq != null)
			toString += nodeIzq.printPosOrder();
		
		if(nodeDer != null)
			toString += nodeDer.printPosOrder();
		
		toString += "'" + this.getValue() + "' - ";
		
		
		return toString;
	}
	
	public String printOrder() {
		
		String toString = "";
		
		if(this.getValue() != null) {
			if(nodeIzq != null)
				toString += nodeIzq.printOrder();
		
			toString += "'" + this.getValue() + "' - ";
			
			if(nodeDer != null)
				toString += nodeDer.printOrder();
		}
		
		else
			return toString;
		
		
		
		return toString;
		
	}
	
	public Node getMaxElem() {
		Node max;
		
		if(nodeDer != null)
			max = nodeDer.getMaxElem();
		
		else
			max = this;
		
		return max;
	}
	
	public Node getMinElem() {
		Node min;
		
		if(nodeIzq != null)
			min = nodeIzq.getMinElem();
		else
			min = this;
		
		return min;
		
	}
	
	
	public boolean deleteNode(Integer valueBorrar, Node padre) {
		
		if(this.value == valueBorrar) {		//SI ENCUENTRO EL NODO A BORRAR
			
			if(nodeIzq == null && nodeDer != null) {	//SI TIENE UN UN SOLO HIJO (EL DERECHO)

				if(this.value > padre.getValue()) {
					padre.setNodeDer(nodeDer);
					return true;
				}
				else if(this.value < padre.getValue()) {
					padre.setNodeIzq(nodeDer);
					return true;
				}
				
			}
			
			if(nodeDer == null && nodeIzq != null) {	//SI TIENE UN UN SOLO HIJO (EL IZQUIERDO)
				
				if(this.value > padre.getValue()) {
					padre.setNodeDer(nodeIzq);
					return true;
				}
				else if(this.value < padre.getValue()) {
					padre.setNodeIzq(nodeIzq);
					return true;
				}
				
			}
			
			if(nodeIzq != null && nodeDer != null) {	//SI TIENE DOS HIJOS
				//buscar el t.getNMI y remplazar
				Node NodoMasIzq = nodeDer.getMinElem();
				this.setValue(NodoMasIzq.getValue());
				NodoMasIzq.setValue(null);
				
				return true;
			}
			
			if(nodeIzq == null && nodeDer == null) {	//SI ES UNA HOJA
				this.setValue(null);
				return true;
			}
			
		}
		
		if(valueBorrar < this.value && nodeIzq != null) {		//SI EL NODO THIS ES MENOR
			nodeIzq.deleteNode(valueBorrar, this);
		}
		
		if(valueBorrar > this.value && nodeDer != null) {		//SI EL NODO THIS ES MAYOR
			nodeDer.deleteNode(valueBorrar, this);
		}
			

		return false;
		
	}
	
	
	
	public Node getNodeIzq() {
		return nodeIzq;
	}

	public void setNodeIzq(Node nodeIzq) {
		this.nodeIzq = nodeIzq;
	}

	public Node getNodeDer() {
		return nodeDer;
	}

	public void setNodeDer(Node nodeDer) {
		this.nodeDer = nodeDer;
	}

	public void setValue(Integer value) {
		this.value = value;
	}
	
	
	public static void main (String [] args) {
		
		Node raiz = new Node(10);
		
		raiz.insert(15);						//10
		raiz.insert(6);				//6						//15
		raiz.insert(14);	//2						//14			//17
		raiz.insert(2);					//5
		raiz.insert(5);
		raiz.insert(17);
		
		System.out.println(raiz.hasElem(2));
		System.out.println(raiz.printPreOrder());
		System.out.println(raiz.printPosOrder());
		System.out.println(raiz.printOrder());
		System.out.println(raiz.getMaxElem().getValue());
		System.out.println(raiz.getMinElem().getValue());
		raiz.deleteNode(10, raiz);
		System.out.println(raiz.printOrder());
	}
	
}
