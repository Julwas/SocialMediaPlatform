package hospital.patterns.facade;

import hospital.model.Admission;
import hospital.model.Patient;
import hospital.service.AdmissionService;
import hospital.service.PatientService;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class HospitalFacade {
    private final PatientService<Patient, Long> patientService;
    private final AdmissionService<Admission, Long> admissionService;

    public HospitalFacade(PatientService<Patient, Long> patientService,
                          AdmissionService<Admission, Long> admissionService) {
        this.patientService = patientService;
        this.admissionService = admissionService;
    }

    public Patient registerPatient(String firstName, String lastName, LocalDate dateOfBirth, String gender, String address, Long contactNumber) {
        Patient patient = new Patient(null, firstName, lastName, dateOfBirth, gender, address, contactNumber);
        patientService.create(patient);
        System.out.println("Patient registered: " + patient);
        return patient;
    }


    public Admission admitPatient(Long patientId, Long roomId, LocalDate admissionDate) {
        Admission admission = new Admission(patientId, roomId, admissionDate, null);
        admissionService.create(admission);
        System.out.println("Patient admitted: " + admission);
        return admission;
    }


    public void dischargePatient(Long admissionId, LocalDate dischargeDate) throws SQLException {
        Optional<Admission> admission = admissionService.read(admissionId);
        admission.ifPresent(a -> {
            a.setDischargeDate(dischargeDate);
            admissionService.update(a);
            System.out.println("Patient discharged: " + a);
        });
    }

    public List<Patient> getAllPatients() {
        return patientService.getAll();
    }

    public List<Admission> getAllAdmissions() {
        return admissionService.getAll();
    }

    public void removePatient(Long patientId) {
        patientService.delete(patientId);
        System.out.println("Patient removed with ID: " + patientId);
    }
}
