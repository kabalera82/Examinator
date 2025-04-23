import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Pregunta> preguntas = LectorXML.leerPreguntasDesdeXML("src/preguntas.xml");
        if (preguntas.isEmpty()) {
            System.out.println("No se pudieron cargar preguntas.");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        Collections.shuffle(preguntas);

        int totalPreguntas = 0;
        int aciertos = 0;
        int fallos = 0;
        boolean fin = false;

        Iterator<Pregunta> iter = preguntas.iterator();

        while (!fin && iter.hasNext()) {
            Pregunta p = iter.next();
            totalPreguntas++;

            System.out.println("\n--- Pregunta " + totalPreguntas + " ---");
            System.out.println(p.enunciado);
            char letra = 'a';
            for (String opcion : p.opciones) {
                System.out.println(" " + opcion);
                letra++;
            }

            System.out.print("Tu respuesta (a/b/c/d o 0 para salir): ");
            String respuestaUsuario = scanner.nextLine().trim().toLowerCase();

            if (respuestaUsuario.equals("0")) {
                fin = true;
                break;
            }

            if (p.esCorrecta(respuestaUsuario)) {
                System.out.println("✅ ¡Correcto!");
                aciertos++;
            } else {
                System.out.println("❌ Incorrecto. La respuesta correcta era: " + p.respuestaCorrecta);
                fallos++;
            }

            System.out.println("📝 Explicación: " + p.explicacion);
        }

        // Calcular nota final
        double puntuacionCruda = aciertos - (fallos / 3.0);
        if (puntuacionCruda < 0) puntuacionCruda = 0;

        double notaFinal = (puntuacionCruda * 10.0) / totalPreguntas;
        if (notaFinal > 10) notaFinal = 10;

        // Resultado final
        System.out.println("\n=== Resultados ===");
        System.out.println("Preguntas respondidas: " + totalPreguntas);
        System.out.println("Aciertos: " + aciertos);
        System.out.println("Fallos: " + fallos);
        System.out.printf("Nota final: %.2f\n", notaFinal);

        scanner.close();
    }
}
