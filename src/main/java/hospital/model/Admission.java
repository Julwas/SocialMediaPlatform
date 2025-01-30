package hospital.model;

import java.time.LocalDate;

public class Admission {
    private Long id;
    private Long patientId;
    private Long roomId;
    private LocalDate admissionDate;
    private LocalDate dischargeDate;

    public Admission(Long id, Long patientId, Long roomId, LocalDate admissionDate, LocalDate dischargeDate) {
        this.id = id;
        this.patientId = patientId;
        this.roomId = roomId;
        this.admissionDate = admissionDate;
        this.dischargeDate = dischargeDate;
    }

    public Admission(Long patientId, Long roomId, LocalDate admissionDate, LocalDate dischargeDate) {
        this(null, patientId, roomId, admissionDate, dischargeDate);
    }

    // Getters and setters
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

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    public LocalDate getAdmissionDate() {
        return admissionDate;
    }

    public void setAdmissionDate(LocalDate admissionDate) {
        this.admissionDate = admissionDate;
    }

    public LocalDate getDischargeDate() {
        return dischargeDate;
    }

    public void setDischargeDate(LocalDate dischargeDate) {
        this.dischargeDate = dischargeDate;
    }
}
