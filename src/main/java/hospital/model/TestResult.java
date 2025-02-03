package hospital.model;

import javax.xml.crypto.Data;

public class TestResult {
    private Long id;
    private Long labTestId;
    private Long patientId;
    private String result;
    private String date;

    public TestResult(Long id, Long labTestId, Long patientId, String result, String date) {
        this.id = id;
        this.labTestId = labTestId;
        this.patientId = patientId;
        this.result = result;
        this.date = date;
    }

    public TestResult(Long labTestId, Long patientId, String result, String date) {
        this(null, labTestId, patientId, result, date);
    }

    // Getters and setters
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
