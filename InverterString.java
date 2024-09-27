import java.util.Scanner;

public class InverterString {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite a string que deseja inverter: ");
        String entrada = scanner.nextLine();

        String stringInvertida = inverterString(entrada);

        System.out.println("String invertida: " + stringInvertida);

        scanner.close();
    }

    public static String inverterString(String str) {
        char[] caracteres = str.toCharArray();
        String resultado = "";

        for (int i = caracteres.length - 1; i >= 0; i--) {
            resultado += caracteres[i];
        }

        return resultado;
    }
}
