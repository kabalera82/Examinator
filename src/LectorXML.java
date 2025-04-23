import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.*;
import org.w3c.dom.*;

public class LectorXML {

    public static List<Pregunta> leerPreguntasDesdeXML(String rutaArchivo) {
        List<Pregunta> preguntas = new ArrayList<>();

        try {
            File archivo = new File(rutaArchivo);
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(archivo);
            doc.getDocumentElement().normalize();

            NodeList listaPreguntas = doc.getElementsByTagName("pregunta");

            for (int i = 0; i < listaPreguntas.getLength(); i++) {
                Node nodo = listaPreguntas.item(i);

                if (nodo.getNodeType() == Node.ELEMENT_NODE) {
                    Element elementoPregunta = (Element) nodo;

                    String enunciado = elementoPregunta.getElementsByTagName("enunciado").item(0).getTextContent();

                    Element opcionesElement = (Element) elementoPregunta.getElementsByTagName("opciones").item(0);
                    NodeList opcionesNodos = opcionesElement.getElementsByTagName("opcion");

                    String[] opciones = new String[opcionesNodos.getLength()];
                    for (int j = 0; j < opcionesNodos.getLength(); j++) {
                        opciones[j] = opcionesNodos.item(j).getTextContent();
                    }

                    String respuesta = elementoPregunta.getElementsByTagName("respuesta").item(0).getTextContent().trim().toLowerCase();
                    String explicacion = elementoPregunta.getElementsByTagName("explicacion").item(0).getTextContent();

                    preguntas.add(new Pregunta(enunciado, opciones, respuesta, explicacion));
                }
            }

        } catch (Exception e) {
            System.out.println("❌ Error al leer XML: " + e.getMessage());
        }

        return preguntas;
    }
}
