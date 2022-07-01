package tpe;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Lector {
	public static final String SEPARADOR = ",";
	
	
	//public static void main(String[] args) {
	public static ArrayList<Libro> getLibros(){
		ArrayList<Libro> libros = new ArrayList<>();
		BufferedReader bufferLectura = null;
	 try {
	  // Abrir el .csv en buffer de lectura
	  bufferLectura = new BufferedReader(new FileReader("dataset4.csv"));
	  // Leer una linea del archivo
	  String linea = bufferLectura.readLine();
	  
	  while (linea != null) {
	   // Sepapar la linea leída con el separador definido previamente
	   String[] campos = linea.split(SEPARADOR); 
	   
	   	  
	   String titulo = campos[0];
	   String autor = campos[1];
	   String paginas = campos[2];
	   int cantPaginas = 0;
	   String[] generos = campos[3].split(" ");
	   
	   
	   
	   if(!paginas.equals("Paginas")) {   //evita imprimir la pagina de las cabeceras
		 cantPaginas = Integer.parseInt(paginas); 
	  	  Libro l1 = new Libro(titulo, autor, cantPaginas);
	  	  for(String g: generos) {
			   l1.addGeneros(new Genero(g));
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
	 return libros;
	}
	
	public static void main(String[] args) {
		Lector.getLibros();
	}
	
	
}