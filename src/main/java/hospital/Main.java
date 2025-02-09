package hospital;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import hospital.model.*;
import hospital.service.PatientService;
import hospital.service.impl.PatientServiceImpl;
import hospital.utils.XMLParser;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;

import java.io.File;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Optional;

public class Main {
    public static void main(String[] args) throws SQLException {

       PatientService patientService = new PatientServiceImpl();

        Patient patient = new Patient(153L, "Jack", "Smith", LocalDate.of(1980, 5,
                15), "Male", "123 Palm Street", 125454321L);
        patientService.create(patient);
        System.out.println("Patient added successfully.");


        Optional<Patient> retrievedPatient = patientService.read(11L);
        retrievedPatient.ifPresentOrElse(System.out::println,
                () -> System.out.println("Patient with ID was not found."));

        Optional<Patient> patientToUpdate = patientService.read(12L);
        if (patientToUpdate.isPresent()) {
            Patient updatedPatient = patientToUpdate.get();
            updatedPatient.setAddress("789 New Street");
            patientService.update(updatedPatient);
            System.out.println("Patient data has been updated.");
        } else {
            System.out.println("The patient for the update was not found.");
        }

        //XML validation check and parsing
        System.out.println();

        String xmlFilePath = "src/main/java/resources/hospital.xml";
        String xsdFilePath = "src/main/java/resources/hospital.xsd";


        if (XMLParser.validateXML(xmlFilePath, xsdFilePath)) {
            System.out.println("XML is valid.");

            XMLParser.parseXML(xmlFilePath);
        } else {
            System.out.println("XML is not valid.");
        }

        //JAXB
        System.out.println();

        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Hospital.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

            Hospital hospital = (Hospital) unmarshaller
                    .unmarshal(new File("src/main/java/resources/hospital.xml"));
            System.out.println("Parsed hospital data: " + hospital);

        } catch (JAXBException e) {
            e.printStackTrace();
        }

       //JASON
        try {

            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.enable(DeserializationFeature.UNWRAP_ROOT_VALUE);
            objectMapper.registerModule(new JavaTimeModule());

            Hospital hospital = objectMapper.readValue(new File("src/main/java/resources/hospital.jason"),
                    Hospital.class);

            System.out.println(hospital);

            /*
            objectMapper.writerWithDefaultPrettyPrinter()
                    .writeValue(new File("src/main/java/resources/output_hospital.json"), hospital);*/
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    }

