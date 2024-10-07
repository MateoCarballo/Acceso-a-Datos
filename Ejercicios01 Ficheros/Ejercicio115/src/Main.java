import org.w3c.dom.Attr;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
/*
Ejercicio 115
Crea el fichero peliculas.xml que tenga el siguiente contenido:

<?xml version="1.0" encoding="UTF-8"?>
<peliculas>
    <pelicula id="1">
        <titulo>El señor de los anillos</titulo>
        <ano>1999</ano>
        <precio>19.99</precio>
    </pelicula>
    <pelicula id="2">
        <titulo>Star Wars</titulo>
        <ano>2005</ano>
        <precio>12.50</precio>
    </pelicula>
    <pelicula id="3">
        <titulo>Harry Potter</titulo>
        <ano>2001</ano>
        <precio>8.25</precio>
    </pelicula>
</peliculas>
 */

        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            DOMImplementation implementation = docBuilder.getDOMImplementation();
            Document doc = docBuilder.getDOMImplementation().createDocument(null,"peliculas",null);

            //Creacion del primer elemento RAIZ

            Element peliculas = doc.getDocumentElement();

            Element titulo1 = doc.createElement("titulo");
            titulo1.setTextContent("El señor de los anillos");

            Element ano1 = doc.createElement("ano");
            ano1.setTextContent("1999");

            Element precio1 = doc.createElement("precio");
            precio1.setTextContent("19.99");

            Element pelicula1 = doc.createElement("pelicula");
            Attr atributoPelicula1 = doc.createAttribute("id");
            atributoPelicula1.setValue("1");
            pelicula1.setAttributeNode(atributoPelicula1);

            pelicula1.appendChild(titulo1);
            pelicula1.appendChild(ano1);
            pelicula1.appendChild(precio1);


            Element titulo2 = doc.createElement("titulo");
            titulo2.setTextContent("Star Wars");

            Element ano2 = doc.createElement("ano");
            ano2.setTextContent("2005");

            Element precio2 = doc.createElement("precio");
            precio2.setTextContent("12.50");

            Element pelicula2 = doc.createElement("pelicula");
            Attr atributoPelicula2 = doc.createAttribute("id");
            atributoPelicula2.setValue("2");
            pelicula2.setAttributeNode(atributoPelicula2);

            pelicula2.appendChild(titulo2);
            pelicula2.appendChild(ano2);
            pelicula2.appendChild(precio2);

            Element titulo3 = doc.createElement("titulo");
            titulo3.setTextContent("Harry Potter");

            Element ano3 = doc.createElement("ano");
            ano3.setTextContent("2001");

            Element precio3 = doc.createElement("precio");
            precio3.setTextContent("8.25");

            Element pelicula3 = doc.createElement("pelicula");
            Attr atributoPelicula3 = doc.createAttribute("id");
            atributoPelicula3.setValue("3");
            pelicula3.setAttributeNode(atributoPelicula3);

            pelicula3.appendChild(titulo3);
            pelicula3.appendChild(ano3);
            pelicula3.appendChild(precio3);


            peliculas.appendChild(pelicula1);
            peliculas.appendChild(pelicula2);
            peliculas.appendChild(pelicula3);

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            File dirContenedora = new File("src/ArchivosXML");
            if (!dirContenedora.exists()){
                dirContenedora.mkdirs();
            }
            File f = new File("src/ArchivosXML/peliculas.xml");
            StreamResult result = new StreamResult(f);
            transformer.transform(source,result);


        } catch (ParserConfigurationException | TransformerException e) {
            System.out.println("Ha ocurrido un error");
        }

    }
}