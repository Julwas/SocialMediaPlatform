package hospital.model;

public class Doctor {
    private Long id;
    private String firstName;
    private String lastName;
    private String specialization;
    private int experienceYears;
    private Long departmentId;

    public Doctor(Long id, String firstName, String lastName, String specialization, int experienceYears, Long departmentId) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.specialization = specialization;
        this.experienceYears = experienceYears;
        this.departmentId = departmentId;
    }

    public Doctor(String firstName, String lastName, String specialization, int experienceYears, Long departmentId) {
        this(null, firstName, lastName, specialization, experienceYears, departmentId);
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

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public int getExperienceYears() {
        return experienceYears;
    }

    public void setExperienceYears(int experienceYears) {
        this.experienceYears = experienceYears;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }
}
