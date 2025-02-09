package hospital.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;


@XmlAccessorType(XmlAccessType.FIELD)
public class Nurse {
    @JsonProperty("nurses_id")
    @XmlElement(name = "nurses_id")
    private Long id;

    @JsonProperty("first_name")
    @XmlElement(name = "first_name")
    private String firstName;

    @JsonProperty("last_name")
    @XmlElement(name = "last_name")
    private String lastName;

    @JsonProperty("assigned_id_department")
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
