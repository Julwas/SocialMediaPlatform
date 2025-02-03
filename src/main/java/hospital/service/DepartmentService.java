package hospital.service;

import hospital.model.Department;

import java.util.List;
import java.util.Optional;

public interface DepartmentService {
    void addDepartment(Department department);
    Optional<Department> getDepartmentById(Long id);
    void updateDepartment(Department department);
    void removeDepartment(Long id);
    List<Department> getAllDepartments();
}
