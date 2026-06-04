import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class CoberturaAntenas {

    static void print(String mensaje) {
        System.out.println(mensaje);
    }

    static List<Integer> colocarAntenas(int[] casas, int R) {
        Arrays.sort(casas);

        List<Integer> antenas = new ArrayList<>();
        int i = 0;

        while (i < casas.length) {
            int posAntena = casas[i] + R;
            antenas.add(posAntena);

            while (i < casas.length && casas[i] <= posAntena + R) {
                i++;
            }
        }

        return antenas;
    }

    static void resolver(int[] casas, int R) {
        print("=== Cobertura de Antenas ===");
        print("Casas: " + Arrays.toString(casas));
        print("Cobertura R: " + R);
        print("");

        List<Integer> antenas = colocarAntenas(casas, R);

        print("Antenas colocadas en:");
        for (int pos : antenas) {
            print("  Posicion: " + pos
                    + "  →  cubre [" + (pos - R) + ", " + (pos + R) + "]");
        }
        print("");
        print("Cantidad total de antenas: " + antenas.size());
    }

    public static void main(String[] args) {

        // ── Ejemplo 1 ──
        int[] casas1 = {1, 2, 7, 11, 20, 21, 30};
        resolver(casas1, 5);

        print("");
        print("----------------------------------------");
        print("");

        // ── Ejemplo 2 ──
        int[] casas2 = {2, 4, 8, 15, 18, 22};
        resolver(casas2, 3);
    }
}