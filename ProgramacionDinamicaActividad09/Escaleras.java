import java.util.Arrays;
import java.util.Scanner;

public class Escaleras {

    public static void print(Object msg) {
        System.out.print(msg);
    }

    public static void println(Object msg) {
        System.out.println(msg);
    }

    public static long[] calcularEscaleras(int n) {
        if (n == 0) {
            return new long[]{1};
        }

        long[] dp = new long[n + 1];

        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp;
    }

    public static void ejecutarCaso(int n, String numeroCaso) {
        println("---------------------------------------------");
        println("Caso de prueba " + numeroCaso + ": N = " + n);

        long[] dp = calcularEscaleras(n);
        long formasPosibles = dp[n];

        println("Formas posibles: " + formasPosibles);
        print("Tabla DP: ");
        println(Arrays.toString(dp));
    }

    public static void main(String[] args) {
        println(" SOLUCION: Problema de las Escaleras (PD)");

        ejecutarCaso(5, "1");

        ejecutarCaso(7, "2");

        Scanner scanner = new Scanner(System.in);
        try {
            print("ingrese el numero de escalones N que desea analizar: ");
            
            int nUsuario = scanner.nextInt();

            if (nUsuario < 0) {
                println("El numero de escalones debe ser un valor no negativo.");
            } else {
                ejecutarCaso(nUsuario, "Usuario");
            }

        } catch (Exception e) {
            println("Error: ingresar unicamente numeros enteros");
        } finally {
            scanner.close();
        }

    }
}