package hospital.model;

public class Nurse {
    private  long assignedIdDepartment;
    private Long id;
    private String firstName;
    private String lastName;



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
