public class Uniformidad {
	// Metodo de Uniformidad; "Frecuencias".
	public static void frecuencies(double[] mtrizR) throws Exception {
		int tamNr = Otras.sacarTamanioRandom(mtrizR);

		int cantIntervalos = (int)Math.sqrt(tamNr); //Cantidad de Intervalos = n.
		int fe;
		try {fe = tamNr/cantIntervalos;}
		catch (ArithmeticException e) {
			throw new Exception("Valor no divisible entre cero");
		}
		double[] intervalos = new double[cantIntervalos+1];
		// Intervalos se guardan en subInter[].
		for (int i=0; i<=cantIntervalos; i++) {
			intervalos[i] = Otras.redondearDecimales((1.0/cantIntervalos)*(i), 1);
		}

		// Frecuencia Observada.
		int[] fo = new int[cantIntervalos+1];
		// for para recorrer Intervalos.
		for (int i=0; i<intervalos.length-1; i++) {
			// for para recorrer numeros random.
			for (int j=0; j<tamNr; j++) {
				if(mtrizR[j] > intervalos[i] && mtrizR[j] < intervalos[i+1]){
					fo[(i+1)]++;
				}
			}
		}

		// Sacar X0Cuadrada
		double[] x0Cuadrada = new double[cantIntervalos+1];
		double result = 0;
		for (int i=1; i<=cantIntervalos; i++) {
			x0Cuadrada[i] =  Otras.redondearDecimales( (Math.pow(fe - fo[i], 2))/fe ,2);
			result = result + x0Cuadrada[i];
		}
		// XAlfa Cuadrada
		//Alfa = 5%  es decir 5-1, V = 4 enlas tablas de distribucion ji cuadrada.
		double xAlfaCuadrada = 9.49;
		String format = "| %-10s | %-3d | %-3d | %-10f |%n";
		// Cabecera de la tabla.
		System.out.format("+------------+-----+-----+------------+%n");
		System.out.format("| Intervalos | F.E | F.O | X0Cuadrada |%n");
		System.out.format("+------------+-----+-----+------------+%n");
		// Imprimir Intervalos | Frecuencia Esperada | Frecuencia Observada | X0Cuadrada.
		for (int i= 1; i<=cantIntervalos; i++) {
			System.out.format(format,intervalos[i-1]+"-"+intervalos[i],fe,fo[i],x0Cuadrada[i],"%n");
		}
		System.out.format("+------------+-----+-----+------------+%n");
		System.out.println("	Resultado; X0Cuadrada = " + result);
		if (result < xAlfaCuadrada) {
			System.out.println(" Como x0Cuadrada " + result + " Es menor que xAlfaCuadrada " + xAlfaCuadrada);
			System.out.println("  Los numeros pseudoaleatorios si son Uniformes");
		}else{
			System.out.println("Los numeros pseudoaleatorios no son Uniformes");
		}
	}
}
