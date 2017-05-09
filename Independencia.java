public class Independencia {
	public static void runUpDown(double[] mtrizR) {
		int tamNr = Otras.sacarTamanioRandom(mtrizR);
		
		int[] sucesionBinaria = new int[tamNr];
		for(int i=0; i<tamNr; i++) {
			if(mtrizR[i] <= 0.50) {
				sucesionBinaria[i] = 0;
			}
			else {
				sucesionBinaria[i] = 1;
			}
		}

		System.out.print("\nSucesion Binaria: ");
		for (int i=0; i<tamNr; i++) {
			System.out.print(sucesionBinaria[i]+" ");
		}
		
		//Sacar Frecuencia Esperada (F.E).
		double[] fe = new double[5];
			for (int i=0; i<5; i++) {
				fe[i] = Otras.redondearDecimales( ( tamNr-(i+1) + 3) / (Math.pow(2, ((i+1)+1)) ) ,3);
			}
		
		//Frecuencia Observada..
		System.out.println("\n");
		int[] fo = new int[5];
		int indice = 0;
		
		int actual, siguiente;
    	int ultimo = sucesionBinaria[sucesionBinaria.length - 1];
    	int penultimo = sucesionBinaria[sucesionBinaria.length - 2];

    	for (int i = 0; i < sucesionBinaria.length-1; i++) {
    		actual = sucesionBinaria[i];
      		siguiente = sucesionBinaria[i+1];

      		if (actual == siguiente) {
        		indice++;
      		} else {
	        	fo[indice]++;
	        	indice = 0;
      		}
		}

		if (ultimo != penultimo) {
  			fo[0]++;
		}

		//Formula ji-cuadrada.
		double[] jiCuadrada = new double[5];
		for (int i=0; i<5; i++) {
			jiCuadrada[i] = Otras.redondearDecimales(Math.pow((fe[i]-fo[i]), 2)/fe[i] , 3);
		}

		double suma = 0;
		for (int i=0; i<5; i++) {
			suma += jiCuadrada[i];
		}

		//Imprimir tabla
		String format = "| %-10d | %-8f | %-3d | %-11f |%n";
		System.out.format("+------------+----------+-----+-------------+%n");
		System.out.format("| Intervalos |    F.E   | F.O | ji-cuadrada |%n");
		System.out.format("+------------+----------+-----+-------------+%n");

		for (int i=0; i<5; i++) {
			System.out.format(format,(i+1),fe[i],fo[i],jiCuadrada[i],"%n");
		}
		System.out.format("+------------+----------+-----+-------------+%n");

		if (suma < 3.84) {
			System.out.println("Se hacepa la hipotesis, los numeros si son independientes");
		}else{
			System.out.println("Se rechaza la hipotesis, los numeros no son independientes");
		}
	}
}