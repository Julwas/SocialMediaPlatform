package hospital.model;


import java.sql.Date;

public class TestResult {
    private Long id;
    private Long labTestId;
    private Long patientId;
    private Long doctorId;
    private String result;
    private Date date;

    public TestResult(Long id, Long labTestId, Long patientId,Long doctorId, String result, Date date) {
        this.id = id;
        this.labTestId = labTestId;
        this.patientId = patientId;
        this.result = result;
        this.date = date;
        this.doctorId = doctorId;
    }

    public TestResult(Long labTestId, Long patientId,Long doctorId, String result, Date date) {
        this(null, labTestId, patientId,doctorId, result, date);
    }

    public Long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Long doctorId) {
        this.doctorId = doctorId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getLabTestId() {
        return labTestId;
    }

    public void setLabTestId(Long labTestId) {
        this.labTestId = labTestId;
    }

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    @Override
    public String toString() {
        return "TestResult{" +
                "id=" + id +
                ", labTestId=" + labTestId +
                ", patientId=" + patientId +
                ", doctorId=" + doctorId +
                ", result='" + result + '\'' +
                ", date=" + date +
                '}';
    }
}
