public class Pregunta {
    public String enunciado;
    public String[] opciones;
    public String respuestaCorrecta;
    public String explicacion;

    public Pregunta(String enunciado, String[] opciones, String respuestaCorrecta, String explicacion) {
        this.enunciado = enunciado;
        this.opciones = opciones;
        this.respuestaCorrecta = respuestaCorrecta.toLowerCase();
        this.explicacion = explicacion;
    }

    public boolean esCorrecta(String respuestaUsuario) {
        return respuestaCorrecta.equals(respuestaUsuario);
    }
}
