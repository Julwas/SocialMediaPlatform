package hospital.service.impl;

import hospital.dao.IDepartmentDAO;
import hospital.dao.mySQL.DepartmentDAOmySQL;
import hospital.model.Department;
import hospital.service.DepartmentService;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class DepartmentServiceImpl implements DepartmentService<Department , Long> {

    private final SqlSessionFactory sqlSessionFactory;

    public DepartmentServiceImpl(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    @Override
    public void create(Department department) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            IDepartmentDAO departmentDAO = session.getMapper(IDepartmentDAO.class);
            departmentDAO.create(department);
            session.commit();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<Department> read(Long id) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            IDepartmentDAO departmentDAO = session.getMapper(IDepartmentDAO.class);
            return departmentDAO.read(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Department department) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            IDepartmentDAO departmentDAO = session.getMapper(IDepartmentDAO.class);
            departmentDAO.update(department);
            session.commit();
        }
    }

    @Override
    public void delete(Long id) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            IDepartmentDAO departmentDAO = session.getMapper(IDepartmentDAO.class);
            departmentDAO.delete(id);
            session.commit();
        }
    }

    @Override
    public List<Department> getAll() {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            IDepartmentDAO departmentDAO = session.getMapper(IDepartmentDAO.class);
            return departmentDAO.getAll();
        }
    }
    /*private final DepartmentDAOmySQL departmentDAO;

    public DepartmentServiceImpl(DepartmentDAOmySQL departmentDAO) {
        this.departmentDAO = departmentDAO;
    }

    @Override
    public void create(Department department) {
        if (department != null) {
            try {
                departmentDAO.create(department);
            } catch (java.sql.SQLException throwables) {
                throw new RuntimeException(throwables);
            }
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
    }*/
}
