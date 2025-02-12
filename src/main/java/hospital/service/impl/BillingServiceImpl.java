package hospital.service.impl;

import hospital.dao.IBillingDAO;
import hospital.dao.mySQL.BillingDAOmySQL;
import hospital.model.Billing;
import hospital.service.BillingService;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class BillingServiceImpl implements BillingService<Billing, Long> {

    private final SqlSessionFactory sqlSessionFactory;

    public BillingServiceImpl(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    @Override
    public void create(Billing billing) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            IBillingDAO billingDAO = session.getMapper(IBillingDAO.class);
            billingDAO.create(billing);
            session.commit();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<Billing> read(Long id) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            IBillingDAO billingDAO = session.getMapper(IBillingDAO.class);
            return billingDAO.read(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Billing billing) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            IBillingDAO billingDAO = session.getMapper(IBillingDAO.class);
            billingDAO.update(billing);
            session.commit();
        }
    }

    @Override
    public void delete(Long id) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            IBillingDAO billingDAO = session.getMapper(IBillingDAO.class);
            billingDAO.delete(id);
            session.commit();
        }
    }

    @Override
    public List<Billing> getAll() {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            IBillingDAO billingDAO = session.getMapper(IBillingDAO.class);
            return billingDAO.getAll();
        }
    }
    /*private final BillingDAOmySQL billingDAO;

    public BillingServiceImpl(BillingDAOmySQL billingDAO) {
        this.billingDAO = billingDAO;
    }

    @Override
    public void create(Billing billing) {
        if (billing != null) {
            try {
                billingDAO.create(billing);
            } catch (SQLException throwables) {
                throw new RuntimeException(throwables);
            }
        } else {
            throw new IllegalArgumentException("Billing cannot be null");
        }
    }

    @Override
    public Optional<Billing> read(Long id) throws SQLException {
        if (id != null) {
            return billingDAO.read(id);
        } else {
            throw new IllegalArgumentException("ID cannot be null");
        }
    }

    @Override
    public void update(Billing billing) {
        if (billing != null && billing.getId() != null) {
            billingDAO.update(billing);
        } else {
            throw new IllegalArgumentException("Billing or ID cannot be null");
        }
    }

    @Override
    public void delete(Long id) {
        if (id != null) {
            billingDAO.delete(id);
        } else {
            throw new IllegalArgumentException("ID cannot be null");
        }
    }

    @Override
    public List<Billing> getAll() {
        return billingDAO.findAll();
    }*/
}
