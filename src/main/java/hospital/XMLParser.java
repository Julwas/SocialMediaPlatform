package hospital;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

public class XMLParser {
    // Метод для проверки XML на основе XSD
    public static boolean validateXML(String xmlFilePath, String xsdFilePath) {
        try {
            SchemaFactory factory = SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");
            Schema schema = factory.newSchema(new File(xsdFilePath));
            Validator validator = schema.newValidator();
            validator.validate(new StreamSource(new File(xmlFilePath)));
            return true;
        } catch (SAXException | IOException e) {
            System.err.println("XML Validation Error: " + e.getMessage());
            return false;
        }
    }

    // Метод для парсинга XML с использованием DOM
    public static void parseXML(String xmlFilePath) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new File(xmlFilePath));
            document.getDocumentElement().normalize();

            System.out.println("Root Element: " + document.getDocumentElement().getNodeName());

            // Пример парсинга пациентов
            NodeList patients = document.getElementsByTagName("patient");
            for (int i = 0; i < patients.getLength(); i++) {
                Node patientNode = patients.item(i);
                if (patientNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element patient = (Element) patientNode;
                    System.out.println("Patient ID: " + patient.getElementsByTagName("id").item(0).getTextContent());
                    System.out.println("First Name: " + patient.getElementsByTagName("firstName").item(0).getTextContent());
                    System.out.println("Last Name: " + patient.getElementsByTagName("lastName").item(0).getTextContent());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
