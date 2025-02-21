package hospital.patterns.factory;

import hospital.model.Department;
import hospital.model.Doctor;
import hospital.model.Nurse;

public interface StaffFactory {
    Department createDepartment(Long id, String name, String description);
    Doctor createDoctor(Long id, String firstName, String lastName, String specialization, Long departmentId);
    Nurse createNurse(Long id, String firstName, String lastName, Long assignedIdDepartment);
}
