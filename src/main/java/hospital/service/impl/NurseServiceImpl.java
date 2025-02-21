package hospital.service.impl;

import hospital.dao.INurseDAO;
import hospital.model.Nurse;
import hospital.service.NurseService;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class NurseServiceImpl implements NurseService<Nurse,Long> {
    private final SqlSessionFactory sqlSessionFactory;

    public NurseServiceImpl(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    @Override
    public Long create(Nurse nurse) {
        try (SqlSession session = sqlSessionFactory.openSession()){
            INurseDAO nurseDAO = session.getMapper(INurseDAO.class);
            nurseDAO.create(nurse);
            session.commit();
            return nurse.getId();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public Optional<Nurse> read(Long id)  {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            INurseDAO nurseDAO = session.getMapper(INurseDAO.class);
            return nurseDAO.read(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        /*@Override
        public void update(Nurse nurse){
            try (SqlSession session = sqlSessionFactory.openSession()) {
                INurseDAO nurseDAO = session.getMapper(INurseDAO.class);
                nurseDAO.update(nurse);
                session.commit();
            }
        }

        @Override
        public void delete(Long id) {
            try (SqlSession session = sqlSessionFactory.openSession()) {
                IPatientDAO patientDAO = session.getMapper(IPatientDAO.class);
                patientDAO.delete(id);
                session.commit();
            }
        }

        @Override
        public List<Patient> getAll() {
            try (SqlSession session = sqlSessionFactory.openSession()) {
                IPatientDAO patientDAO = session.getMapper(IPatientDAO.class);
                return patientDAO.findAll();
            }*/
        }

    @Override
    public void update(Nurse nurse) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            INurseDAO nurseDAO = session.getMapper(INurseDAO.class);
            nurseDAO.update(nurse);
            session.commit();
        }
    }

    @Override
    public void delete(Long id) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            INurseDAO nurseDAO = session.getMapper(INurseDAO.class);
            nurseDAO.delete(id);
            session.commit();
        }
    }

    @Override
    public List<Nurse> getAll() {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            INurseDAO nurseDAO = session.getMapper(INurseDAO.class);
            return nurseDAO.getAll();
        }
    }

    /*private final NurseDAOmySQL nurseDAO;

    public NurseServiceImpl(NurseDAOmySQL nurseDAO) {
        this.nurseDAO = nurseDAO;
    }

    @Override
    public void create(Nurse nurse) {
        if (nurse != null) {
            try {
                nurseDAO.create(nurse);
            } catch (java.sql.SQLException throwables) {
                throw new RuntimeException(throwables);
            }
        } else {
            throw new IllegalArgumentException("Nurse cannot be null");
        }
    }

    @Override
    public Optional<Nurse> read(Long id) {
        if (id != null) {
            return nurseDAO.read(id);
        } else {
            throw new IllegalArgumentException("ID cannot be null");
        }
    }

    @Override
    public void update(Nurse nurse) {
        if (nurse != null && nurse.getId() != null) {
            nurseDAO.update(nurse);
        } else {
            throw new IllegalArgumentException("Nurse or ID cannot be null");
        }
    }

    @Override
    public void delete(Long id) {
        if (id != null) {
            nurseDAO.delete(id);
        } else {
            throw new IllegalArgumentException("ID cannot be null");
        }
    }

    @Override
    public List<Nurse> getAll() {
        return nurseDAO.findAll();
    }*/
}
