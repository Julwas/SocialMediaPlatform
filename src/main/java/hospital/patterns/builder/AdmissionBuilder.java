package hospital.patterns.builder;

import hospital.model.Admission;;

import java.time.LocalDate;

public class AdmissionBuilder {
    private Long id;
    private Long patientId;
    private Long roomId;
    private LocalDate admissionDate;
    private LocalDate dischargeDate;

    public AdmissionBuilder setId(Long id) {
        this.id = id;
        return this;
    }

    public AdmissionBuilder setPatientId(Long patientId) {
        this.patientId = patientId;
        return this;
    }

    public AdmissionBuilder setRoomId(Long roomId) {
        this.roomId = roomId;
        return this;
    }

    public AdmissionBuilder setAdmissionDate(LocalDate admissionDate) {
        this.admissionDate = admissionDate;
        return this;
    }

    public AdmissionBuilder setDischargeDate(LocalDate dischargeDate) {
        this.dischargeDate = dischargeDate;
        return this;
    }

    public Admission build() {
        return new Admission(id, patientId, roomId, admissionDate, dischargeDate);
    }


}
