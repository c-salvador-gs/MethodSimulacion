public class AppMethod {
	/*******************************************************************
	***						Metodo Principal						 ***
	********************************************************************/
	public static void main(String[] args) {
		System.out.println("\n===Metodo del Cuadrado Medio===");
		int semilla = Input.nextInt("Inserte semilla (4 digitos recomendados): ");
		int cantNum = Input.nextInt("Cuantos numeros desea generar): ");
		double mtrizR[] = PseudoAleatorios.midsquare(semilla,cantNum);

		int var_opciones;
		boolean var_estado;
		
		do {
			var_estado = true;
			System.out.println("\n***MENU DE OPCIONES***");
			System.out.println("OPCION 1");
			System.out.println("1.-Prueva de uniformidad");

			System.out.println("OPCION 2");
			System.out.println("2.-Prueva de independencia");

			System.out.println("OPCION 3");
			System.out.println("3.-Salir");

			var_opciones = Input.nextInt("\n¿Que prueba deseas elegir?: ");

			switch(var_opciones) {
				case(1):{
					System.out.println("");
					System.out.println("\n===Metodo de Uniformidad===");
					try {Uniformidad.frecuencies(mtrizR);}
					catch (Exception e) {
					System.out.println(e.getMessage());
					}
					break;
				}
				case(2):{
					System.out.println("");
					System.out.println("");
					System.out.println("\n===Metodo de Independencia===");
					Independencia.runUpDown(mtrizR);
					break;
				}
				case(3):{
					var_estado = false;
					System.out.println(" As salido del programa ");
				}
			}//fin switch
		} while(var_estado); // fin do while
	}
}
