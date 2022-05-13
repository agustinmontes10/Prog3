package TPGrafos;

import java.util.Iterator;

public class Main {

	public static void main(String[] args) {
		GrafoDirigido grafo = new GrafoDirigido();

		
		grafo.agregarVertice(1);
		
		grafo.agregarVertice(3);
		grafo.agregarArco(1, 3, null);
		//System.out.println(grafo.vertices);
	
		Iterator it = grafo.obtenerAdyacentes(1);
		
		while(it.hasNext()) {
			System.out.println(" - " + it.next());
		}
		
		
	}

}
