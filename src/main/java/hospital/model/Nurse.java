package hospital.model;


import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;


@XmlAccessorType(XmlAccessType.FIELD)
public class Nurse {
    @XmlElement(name = "nurses_id")
    private Long id;
    @XmlElement(name = "first_name")
    private String firstName;
    @XmlElement(name = "last_name")
    private String lastName;
    @XmlElement(name = "assigned_id_department")
    private long assignedIdDepartment;

    public Nurse() {
    }

    public Nurse(Long id, String firstName, String lastName, long assignedIdDepartment) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;

        this.assignedIdDepartment = assignedIdDepartment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public Long getDepartmentId() {
        return assignedIdDepartment;
    }

    public void setDepartmentId(Long departmentId) {
        this.assignedIdDepartment = assignedIdDepartment;
    }

    @Override
    public String toString() {
        return "Nurse{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", assignedIdDepartment=" + assignedIdDepartment +
                '}';
    }
}
