import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Informe um número: ");
        int numero = scanner.nextInt();
        scanner.close();
        if (pertenceFibonacci(numero)) {
            System.out.println(numero + " pertence à sequência de Fibonacci.");
        } else {
            System.out.println(numero + " não pertence à sequência de Fibonacci.");
        }
    }
    public static boolean pertenceFibonacci(int n) {
        int a = 0, b = 1;
        if (n == a || n == b) {
            return true;
        }
        int c;
        while (b < n) {
            c = a + b;
            a = b;
            b = c;
        }
        return n == b;
    }
}

