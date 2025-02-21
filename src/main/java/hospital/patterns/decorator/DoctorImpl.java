package hospital.patterns.decorator;

public class DoctorImpl implements Doctor {
    private Long id;
    private String firstName;
    private String lastName;
    private String specialization;
    private Long departmentId;

    public DoctorImpl(Long id, String firstName, String lastName, String specialization, Long departmentId) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.specialization = specialization;
        this.departmentId = departmentId;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    @Override
    public String getSpecialization() {
        return specialization;
    }

    @Override
    public Long getDepartmentId() {
        return departmentId;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", specialization='" + specialization + '\'' +
                ", departmentId=" + departmentId +
                '}';
    }
}
