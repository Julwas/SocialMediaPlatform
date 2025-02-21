package hospital.patterns.builder;

import hospital.model.TestResult;

import java.sql.Date;

public class TestResultBuilder {
    private Long id;
    private Long labTestId;
    private Long patientId;
    private Long doctorId;
    private String result;
    private Date date;

    public TestResultBuilder setId(Long id) {
        this.id = id;
        return this;
    }

    public TestResultBuilder setLabTestId(Long labTestId) {
        this.labTestId = labTestId;
        return this;
    }

    public TestResultBuilder setPatientId(Long patientId) {
        this.patientId = patientId;
        return this;
    }

    public TestResultBuilder setDoctorId(Long doctorId) {
        this.doctorId = doctorId;
        return this;
    }

    public TestResultBuilder setResult(String result) {
        this.result = result;
        return this;
    }


    public TestResultBuilder setDate(Date date) {
        this.date = date;
        return this;
    }

    public TestResult build() {
        return new TestResult(id, labTestId, patientId, doctorId, result, date);
    }
}
