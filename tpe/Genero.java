package tpe;

import java.util.ArrayList;

public class Genero implements Comparable<Genero>{

	private String nombre;
	private ArrayList<Libro> libros;
	
	public Genero(String nombre) {
		this.nombre = nombre;
		libros = new ArrayList<>();
	}

	public ArrayList<Libro> getLibros() {
		return new ArrayList<>(libros);
	}

	public void addLibro(Libro libro) {
		this.libros.add(libro);
	}

	public String getNombre() {
		return nombre;
	}
	
	@Override
	public boolean equals(Object obj) {
		Genero gen = (Genero) obj;
		return this.getNombre().equals(gen.getNombre()); 
	}

	@Override
	public int compareTo(Genero arg0) {
		// TODO Auto-generated method stub
		return nombre.compareTo(arg0.getNombre());
	}
	
}
