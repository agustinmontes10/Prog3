package tpe;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class Biblioteca {

	//private Lector lector;
	private ArrayList<Libro> libros;
	private ArrayList<ArrayList<Libro>> busqueda;
	private ArrayList<Genero> generos;
	private int contador;
	
	public Biblioteca() {
		generos = new ArrayList<>();
		//lector = new Lector();
		busqueda = new ArrayList<>();
		libros = new ArrayList<>();
		contador = 0;
	}
	
	public void getLibros(){
		//ArrayList<Libro> libros = new ArrayList<>();
		String separador = ",";
		BufferedReader bufferLectura = null;
	 try {
	  // Abrir el .csv en buffer de lectura
	  bufferLectura = new BufferedReader(new FileReader("dataset4.csv"));
	  // Leer una linea del archivo
	  String linea = bufferLectura.readLine();
	  
	  while (linea != null) {
	   // Sepapar la linea leída con el separador definido previamente
	   String[] campos = linea.split(separador); 
	   
	   	  
	   String titulo = campos[0];
	   String autor = campos[1];
	   String paginas = campos[2];
	   int cantPaginas = 0;
	   String[] generos = campos[3].split(" ");
	   
	   
	   
	   if(!paginas.equals("Paginas")) {   //evita imprimir la pagina de las cabeceras
		 cantPaginas = Integer.parseInt(paginas); 
	  	  Libro l1 = new Libro(titulo, autor, cantPaginas);
	  	  for(String g: generos) {
	  		  Genero genero = new Genero(g);
			   l1.addGeneros(genero);
			   this.addGenero(genero);//LO TIENE QUE ORDEAR AHI ADENTRO
			   genero.addLibro(l1);//AGREGA LIBRO A GENERO
			   
		   }
	  	  libros.add(l1);
	   }
	   
	   // Volver a leer otra línea del fichero
	   linea = bufferLectura.readLine();
	   
	  }
	  
	 } 
	 catch (IOException e) {
	  e.printStackTrace();
	 }
	 finally {
	  // Cierro el buffer de lectura
	  if (bufferLectura != null) {
	   try {
	    bufferLectura.close();
	   } 
	   catch (IOException e) {
	    e.printStackTrace();
	   }
	  }
	 }
	 
	}
	
	public void addGenero(Genero generoNuevo) {
		int izq = 0;
		int medio;
		int der = generos.size()-1;
		boolean existe = false;
		while(!existe && izq <= der) {
			medio = (izq + der)/2;
			if (generoNuevo.compareTo(generos.get(medio)) < 0) {
				der = medio -1;
			}
			else if (generoNuevo.compareTo(generos.get(medio)) > 0) {
				izq = medio+1;
			}
			else existe = true;
		}
		
		if (!existe) {
			boolean agregado = false;
			
				if (generoNuevo.compareTo(generos.get(generos.size()-1)) > 0) {
					generos.add(izq, generoNuevo);
					agregado = true;
				}
					
			
				if (generoNuevo.compareTo(generos.get(0)) < 0 && !agregado) {
					generos.add(0,generoNuevo);
					agregado = true;
				}
					
			
				if (!agregado)
					if (izq<generos.size())
						generos.add(izq, generoNuevo);
					else
						generos.add(der, generoNuevo);
			
		}
	}
	
	private Genero getGenero(Genero genero, int izq, int der) {
		if (izq > der) {
			return null;
		} else {
			int mitad = (izq + der)/2;
			if (genero.compareTo(this.generos.get(mitad)) > 0) {
				return getGenero(genero, mitad +1, der);
			} else if (genero.compareTo(this.generos.get(mitad)) < 0) {
				return getGenero(genero, izq, mitad-1);
			} else 
				return this.generos.get(mitad);
		}
	}
	
	public boolean contieneGenero(Genero gen) { //se evalua si la biblioteca ya tiene el genero creado
		return generos.contains(gen);	
	}
	
	public int getContador() {
		return contador;
	}
	
	
	public ArrayList<Genero> getGeneros(){
		return new ArrayList<>(generos);
	}
	
	private ArrayList<Libro> getLibrosPorGenero(Genero genero){
		Genero g = this.getGenero(genero, 0, generos.size()-1);
		if(g != null) return new ArrayList<Libro> (g.getLibros());
		else return null;
	}
	
	
	public ArrayList<ArrayList<Libro>> getBusqueda(){ //?
		return new ArrayList<>(busqueda);
	}

	public ArrayList<Libro> getLibros(Genero genero){//?
		int i = generos.indexOf(genero);
		return getBusqueda().get(i);
	}

	public void crearBusqueda() { //
		this.setGeneros();
		for (Genero g: generos) { //por cada genero, se le agrega en su posicion los libros 
			busqueda.add(generos.indexOf(g), getLibrosPorGenero(g));
		}
		
	}
	
	private void setGeneros() { //NO SE USA
		for (Libro l : libros) {
			contador++;
			for(Genero g: l.getGeneros()) { //por cada genero del libro
				contador++;
				if(this.contieneGenero(g)) {
					int i = getGeneros().indexOf(g);
					getGeneros().get(i).addLibro(l);
				}
				else {
					Genero g1 = new Genero(g.getNombre());
					this.addGenero(g1);
					g1.addLibro(l);
				}
			}
		}
	}
	
	public void addLibro() {//SE USA DIRECTAMENTE EN GETLIBROS
		//libros = lector.getLibros();
	}
		
	
}