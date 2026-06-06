
# Actividad 8: Algoritmos Voraces (Greedy)

**Materia:** Estructura de Datos y Algoritmos  
**Lenguaje:** Java  

---

## Descripción

Implementación de dos algoritmos voraces (Greedy) clásicos:

1. **Mochila Fraccional** — maximizar el valor transportado permitiendo fraccionar objetos.
2. **Cobertura de Antenas** — cubrir todas las casas de una carretera con la menor cantidad de antenas posible.

---

## Estructura del repositorio


AlgoritmosVoracesActividad08/
├── MochilaFraccional.java   # Problema 1: Mochila Fraccional
├── CoberturaAntenas.java    # Problema 2: Cobertura de Antenas
└── latex/
    ├── main.tex             # Código fuente del reporte
    └── main.pdf             # Reporte final compilado


---

## Requisitos

- **Java JDK 11** o superior
- Verificar instalación: `java --version`

---

## Cómo ejecutar

Desde la raíz del repositorio (`AlgoritmosVoracesActividad08/`):

### Problema 1 — Mochila Fraccional

bash
javac MochilaFraccional.java
java MochilaFraccional


**Salida esperada:**

=== Mochila Fraccional ===
Capacidad maxima: 50

Objetos seleccionados:
  A completo       | valor:  60.00 | ratio: 6.0000 | peso usado: 10
  B completo       | valor: 100.00 | ratio: 5.0000 | peso usado: 20
  20/30 de C       | valor:  80.00 | ratio: 4.0000 | peso usado: 20

Valor total obtenido: 240.00


### Problema 2 — Cobertura de Antenas

bash
javac CoberturaAntenas.java
java CoberturaAntenas


**Salida esperada:**

=== Cobertura de Antenas ===
Casas: [1, 2, 7, 11, 20, 21, 30]
Cobertura R: 5

Antenas colocadas en:
  Posicion   6  |  cubre [1, 11]
  Posicion  25  |  cubre [20, 30]

Cantidad total de antenas: 2


---

## Estrategia Greedy utilizada

| Problema | Criterio de decisión | Complejidad |
|---|---|---|
| Mochila Fraccional | Mayor ratio `valor/peso` primero | O(N log N) |
| Cobertura de Antenas | Colocar antena en `casa + R` | O(N log N) |

---

## Reporte

El análisis completo (estrategia greedy, justificación de optimalidad, complejidad Big-O y trazas de ejecución) se encuentra en `latex/main.pdf`.
