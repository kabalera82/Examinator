📘 Proyecto: Quiz Java con XML(AQUI ES DONDE ESTA LO BUENO) y Penalización
Este proyecto es una aplicación de consola en Java que:

Lee preguntas desde un archivo XML.

Presenta las preguntas de forma aleatoria.

Evalúa las respuestas del usuario.

Aplica una penalización: cada 3 errores descuentan 1 punto.

Escala la nota final sobre 10 puntos.

✅ Requisitos
Java 8 o superior

Archivo preguntas.xml con las preguntas en el formato correcto

Clase Pregunta y clase LectorXML implementadas

▶️ Cómo ejecutar
Coloca tu archivo preguntas.xml en src/.

Asegúrate de tener las clases:

Pregunta: representa una pregunta con enunciado, opciones, respuesta correcta y explicación.

LectorXML: lee y parsea preguntas desde XML.

Compila y ejecuta Main.java.

🧠 Lógica de evaluación
✅ Respuesta correcta = +1 punto

❌ Respuesta incorrecta = −0.333333 puntos

Nota final = ((aciertos - fallos/3.0) * 10) / total de preguntas respondidas
