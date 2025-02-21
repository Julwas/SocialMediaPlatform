package hospital.patterns.decorator;

public interface Doctor {
    Long getId();
    String getFirstName();
    String getLastName();
    String getSpecialization();
    Long getDepartmentId();
}
