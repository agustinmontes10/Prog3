package TPGrafos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class GrafoDirigido<T> implements Grafo<T> {


	HashMap<Integer, ArrayList<Integer>> vertices = new HashMap<>();
	ArrayList<Arco> arcos = new ArrayList<>();
	ArrayList<Integer> visitados = new ArrayList<>();
	ArrayList<Integer> fila = new ArrayList<>();
	private int tiempo = 0;
	
	
	@Override
	public void agregarVertice(int verticeId) {
		ArrayList<Integer> adyacentes = new ArrayList<>();
		vertices.put(verticeId, adyacentes);
		System.out.println(vertices);
	}

	@Override
	public void borrarVertice(int verticeId) {
		vertices.remove(verticeId);
			this.borrarArcos(verticeId);
	}

	@Override
	public void agregarArco(int verticeId1, int verticeId2, T etiqueta) {
		vertices.get(verticeId1).add(verticeId2);
		Arco<T> arco = new Arco<T>(verticeId1, verticeId2, etiqueta);
		arcos.add(arco);
		
	}

	@Override
	public void borrarArco(int verticeId1, int verticeId2) {
		for (Arco arco : arcos) {
			if(arco.getVerticeOrigen() == verticeId1 && arco.getVerticeDestino() == verticeId2) {
				arcos.remove(arco);
			}
		}
	}
	
	public void borrarArcos(int verticeId1) {
		for (Arco arco : arcos) {
			if(arco.getVerticeOrigen() == verticeId1) {
				arcos.remove(arco);
			}
		}
	}

	@Override
	public boolean contieneVertice(int verticeId) {
		return vertices.containsKey(verticeId);
	}

	@Override
	public boolean existeArco(int verticeId1, int verticeId2) {
		for (Arco arco : arcos) {
			if(arco.getVerticeOrigen() == verticeId1 && arco.getVerticeDestino() == verticeId2) {
				return true;
			}
		}
		return false;
	}

	@Override
	public Arco<T> obtenerArco(int verticeId1, int verticeId2) {
		for (Arco arco : arcos) {
			if(arco.getVerticeOrigen() == verticeId1 && arco.getVerticeDestino() == verticeId2) {
				return arco;
			}
		}
		return null;
	}

	@Override
	public int cantidadVertices() {
		return vertices.size();
	}

	@Override
	public int cantidadArcos() {
		return arcos.size();
	}

	@Override
	public Iterator<Integer> obtenerVertices() {
		Iterator it = vertices.keySet().iterator();
		return it;
	}

	@Override
	public Iterator<Integer> obtenerAdyacentes(int verticeId) {
		Iterator it = vertices.get(verticeId).iterator();
		return it;
	}

	@Override
	public Iterator<Arco<T>> obtenerArcos() {
		Iterator it = arcos.iterator();
		return it;
	}

	@Override
	public Iterator<Arco<T>> obtenerArcos(int verticeId) {
		ArrayList<Arco> aux = new ArrayList<>();
		for (Arco arco : aux) {
			if(arco.getVerticeOrigen() == verticeId) {
				aux.add(arco);
			}
		}
		Iterator it = aux.iterator();
		return it;
	}

	
	public void dfs() {
		
		for (Integer v : vertices.keySet()) {
			if(!visitados.contains(v)) {
				dfs_visit(v);
			}
		}
	}
	
	public void dfs_visit(Integer v) {
		ArrayList<Integer> visitando = new ArrayList<>();
		visitando.add(v);
		tiempo++;
		System.out.println("El tiempo de entrada de " + v + " es " + tiempo);
		for (Integer vAdyacente : vertices.get(v)) {
			if(!visitados.contains(vAdyacente)) {
				dfs_visit(vAdyacente);
			} 
			else if(visitando.contains(vAdyacente)) {
				System.out.println("HAY CICLO :D");
			}
			
		}
		visitados.add(v);
		visitando.remove(v);
		tiempo++;
		System.out.println("El tiempo de salida de " + v + " es " + tiempo);
	}
	
	public void bfs() {
		visitados.clear();
		fila.clear();
		for (Integer v : vertices.keySet()) {
			if(!visitados.contains(v)) {
				bfs_visit(v);
			}	
		}
	}
	
	public void bfs_visit(Integer v) {
		visitados.add(v);
		fila.add(v);
		if(!fila.isEmpty()) {
			Integer x = fila.get(0);
			for (Integer vAdyacente: vertices.get(x)) {
				if(!visitados.contains(vAdyacente)) {
					visitados.add(vAdyacente);
					fila.add(vAdyacente);
				}
			}
		}
		
		
		
	}
	
	
}
