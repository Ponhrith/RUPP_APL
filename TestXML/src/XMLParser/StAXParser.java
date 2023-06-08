package XMLParser;

import javax.xml.stream.*;
import java.io.*;
import java.nio.file.*;
import javax.xml.stream.events.XMLEvent;
import javax.xml.transform.*;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class StAXParser {
    public static void main(String[] args) {
//        StAXReader("SampleFile.xml");
        StAXWriter("SampleFileNewStAX.xml");

    }
    public static void StAXReader(String fileName)
    {
        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
        Path path = Paths.get(fileName);
        XMLStreamReader reader = null;
        try {
            reader = xmlInputFactory.createXMLStreamReader(new FileInputStream(path.toFile()));
            int eventType = reader.getEventType();
            while (reader.hasNext()) {
                eventType = reader.next();
                if (eventType == XMLEvent.START_ELEMENT) {
                    switch (reader.getName().getLocalPart()) {

                        case "library": {
                            String name = reader.getAttributeValue(null, "name");
                            System.out.println("Library Name " + name);
                        }
                        break;
                        case "book": {
                            String id = reader.getAttributeValue(null, "id");
                            System.out.println("Book ID: " + id);
                        }
                        break;
                        case "title": {
                            eventType = reader.next();
                            if (eventType == XMLEvent.CHARACTERS) {
                                System.out.println("Title " + reader.getText());
                            }
                        }
                        break;
                        case "author": {
                            eventType = reader.next();
                            if (eventType == XMLEvent.CHARACTERS) {
                                System.out.println("Author " + reader.getText());
                            }
                        }
                        case "isbn": {
                            eventType = reader.next();
                            if (eventType == XMLEvent.CHARACTERS) {
                                System.out.println("isbn " + reader.getText());
                            }
                        }
                        break;
                    }
                }
            }
        } catch (XMLStreamException e) {
            throw new RuntimeException(e);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public static void StAXWriter(String fileName){
        try {
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            XMLOutputFactory output = XMLOutputFactory.newInstance();
            XMLStreamWriter writer = output.createXMLStreamWriter(out);
            writer.writeStartDocument("1.0");
            writer.writeStartElement("library");
            writer.writeAttribute("name", ".NET Developer's Library");

            writer.writeStartElement("book");
            writer.writeAttribute("id", "001");

                writer.writeStartElement("title");
                writer.writeCharacters("Programming Microsoft .NET");
                writer.writeEndElement();

                writer.writeStartElement("author");
                writer.writeCharacters("Jeff Prosise");
                writer.writeEndElement();

                writer.writeStartElement("isbn");
                writer.writeCharacters("0-7356-1376-1");
                writer.writeEndElement();

            writer.writeEndElement();
            // </book>

            // <book 002>
            writer.writeStartElement("book");
            writer.writeAttribute("id", "002");

                writer.writeStartElement("title");
                writer.writeCharacters("Microsoft .NET for Programmers");
                writer.writeEndElement();

                writer.writeStartElement("author");
                writer.writeCharacters("Fergal Grimes");
                writer.writeEndElement();

                writer.writeStartElement("isbn");
                writer.writeCharacters("1-930110-19-7");
                writer.writeEndElement();

            writer.writeEndElement();
            // </book>

            writer.writeEndDocument();
            // </library>
            writer.flush();
            writer.close();

            String xml = new String(out.toByteArray());
            String prettyPrintXML = formatXML(xml);
            Files.writeString(Paths.get(fileName), prettyPrintXML);

        } catch (XMLStreamException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (TransformerException e) {
            throw new RuntimeException(e);
        }
    }
    private static String formatXML(String xml) throws TransformerException {

        // write data to xml file
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();

        // pretty print by indention
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");

        // add standalone="yes", add line break before the root element
        transformer.setOutputProperty(OutputKeys.STANDALONE, "yes");

        StreamSource source = new StreamSource(new StringReader(xml));
        StringWriter output = new StringWriter();
        transformer.transform(source, new StreamResult(output));

        return output.toString();

    }
}
