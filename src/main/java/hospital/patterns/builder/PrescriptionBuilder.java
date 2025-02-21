package hospital.patterns.builder;

import hospital.model.Prescription;

import java.time.LocalDate;

public class PrescriptionBuilder {
    private Long id;
    private Long patientId;
    private Long doctorId;
    private Long medicationId;
    private String dosage;
    private String frequency;
    private LocalDate startDate;
    private LocalDate endDate;

    public PrescriptionBuilder setId(Long id) {
        this.id = id;
        return this;
    }

    public PrescriptionBuilder setPatientId(Long patientId) {
        this.patientId = patientId;
        return this;
    }

    public PrescriptionBuilder setDoctorId(Long doctorId) {
        this.doctorId = doctorId;
        return this;
    }

    public PrescriptionBuilder setMedicationId(Long medicationId) {
        this.medicationId = medicationId;
        return this;
    }

    public PrescriptionBuilder setDosage(String dosage) {
        this.dosage = dosage;
        return this;
    }

    public PrescriptionBuilder setFrequency(String frequency) {
        this.frequency = frequency;
        return this;
    }

    public PrescriptionBuilder setStartDate(LocalDate startDate) {
        this.startDate = startDate;
        return this;
    }

    public PrescriptionBuilder setEndDate(LocalDate endDate) {
        this.endDate = endDate;
        return this;
    }

    public Prescription build() {
        return new Prescription(id, patientId, doctorId, medicationId, dosage, frequency, startDate, endDate);
    }
}
