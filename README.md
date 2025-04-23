# 📚 App de Preguntas Java - Consola

Una aplicación Java para practicar preguntas tipo test sobre programación en Java. Las preguntas se leen desde un archivo XML y se presentan de forma aleatoria en la consola, evaluando respuestas y mostrando explicaciones.

---

## 🧩 Estructura del Proyecto

- `Main.java` → Punto de entrada. Controla el flujo del cuestionario.
- `LectorXML.java` → Lee el archivo XML y genera una lista de objetos `Pregunta`.
- `Pregunta.java` → Clase que representa una pregunta individual.
- `preguntas.xml` → Archivo con todas las preguntas en formato estructurado.

---

## 💡 ¿Cómo funciona?

1. Las preguntas se cargan desde `preguntas.xml`.
2. Se muestran una a una al usuario en orden aleatorio.
3. El usuario responde escribiendo `a`, `b`, `c`, `d` o `0` para salir.
4. Se muestran mensajes de acierto/error y una explicación.
5. Al final, se calcula una nota basada en aciertos y fallos.

---

## ▶️ Ejecución

Compila y ejecuta el proyecto con:

```bash
javac Main.java LectorXML.java Pregunta.java
java Main
✍️ Formato de una pregunta en preguntas.xml
xml
Copiar
Editar
<pregunta id="1">
  <enunciado>¿Qué clase se utiliza para leer datos desde consola?</enunciado>
  <opciones>
    <opcion>a) InputReader</opcion>
    <opcion>b) Scanner</opcion>
    <opcion>c) ConsoleReader</opcion>
    <opcion>d) BufferReader</opcion>
  </opciones>
  <respuesta>b</respuesta>
  <explicacion>Scanner es la clase comúnmente usada para leer datos desde consola en Java.</explicacion>
</pregunta>
✅ Resultado final
Se muestra:

Total de preguntas respondidas

Número de aciertos y fallos

Nota final sobre 10 (con penalización por fallos)

🛠 Requisitos
JDK 8 o superior

Archivo preguntas.xml en el mismo directorio o en src/

📘 Ideal para estudiantes, docentes y quien quiera reforzar su Java.