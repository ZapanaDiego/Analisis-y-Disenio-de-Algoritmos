import java.util.Arrays;
import java.util.Comparator;


public class MochilaFraccional {

    static class Objeto {
        String nombre;
        double valor;
        double peso;
        double ratio;

        Objeto(String nombre, double valor, double peso) {
            this.nombre = nombre;
            this.valor  = valor;
            this.peso   = peso;
            this.ratio  = valor / peso;
        }
    }

    static void print(String mensaje) {
        System.out.println(mensaje);
    }

    static double resolverMochila(Objeto[] objetos, double capacidad) {

        Arrays.sort(objetos, Comparator.comparingDouble((Objeto o) -> o.ratio).reversed());

        double valorTotal    = 0.0;
        double pesoRestante  = capacidad;

        print("=== Mochila Fraccional ===");
        print(String.format("Capacidad maxima: %.0f", capacidad));
        print("");
        print("Objetos seleccionados:");

        for (Objeto obj : objetos) {
            if (pesoRestante <= 0) break; // mochila llena

            if (obj.peso <= pesoRestante) {
                // Tomar el objeto completo
                valorTotal   += obj.valor;
                pesoRestante -= obj.peso;
                print(String.format("  %s completo  (valor: %.1f, peso: %.1f, ratio: %.2f)",
                        obj.nombre, obj.valor, obj.peso, obj.ratio));
            } else {
                // Tomar solo la fraccion que cabe
                double fraccion = pesoRestante / obj.peso;
                valorTotal  += fraccion * obj.valor;
                print(String.format("  %.0f/%.0f Parte del objeto %s  (valor parcial: %.2f, ratio: %.2f)",
                        pesoRestante, obj.peso, obj.nombre, fraccion * obj.valor, obj.ratio));
                pesoRestante = 0;
            }
        }

        print("");
        print(String.format("Valor total obtenido: %.2f", valorTotal));
        return valorTotal;
    }

    public static void main(String[] args) {

        Objeto[] objetos1 = {
            new Objeto("A", 60,  10),
            new Objeto("B", 100, 20),
            new Objeto("C", 120, 30)
        };
        resolverMochila(objetos1, 50);

        print("");
        print("----------------------------------------");
        print("");

        // ── Ejemplo 2 ──
        Objeto[] objetos2 = {
            new Objeto("A", 80,  20),
            new Objeto("B", 100, 10),
            new Objeto("C", 120, 30)
        };
        resolverMochila(objetos2, 25);
    }
}