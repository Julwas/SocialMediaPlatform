package hospital.patterns.decorator;

public abstract class DoctorDecorator implements Doctor {
    protected Doctor doctor;

    public DoctorDecorator(Doctor doctor) {
        this.doctor = doctor;
    }

    @Override
    public Long getId() {
        return doctor.getId();
    }

    @Override
    public String getFirstName() {
        return doctor.getFirstName();
    }

    @Override
    public String getLastName() {
        return doctor.getLastName();
    }

    @Override
    public String getSpecialization() {
        return doctor.getSpecialization();
    }

    @Override
    public Long getDepartmentId() {
        return doctor.getDepartmentId();
    }

    @Override
    public String toString() {
        return doctor.toString();
    }
}
