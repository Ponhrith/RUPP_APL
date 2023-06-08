package XMLParser;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;

public class DOMParser {
    public static void main(String[] args) {
        DOMReader("SampleFile.xml");
        //DOMWriter("SampleFileNewDOM.xml");
    }

    public static void DOMReader(String fileName) {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = null;
        try {
            File file = new File(fileName);
            db = dbf.newDocumentBuilder();
            Document doc = db.parse(file);
            Element root = doc.getDocumentElement(); // Will return "Library" as root
            NodeList list = root.getElementsByTagName("book"); // get list of element "book" in library
            for (int i = 0; i < list.getLength(); i++) {
                Node node = list.item(i);
                Element element = (Element) node;
                String id = element.getAttribute("id");
                System.out.println("ID " + id);
                String title = element.getElementsByTagName("title").item(0).getTextContent();
                System.out.println("title " + title);
                String author = element.getElementsByTagName("author").item(0).getTextContent();
                System.out.println("author " + author);
                String isbn = element.getElementsByTagName("isbn").item(0).getTextContent();
                System.out.println("isbn " + isbn);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (SAXException e) {
            throw new RuntimeException(e);
        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        }
    }

    public static void DOMWriter(String fileName) {
        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            // root elements
            Document doc = docBuilder.newDocument();

            Element rootElement = (Element) doc.appendChild(doc.createElement("library"));
            rootElement.setAttribute("name", ".NET Developer's Library");

            Element book1 = (Element) rootElement.appendChild(doc.createElement("book"));
            book1.setAttribute("id", "001");

            Element title1 = (Element) book1.appendChild(doc.createElement("title"));
            title1.setTextContent("Programming Microsoft .NET");

            Element author1 = (Element) book1.appendChild(doc.createElement("author"));
            author1.setTextContent("Jeff Prosise");

            Element isbn1 = (Element) book1.appendChild(doc.createElement("isbn"));
            isbn1.setTextContent("0-7356-1376-1");


            Element book2 = (Element) rootElement.appendChild(doc.createElement("book"));
            book2.setAttribute("id", "002");

            Element title2 = (Element) book2.appendChild(doc.createElement("title"));
            title2.setTextContent("Microsoft .NET for Programmers");

            Element author2 = (Element) book2.appendChild(doc.createElement("author"));
            author2.setTextContent("Fergal Grimes");

            Element isbn2 = (Element) book2.appendChild(doc.createElement("isbn"));
            isbn2.setTextContent("1-930110-19-7");

            FileOutputStream output = new FileOutputStream(fileName);
            writeXml(doc, output);

        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static void writeXml(Document doc, OutputStream output) {
        try {
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = null;
            transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(output);
            transformer.transform(source, result);
        } catch (TransformerConfigurationException e) {
            throw new RuntimeException(e);
        } catch (TransformerException e) {
            throw new RuntimeException(e);
        }
    }
}


