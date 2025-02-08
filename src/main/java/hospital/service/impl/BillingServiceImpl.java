package hospital.service.impl;

import hospital.dao.mySQL.BillingDAO;
import hospital.model.Billing;
import hospital.service.BillingService;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class BillingServiceImpl implements BillingService<Billing, Long> {
    private final BillingDAO billingDAO;

    public BillingServiceImpl(BillingDAO billingDAO) {
        this.billingDAO = billingDAO;
    }

    @Override
    public void create(Billing billing) {
        if (billing != null) {
            billingDAO.create(billing);
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
    }
}
