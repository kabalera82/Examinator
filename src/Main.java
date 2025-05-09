import javax.swing.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Pregunta> preguntas = LectorXML.leerPreguntasDesdeXML("preguntas.xml");
        if (preguntas.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No se pudieron cargar preguntas.");
            return;
        }

        int totalPreguntasDisponibles = preguntas.size();
        JOptionPane.showMessageDialog(null, "Total de preguntas disponibles: " + totalPreguntasDisponibles);

        Collections.shuffle(preguntas);

        int totalPreguntas = 0;
        int aciertos = 0;
        int fallos = 0;
        boolean fin = false;

        Iterator<Pregunta> iter = preguntas.iterator();

        while (!fin && iter.hasNext()) {
            Pregunta p = iter.next();
            totalPreguntas++;

            StringBuilder preguntaBuilder = new StringBuilder();
            preguntaBuilder.append("--- Pregunta ").append(totalPreguntas)
                    .append(" (ID: ").append(p.id).append(") ---\n")
                    .append(p.enunciado).append("\n");


            for (String opcion : p.opciones) {
                preguntaBuilder.append(opcion).append("\n");
                ;
            }

            String respuestaUsuario = JOptionPane.showInputDialog(
                    null,
                    preguntaBuilder.toString() + "\nTu respuesta (a/b/c/d o 0 para salir):"
            );

            if (respuestaUsuario == null || respuestaUsuario.trim().equals("0")) {
                fin = true;
                break;
            }

            respuestaUsuario = respuestaUsuario.trim().toLowerCase();

            if (p.esCorrecta(respuestaUsuario)) {
                JOptionPane.showMessageDialog(null, "✅ ¡Correcto!");
                aciertos++;
            } else {
                JOptionPane.showMessageDialog(null, "❌ Incorrecto. La respuesta correcta era: " + p.respuestaCorrecta);
                fallos++;
            }

            JOptionPane.showMessageDialog(null, "📝 Explicación: " + p.explicacion);
        }

        double puntuacionCruda = aciertos - (fallos / 3.0);
        if (puntuacionCruda < 0) puntuacionCruda = 0;

        double notaFinal = (puntuacionCruda * 10.0) / totalPreguntas;
        if (notaFinal > 10) notaFinal = 10;

        String resultadoFinal = String.format(
                "=== Resultados ===\nPreguntas respondidas: %d\nAciertos: %d\nFallos: %d\nNota final: %.2f",
                totalPreguntas, aciertos, fallos, notaFinal
        );

        JOptionPane.showMessageDialog(null, resultadoFinal);
    }
}
