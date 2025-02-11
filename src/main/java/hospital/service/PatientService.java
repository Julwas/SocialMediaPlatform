package hospital.service;

import hospital.model.Patient;

import java.util.Optional;

public interface PatientService <D, L> extends GenericService<Patient, Long>{

    void create(Patient patient);
}
