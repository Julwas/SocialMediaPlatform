package hospital.model;

import java.time.LocalDate;

public class Prescription {
    private Long id;
    private Long patientId;
    private Long doctorId;
    private Long medicationId;
    private String dosage;
    private String frequency;
    private LocalDate startDate;
    private LocalDate endDate;

    public Prescription(Long id, Long patientId, Long doctorId, Long medicationId, String dosage, String frequency,
                        LocalDate startDate, LocalDate endDate) {
        this.id = id;
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.medicationId = medicationId;
        this.dosage = dosage;
        this.frequency = frequency;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Prescription(Long patientId, Long doctorId, Long medicationId, String dosage, String frequency, LocalDate startDate, LocalDate endDate) {
        this(null, patientId, doctorId, medicationId, dosage, frequency, startDate, endDate);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public Long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Long doctorId) {
        this.doctorId = doctorId;
    }

    public Long getMedicationId() {
        return medicationId;
    }

    public void setMedicationId(Long medicationId) {
        this.medicationId = medicationId;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
}
