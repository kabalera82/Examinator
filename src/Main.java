import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        List<Pregunta> preguntas = cargarPreguntas("src/preguntas.txt");
        if (preguntas.isEmpty()) {
            System.out.println("No se pudieron cargar preguntas.");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        Collections.shuffle(preguntas);  // Baraja las preguntas
        int puntuacion = 0;

        for (Pregunta p : preguntas) {
            System.out.println(p.enunciado);
            for (String opcion : p.opciones) {
                System.out.println(opcion); // Las letras ya están incluidas
            }

            System.out.print("Tu respuesta (a/b/c/d): ");
            String respuestaUsuario = scanner.nextLine().trim().toLowerCase();

            if (p.esCorrecta(respuestaUsuario)) {
                System.out.println("✅ ¡Correcto!");
                puntuacion++;
            } else {
                System.out.println("❌ Incorrecto. La respuesta correcta era: " + p.respuestaCorrecta);
            }

            System.out.println("📝 Explicación: " + p.explicacion + "\n");
        }

        System.out.println("Tu puntuación final: " + puntuacion + " / " + preguntas.size());
        scanner.close();
    }

    public static List<Pregunta> cargarPreguntas(String archivo) {
        List<Pregunta> preguntas = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                if (linea.trim().isEmpty() || linea.startsWith("#")) continue;

                String enunciado = linea;
                String[] opciones = new String[4];
                for (int i = 0; i < 4; i++) {
                    opciones[i] = br.readLine();
                }

                String correcta = br.readLine().replace("Respuesta correcta: ", "").trim().toLowerCase();
                String explicacion = br.readLine();

                preguntas.add(new Pregunta(enunciado, opciones, correcta, explicacion));

                br.readLine(); // salta línea en blanco
            }
        } catch (IOException e) {
            System.out.println("Error leyendo archivo: " + e.getMessage());
        }

        return preguntas;
    }
}
