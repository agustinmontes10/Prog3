import java.util.ArrayList;

public class OrderBurbuja {

	private ArrayList arreglo = new ArrayList<Integer>();
	
	public void addElemento (int e) {
		arreglo.add(e);
	}
	
	public void bubbleSortAdapt(int[] arr) {
		boolean swapped = true;
		int j = 0;
		int tmp;
		
		while (swapped) {
			swapped = false;
			j++;
			
			for (int i=0; i<arr.length - j; i++) {
				if (arr[i] > arr[i + 1]) {
					tmp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = tmp;
					swapped = true;
				}
			}
		}
	}
	
	public void imprimirArreglo (int [] arr) {
		for(int i = 0; i < arr.length; i++) {
			System.out.println(arr[i] + " - ");
		}
	}

	public static void main (String [] args) {
		OrderBurbuja e = new OrderBurbuja();
		
		int[] arr = new int[10];
		
		arr[0] = 5;
		arr[1] = 32;
		arr[2] = 8;
		arr[3] = 12;
		arr[4] = 2;
		arr[5] = 14;
		arr[6] = 9;
		
		e.bubbleSortAdapt(arr);
		e.imprimirArreglo(arr);
	}
	
	
}


