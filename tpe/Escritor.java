package tpe;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Escritor {

	public static void escribirArchivo(ArrayList<Libro> libros) {
		BufferedWriter bw = null;
		try {
			File file = new File("C:\\Users\\guido\\eclipse-workspace\\Progr3/salida.csv");
			if (!file.exists()) {
				file.createNewFile();
			}

			FileWriter fw = new FileWriter(file);
			bw = new BufferedWriter(fw);

			
			for (Libro l : libros) {
				String linea = l.getTitulo();
				bw.write(linea);
				bw.newLine();
			}
			
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			try {
				if (bw != null)
					bw.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}
}
