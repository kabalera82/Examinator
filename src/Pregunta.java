import java.util.List;

public class Pregunta {
    public String id; // Campo para almacenar el ID de la pregunta
    public String enunciado;
    public List<String> opciones;
    public String respuestaCorrecta;
    public String explicacion;

    // Constructor
    public Pregunta(String id, String enunciado, List<String> opciones, String respuestaCorrecta, String explicacion) {
        this.id = id;
        this.enunciado = enunciado;
        this.opciones = opciones;
        this.respuestaCorrecta = respuestaCorrecta;
        this.explicacion = explicacion;
    }

    // Método para verificar si la respuesta es correcta
    public boolean esCorrecta(String respuestaUsuario) {
        return respuestaCorrecta.equalsIgnoreCase(respuestaUsuario);
    }
}