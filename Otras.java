public class Otras {
	// Método para sacar valores de enmedio.
	public static int getMiddleNumber(int number) throws Exception {
		String numberStr = number + "";
		char[] numbers = numberStr.toCharArray();//Método que combierte la matriz en matriz de caracteres.
		String value = "";

		//Verificar que el numero no tenga menos de 4 cifras.
		if (numbers.length < 4) {
			throw new Exception("\nSemilla incorrecta (tiene menos de 4 dijitos)\n o (se redujo a ceros).");
		}
		/*Verificar si la cantidad de numeros tienen menos de 8 cifras
		  Para que se se deje 1 cifra y se tomen las 4 siguientes.*/
		if (numbers.length < 8) {
			if (numbers.length == 4) {
				for (int i = 0; i < 4; i++) {
					value += numbers[i];
				}
			} else {
				for (int i = 1; i <= 4 ;i++ ) {
					value += numbers[i];
				}
			}
			/*Verificar si la cantidad de numeros tienen mas de 8 cifras
		  Para que se se dejen 2 cifras y se tomen las 4 siguientes.*/
		} else if (numbers.length >= 8) {
			for (int i = 2; i <= 5; i++) {
				value += numbers[i];
			}
		}

		return (int)Long.parseLong(value);
	}

	public static double redondearDecimales(double value, int places) {
	    if (places < 0) throw new IllegalArgumentException();

	    long factor = (long) Math.pow(10, places);
	    value = value * factor;
	    long tmp = Math.round(value);
	    return (double) tmp / factor;
	}

	public static int sacarTamanioRandom(double[] mtrizR) {
		int tamNr = 0;
		//Sacar tamaño real la matriz.
		for (int i=0; i<mtrizR.length; i++) {
			if (mtrizR[i] == 0.0) {
				break;
			}
			tamNr++; // Muestra de numeros aleaorios(cantidad).
		}
		return tamNr;
	}
}