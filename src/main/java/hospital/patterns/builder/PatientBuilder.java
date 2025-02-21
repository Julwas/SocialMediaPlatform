package hospital.patterns.builder;

import hospital.model.Patient;

import java.time.LocalDate;

public class PatientBuilder {
    private Long id;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private String gender;
    private String address;
    private Long contactNumber;

    public PatientBuilder setId(Long id) {
        this.id = id;
        return this;
    }

    public PatientBuilder setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public PatientBuilder setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public PatientBuilder setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
        return this;
    }

    public PatientBuilder setGender(String gender) {
        this.gender = gender;
        return this;
    }

    public PatientBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public PatientBuilder setContactNumber(Long contactNumber) {
        this.contactNumber = contactNumber;
        return this;
    }

    public Patient build() {
        Patient patient = new Patient();
        patient.setId(this.id);
        patient.setFirstName(this.firstName);
        patient.setLastName(this.lastName);
        patient.setDateOfBirth(this.dateOfBirth);
        patient.setGender(this.gender);
        patient.setAddress(this.address);
        patient.setContactNumber(this.contactNumber);
        return patient;
    }
}
