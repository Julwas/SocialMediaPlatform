package hospital.service;

import hospital.model.Billing;

import java.util.List;
import java.util.Optional;

public interface BillingService {
    void addBilling(Billing billing);
    Optional<Billing> getBillingById(Long id);
    void updateBilling(Billing billing);
    void removeBilling(Long id);
    List<Billing> getAllBillings();
}
