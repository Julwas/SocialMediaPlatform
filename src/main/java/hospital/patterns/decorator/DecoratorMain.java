package hospital.patterns.decorator;

public class DecoratorMain {
    public static void main(String[] args) {

        Doctor doctor = new DoctorImpl(1L, "Edward", "Black", "Cardiology", 101L);

        Doctor formattedDoctor = new NameFormattingDoctorDecorator(doctor);

        System.out.println(formattedDoctor);

        System.out.println("Doctor's First Name: " + formattedDoctor.getFirstName());
        System.out.println("Doctor's Last Name: " + formattedDoctor.getLastName());
    }
}
