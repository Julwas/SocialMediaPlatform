package hospital;

import hospital.model.Patient;
import hospital.service.PatientService;
import hospital.service.impl.PatientServiceImpl;

import java.time.LocalDate;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {

        /*PatientService patientService = new PatientServiceImpl();

        Patient patient = new Patient(null, "John", "Doe", LocalDate.of(1990, 1, 1), "Male", "123 Street", 1234567890L);
        patientService.addPatient(patient);
        System.out.println("Patient added successfully.");


        Optional<Patient> retrievedPatient = patientService.getPatient(11L);
        retrievedPatient.ifPresentOrElse(System.out::println,
                () -> System.out.println("Patient with ID was not found."));

        Optional<Patient> patientToUpdate = patientService.getPatient(12L);
        if (patientToUpdate.isPresent()) {
            Patient updatedPatient = patientToUpdate.get();
            updatedPatient.setAddress("789 New Street");
            patientService.updatePatient(updatedPatient);
            System.out.println("Patient data has been updated.");
        } else {
            System.out.println("The patient for the update was not found.");
        }*/
        String xmlFilePath = "src/main/java/hospital/hospital.xml";
        String xsdFilePath = "src/main/java/hospital/hospital.xsd";

        // Проверка валидации XML
        if (XMLParser.validateXML(xmlFilePath, xsdFilePath)) {
            System.out.println("XML is valid.");
            // Парсинг XML
            XMLParser.parseXML(xmlFilePath);
        } else {
            System.out.println("XML is not valid.");
        }

    }
}
