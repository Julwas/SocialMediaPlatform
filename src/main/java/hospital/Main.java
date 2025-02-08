package hospital;

import hospital.model.Patient;
import hospital.service.PatientService;
import hospital.service.impl.PatientServiceImpl;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Optional;

public class Main {
    public static void main(String[] args) throws SQLException {

        PatientService patientService = new PatientServiceImpl();

        Patient patient = new Patient(150L, "Jack", "Smith", LocalDate.of(1980, 5,
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

        String xmlFilePath = "src/main/java/resources/hospital.xml";
        String xsdFilePath = "src/main/java/resources/hospital.xsd";


        if (XMLParser.validateXML(xmlFilePath, xsdFilePath)) {
            System.out.println("XML is valid.");

            XMLParser.parseXML(xmlFilePath);
        } else {
            System.out.println("XML is not valid.");
        }
    }
}
