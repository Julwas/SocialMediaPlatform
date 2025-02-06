package hospital.service.impl;

import hospital.dao.mySQL.DepartmentDAO;
import hospital.model.Department;
import hospital.service.DepartmentService;

import java.util.List;
import java.util.Optional;

public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentDAO departmentDAO;

    public DepartmentServiceImpl(DepartmentDAO departmentDAO) {
        this.departmentDAO = departmentDAO;
    }

    @Override
    public void addDepartment(Department department) {
        if (department != null) {
            departmentDAO.create(department);
        } else {
            throw new IllegalArgumentException("Department cannot be null");
        }
    }

    @Override
    public Optional<Department> getDepartmentById(Long id) {
        if (id != null) {
            return departmentDAO.read(id);
        } else {
            throw new IllegalArgumentException("ID cannot be null");
        }
    }

    @Override
    public void updateDepartment(Department department) {
        if (department != null && department.getId() != null) {
            departmentDAO.update(department);
        } else {
            throw new IllegalArgumentException("Department or ID cannot be null");
        }
    }

    @Override
    public void removeDepartment(Long id) {
        if (id != null) {
            departmentDAO.delete(id);
        } else {
            throw new IllegalArgumentException("ID cannot be null");
        }
    }

    @Override
    public List<Department> getAllDepartments() {
        return departmentDAO.findAll();
    }
}
