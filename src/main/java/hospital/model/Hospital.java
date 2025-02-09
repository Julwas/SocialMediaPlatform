package hospital.model;

import jakarta.xml.bind.annotation.*;

import java.util.List;

@XmlRootElement(name ="hospital")
@XmlAccessorType(XmlAccessType.FIELD)

public class Hospital {
    @XmlElementWrapper(name="patients")
    @XmlElement(name = "patient")
    private List<Patient> patients;
    @XmlElementWrapper(name="nurses")
    @XmlElement(name = "nurse")
    private List<Nurse> nurses;
    @XmlElementWrapper(name="departments")
    @XmlElement(name = "department")
    private List<Department> departments;
    @XmlElementWrapper(name="medications")
    @XmlElement(name = "medication")
    private List<Medication> medications;
    @XmlElementWrapper(name="labTests")
    @XmlElement(name = "labTest")
    private List<LabTest> labTests;

    public List<Patient> getPatients() {
        return patients;
    }

    public void setPatients(List<Patient> patients) {
        this.patients = patients;
    }

    public List<Nurse> getNurses() {
        return nurses;
    }

    public void setNurses(List<Nurse> nurses) {
        this.nurses = nurses;
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }

    public List<Medication> getMedications() {
        return medications;
    }

    public void setMedications(List<Medication> medications) {
        this.medications = medications;
    }

    public List<LabTest> getLabTests() {
        return labTests;
    }

    public void setLabTests(List<LabTest> labTests) {
        this.labTests = labTests;
    }
}
