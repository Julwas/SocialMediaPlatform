package hospital.patterns.factory;

import hospital.model.Department;
import hospital.model.Doctor;
import hospital.model.Nurse;

public class FactoryMain {
    public static void main(String[] args) {

        StaffFactory staffFactory = new StaffFactoryImpl();

        Department department = staffFactory.createDepartment(1L, "Cardiology", "Deals with heart-related diseases");
        Doctor doctor = staffFactory.createDoctor(101L, "John", "Smith", "Cardiologist", department.getId());
        Nurse nurse = staffFactory.createNurse(201L, "Jane", "Doe", department.getId());

        System.out.println(department);
        System.out.println(doctor);
        System.out.println(nurse);
    }
}
