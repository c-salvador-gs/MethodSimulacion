public class PseudoAleatorios {
	// Generador de Numeros Random; "Cuadrados Medios".
	public static double[] midsquare(int semilla, int cantNum) {
		int semillas; //semillas generadas
		int resultado; //Result. de la (semilla)^2.
		int numEnmedio; //Numeros de Enmedio
		String format = "| %-4d | %-8d | %-9d | %-18d | %-6s |%n";

		// Cabecera de la tabla
		System.out.format("+------+----------+-----------+--------------------+--------+%n");
		System.out.format("| Fila | semillas | Resultado | Numeros de Enmedio | Random |%n");
		System.out.format("+------+----------+-----------+--------------------+--------+%n");

		double[] mtrizR = new double[cantNum];
		try {
			for (int i = 0; i < cantNum; i++) {
				resultado = (int)Math.pow(semilla, 2);
				numEnmedio = Otras.getMiddleNumber(resultado);
				if(semilla == numEnmedio) {
					throw new Exception(" (Error: Los numeros se repitieron) \n     Intente otra semilla\n"); 
				}
				String numRandom = "0." + numEnmedio;
				mtrizR[i] = Double.parseDouble(numRandom);
				semillas = semilla;
				semilla = numEnmedio;

				System.out.format(format,(i+1),semillas,resultado,numEnmedio,mtrizR[i],"%n");
			}
			System.out.format("+------+----------+-----------+--------------------+--------+%n");
		} catch (Exception e) { 
			System.out.format("+------+----------+-----------+--------------------+--------+%n");
			System.out.println(e.getMessage()); 
		}
		
		return mtrizR;
	}
}