package hospital.model;

public class Nurse {
    private Long id;
    private String firstName;
    private String lastName;
    private int experienceYears;
    private Long departmentId;

    public Nurse(Long id, String firstName, String lastName, long assignedIdDepartment) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;

        this.departmentId = departmentId;
    }

    public Nurse(String firstName, String lastName, int experienceYears, Long departmentId) {
        this(null, firstName, lastName, rs.getLong("assigned_id_department"));
    }

    // Getters and setters
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

    public int getExperienceYears() {
        return experienceYears;
    }


    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }
}
