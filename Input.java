import java.util.Scanner;

public class Input {
  /**
   * Solicita la entrada de una cadena de texto,
   * desde consola. Si el valor son solo espacios
   * en blanco o no existe, se solicitara nuevamente.
   *
   * @param message el mensaje a mostrar
   * @return la cadena de texto
   */
  public static String nextLine(String message) {
    String value;
    Scanner sc = new Scanner(System.in);

    while (true) {
      try {
        System.out.print(message);
        value = sc.nextLine();
        value = value.trim();

        if (!value.isEmpty()) {
          break;
        }
      } catch(Exception e) {}
    }

    return value;
  }

  /**
   * Solicita la entrada de un número entero,
   * desde consola. Si el valor no es valido,
   * se solicitara nuevamente.
   *
   * @param message el mensaje a mostrar
   * @return el numero entero
   */
  public static int nextInt(String message) {
    int value = 0;

    while (true) {
      try {
        value = Integer.parseInt(nextLine(message));
        break;
      } catch(Exception e) {
	      System.out.println("\n Ingrese numero entero.\n");
      }
    }
    return value;
  }

  /**
   * Solicita una confirmacion desde consola.
   * Si el valor no es valido se solicitara nuevamente.
   *
   * @param question la pregunta a responder
   * @param p la respuesta positiva
   * @param n la respuesta negativa
   * @return la respuesta
   */
  public static boolean confirm(String question, String p, String n) {
    String value;
    boolean response = false;

    while (true) {
      value = nextLine(question);

      if (p.equals(value)) {
        response = true;
        break;
      } else if (n.equals(value)) {
        response = false;
        break;
      }
    }

    return response;
  }
  
}
