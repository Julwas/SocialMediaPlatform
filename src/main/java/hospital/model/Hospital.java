package hospital.model;

import jakarta.xml.bind.annotation.*;

import java.util.List;

@XmlRootElement(name = "hospital")
@XmlAccessorType(XmlAccessType.FIELD)

public class Hospital {
    @XmlElementWrapper(name = "patients")
    @XmlElement(name = "patient")
    private List<Patient> patients;
    @XmlElementWrapper(name = "nurses")
    @XmlElement(name = "nurse")
    private List<Nurse> nurses;
    @XmlElementWrapper(name = "departments")
    @XmlElement(name = "department")
    private List<Department> departments;
    @XmlElementWrapper(name = "medications")
    @XmlElement(name = "medication")
    private List<Medication> medications;
    @XmlElementWrapper(name = "labTests")
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Hospital Data:\n");
        sb.append("Patients:\n");
        if (patients != null && !patients.isEmpty()) {
            patients.forEach(patient -> sb.append("  - ")
                    .append(patient.getFirstName()).append(" ").append(patient.getLastName()).append("\n"));
        } else {
            sb.append("  No patients found.\n");
        }
        sb.append("Nurses:\n");
        if (nurses != null && !nurses.isEmpty()) {
            nurses.forEach(nurse -> sb.append("  - ")
                    .append(nurse.getFirstName()).append(" ").append(nurse.getLastName()).append(" (Department ID: ")
                    .append(nurse.getDepartmentId()).append(")\n"));
        } else {
            sb.append("  No nurses found.\n");
        }
        sb.append("Departments:\n");
        if (departments != null && !departments.isEmpty()) {
            departments.forEach(department -> sb.append("  - ID: ")
                    .append(department.getId()).append(", Name: ").append(department.getName()).append(", Description: ")
                    .append(department.getDescription()).append("\n"));
        } else {
            sb.append("  No departments found.\n");
        }
        sb.append("Medications:\n");
        if (medications != null && !medications.isEmpty()) {
            medications.forEach(medication -> sb.append("  - ID: ")
                    .append(medication.getId()).append(", Name: ").append(medication.getName()).append(", Description: ")
                    .append(medication.getDescription()).append("\n"));
        } else {
            sb.append("  No medications found.\n");
        }
        sb.append("Lab Tests:\n");
        if (labTests != null && !labTests.isEmpty()) {
            labTests.forEach(labTest -> sb.append("  - ID: ")
                    .append(labTest.getId()).append(", Name: ").append(labTest.getName()).append(", Cost: ")
                    .append(labTest.getCost()).append("\n"));
        } else {
            sb.append("  No lab tests found.\n");
        }
        return sb.toString();
    }
}
