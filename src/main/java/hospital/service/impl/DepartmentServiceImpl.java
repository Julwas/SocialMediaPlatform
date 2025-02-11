package hospital.service.impl;

import hospital.dao.mySQL.DepartmentDAOmySQL;
import hospital.model.Department;
import hospital.service.DepartmentService;

import java.util.List;
import java.util.Optional;

public class DepartmentServiceImpl implements DepartmentService<Department , Long> {
    private final DepartmentDAOmySQL departmentDAO;

    public DepartmentServiceImpl(DepartmentDAOmySQL departmentDAO) {
        this.departmentDAO = departmentDAO;
    }

    @Override
    public void create(Department department) {
        if (department != null) {
            departmentDAO.create(department);
        } else {
            throw new IllegalArgumentException("Department cannot be null");
        }
    }

    @Override
    public Optional <Department> read(Long id) {
            return departmentDAO.read(id);

    }

    @Override
    public void update(Department department) {
            departmentDAO.update(department);

    }

    @Override
    public void delete(Long id) {
        if (id != null) {
            departmentDAO.delete(id);
        } else {
            throw new IllegalArgumentException("ID cannot be null");
        }
    }

    @Override
    public List<Department> getAll() {
        return departmentDAO.findAll();
    }
}
