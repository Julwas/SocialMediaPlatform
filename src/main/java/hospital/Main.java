package hospital;

import hospital.model.Patient;
import hospital.service.PatientService;
import hospital.service.impl.PatientServiceImpl;

import java.time.LocalDate;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        PatientService patientService = new PatientServiceImpl();

        // Example Usage
        Patient patient = new Patient(1L, "John", "Doe", LocalDate.of(1990, 1, 1), "Male", "123 Street", 1234567890L);
        patientService.addPatient(patient);

        Optional<Patient> retrievedPatient = ((PatientServiceImpl) patientService).getPatient(1L);
        retrievedPatient.ifPresent(System.out::println);
    }
}
