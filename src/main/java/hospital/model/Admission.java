package hospital.model;

import hospital.patterns.Listener.AdmissionListener;
import hospital.patterns.Listener.EntityListener;
import hospital.utils.LocalDateAdapter;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import java.time.LocalDate;
@XmlAccessorType(XmlAccessType.FIELD)
public class Admission {
    @XmlElement(name = "admission_id")
    private Long id;
    @XmlElement(name = "patient_id_admissions")
    private Long patientId;
    @XmlElement(name = "room_id_admissions")
    private Long roomId;
    @XmlElement(name = "admission_date")
    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    private LocalDate admissionDate;
    @XmlElement(name = "discharge_date")
    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    private LocalDate dischargeDate;
    private EntityListener listener;
    public Admission(Long id, Long patientId, Long roomId, LocalDate admissionDate, LocalDate dischargeDate) {
        this.id = id;
        this.patientId = patientId;
        this.roomId = roomId;
        this.admissionDate = admissionDate;
        this.dischargeDate = dischargeDate;
        this.listener = new AdmissionListener();
    }

    public Admission(Long patientId, Long roomId, LocalDate admissionDate, LocalDate dischargeDate) {
        this(null, patientId, roomId, admissionDate, dischargeDate);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
        if (listener != null) {
            listener.onUpdate(this);
        }
    }

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
        if (listener != null) {
            listener.onUpdate(this);
        }
    }

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
        if (listener != null) {
            listener.onUpdate(this);
        }
    }

    public LocalDate getAdmissionDate() {
        return admissionDate;
    }

    public void setAdmissionDate(LocalDate admissionDate) {
        this.admissionDate = admissionDate;
        if (listener != null) {
            listener.onUpdate(this);
        }
    }

    public LocalDate getDischargeDate() {
        return dischargeDate;
    }

    public void setDischargeDate(LocalDate dischargeDate) {
        this.dischargeDate = dischargeDate;
        if (listener != null) {
            listener.onUpdate(this);
        }
    }

    public void create() {
        if (listener != null) {
            listener.onCreate(this);
        }
    }

    public void delete() {
        if (listener != null) {
            listener.onDelete(this);
        }
    }

    @Override
    public String toString() {
        return "Admission{" +
                "id=" + id +
                ", patientId=" + patientId +
                ", roomId=" + roomId +
                ", admissionDate=" + admissionDate +
                ", dischargeDate=" + dischargeDate +
                '}';

    }
}
