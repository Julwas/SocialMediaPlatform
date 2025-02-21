package hospital.patterns.decorator;

public class NameFormattingDoctorDecorator extends DoctorDecorator {

    public NameFormattingDoctorDecorator(Doctor doctor) {
        super(doctor);
    }

    @Override
    public String getFirstName() {

        return "Dr. " + doctor.getFirstName();
    }

    @Override
    public String getLastName() {

        return doctor.getLastName().toUpperCase();
    }

    @Override
    public String toString() {

        return "Formatted " + doctor.toString();
    }
}
