import java.util.Arrays;


public class CambioMonedas {

    private static final int INFINITO = Integer.MAX_VALUE;


    public static void print(Object msg) {
        System.out.print(msg);
    }


    public static void println(Object msg) {
        System.out.println(msg);
    }

    private static class ResultadoDP {
        int[] dp;
        int[] monedaUsada;
    }

    private static ResultadoDP calcularDP(int[] monedas, int cantidad) {
        int[] dp = new int[cantidad + 1];
        int[] monedaUsada = new int[cantidad + 1];

        Arrays.fill(dp, INFINITO);
        dp[0] = 0;

        for (int i = 1; i <= cantidad; i++) {
            for (int moneda : monedas) {
                if (moneda <= i && dp[i - moneda] != INFINITO) {
                    int candidato = dp[i - moneda] + 1;
                    if (candidato < dp[i]) {
                        dp[i] = candidato;
                        monedaUsada[i] = moneda;
                    }
                }
            }
        }

        ResultadoDP resultado = new ResultadoDP();
        resultado.dp = dp;
        resultado.monedaUsada = monedaUsada;
        return resultado;
    }

    private static String reconstruirCombinacion(int[] monedaUsada, int cantidad) {
        StringBuilder combinacion = new StringBuilder();
        int restante = cantidad;

        while (restante > 0) {
            int moneda = monedaUsada[restante];
            if (combinacion.length() > 0) {
                combinacion.append("+");
            }
            combinacion.append(moneda);
            restante -= moneda;
        }

        return combinacion.toString();
    }


    public static void ejecutarCaso(int[] monedas, int cantidad, int numeroCaso) {
        println("---------------------------------------------");
        println("Caso de prueba " + numeroCaso + ": Monedas = "
                + Arrays.toString(monedas) + ", Cantidad = " + cantidad);

        ResultadoDP resultado = calcularDP(monedas, cantidad);

        if (resultado.dp[cantidad] == INFINITO) {
            println("No es posible formar la cantidad solicitada con las monedas dadas.");
            return;
        }

        int minimoMonedas = resultado.dp[cantidad];
        String combinacion = reconstruirCombinacion(resultado.monedaUsada, cantidad);

        println("Cantidad minima de monedas: " + minimoMonedas);
        println("Combinacion: " + combinacion);
        print("Tabla DP: ");
        println(Arrays.toString(resultado.dp));
    }

    public static void main(String[] args) {
        println("============================================");
        println(" SOLUCION: Cambio Minimo de Monedas (PD)");
        println("============================================");

        ejecutarCaso(new int[]{1, 3, 4}, 6, 1);

        ejecutarCaso(new int[]{1, 2, 5}, 11, 2);

        println("---------------------------------------------");
        println("Ejecucion finalizada.");
    }
}