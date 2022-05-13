
public class MergeSort {

	private int[ ] numbers;
	private int[ ] helper;
	private int size;
	
		public MergeSort(int[ ] values) {
			this.numbers = values;
			size = values.length;
			this.helper = new int[size];
			mergeSort(0, size - 1);
		}
		
		private void mergeSort(int low, int high) {
			if (low < high) {
				int middle = (low + high) / 2;
	
				mergeSort(low, middle);
				mergeSort(middle + 1, high);
				merge(low, middle, high);
			}
		}

		
		public void merge(int low, int middle, int high) {
			// copiar ambas partes al array helper
			for (int i = low; i <= high; i++) {
				helper[i] = numbers[i];
			}
			
			int i = low;
			int j = middle + 1;
			int k = low;
			
			// copiar de manera ordenada al array original los valores de la
			// mitad izquierda o de la derecha
			while (i <= middle && j <= high) {
				if (helper[ i ] <= helper[ j ]) {
				numbers[ k ] = helper[ i ];
				i++;
				}
					else {
				numbers[ k ] = helper[ j ];
				j++;
				}
				k++;
			}
			
			// si quedaron elementos copiarlos al array original
			while (i <= middle) {
				numbers[ k ] = helper[ i ];
				k++;
				i++;
			}
			while (j <= high) {
				numbers[ k ] = helper[ j ];
				k++;
				j++;
			}
			
		}
		
		public void imprimir() {
			for(int i = 0; i < numbers.length; i++) {
				System.out.println(numbers[i]);
			}
			
		}
		
		public static void main (String [] args) {
			int[] arr = new int[10];
			
			arr[0] = 5;
			arr[1] = 32;
			arr[2] = 8;
			arr[3] = 12;
			arr[4] = 2;
			arr[5] = 14;
			arr[6] = 9;
			arr[7] = 54;
			arr[8] = 17;
			arr[9] = 10;
			
			MergeSort e = new MergeSort(arr);
			e.imprimir();
			
		}
		
	}


