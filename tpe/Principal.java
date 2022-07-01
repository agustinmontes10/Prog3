package tpe;

public class Principal {

	public static void main(String[] args) {
		Biblioteca b1 = new Biblioteca();
		Timer t1 = new Timer();
		
		t1.start();
		b1.addLibro();
		b1.crearBusqueda();
		Genero g1 = new Genero("cine");		
		Escritor e1 = new Escritor();
		e1.escribirArchivo(b1.getLibros(g1));
		System.out.println("Tiempo con dataset4: " + t1.stop());
		System.out.println("Cantidad de nodos visitados con dataset4: " + b1.getContador());
		
		
	}

}
