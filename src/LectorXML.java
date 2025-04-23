import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.*;

public class LectorXML {
    public static List<Pregunta> leerPreguntasDesdeXML(String rutaArchivo) {
        List<Pregunta> preguntas = new ArrayList<>();
        try {
            File archivo = new File(rutaArchivo);
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document documento = builder.parse(archivo);

            NodeList listaPreguntas = documento.getElementsByTagName("pregunta");
            for (int i = 0; i < listaPreguntas.getLength(); i++) {
                Element elementoPregunta = (Element) listaPreguntas.item(i);

                String id = elementoPregunta.getAttribute("id");
                String enunciado = elementoPregunta.getElementsByTagName("enunciado").item(0).getTextContent();

                NodeList opcionesNodos = elementoPregunta.getElementsByTagName("opcion");
                List<String> opciones = new ArrayList<>();
                for (int j = 0; j < opcionesNodos.getLength(); j++) {
                    opciones.add(opcionesNodos.item(j).getTextContent());
                }

                String respuestaCorrecta = elementoPregunta.getElementsByTagName("respuesta").item(0).getTextContent();
                String explicacion = elementoPregunta.getElementsByTagName("explicacion").item(0).getTextContent();

                preguntas.add(new Pregunta(id, enunciado, opciones, respuestaCorrecta, explicacion));
            }
        } catch (Exception e) {
            System.err.println("Error al leer el archivo XML: " + e.getMessage());
        }
        return preguntas;
    }
}