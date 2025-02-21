package hospital.patterns.factory;

import hospital.model.Department;
import hospital.model.Doctor;
import hospital.model.Nurse;

public class StaffFactoryImpl implements StaffFactory{
    @Override
    public Department createDepartment(Long id, String name, String description) {
        return new Department(id, name, description);
    }

    @Override
    public Doctor createDoctor(Long id, String firstName, String lastName, String specialization, Long departmentId) {
        return new Doctor(id, firstName, lastName, specialization, departmentId);
    }

    @Override
    public Nurse createNurse(Long id, String firstName, String lastName, Long assignedIdDepartment) {
        return new Nurse(id, firstName, lastName, assignedIdDepartment);
    }
}
