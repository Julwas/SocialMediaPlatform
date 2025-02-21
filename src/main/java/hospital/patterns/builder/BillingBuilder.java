package hospital.patterns.builder;

import hospital.model.Billing;

import java.sql.Date;

public class BillingBuilder {
    private Long id;
    private Long patientId;
    private Long admissionId;
    private Boolean totalAmount;
    private Boolean paidAmount;
    private Date billingDate;
    private Boolean paymentStatus;
    private Long labtestId;

    public BillingBuilder setId(Long id) {
        this.id = id;
        return this;
    }

    public BillingBuilder setPatientId(Long patientId) {
        this.patientId = patientId;
        return this;
    }

    public BillingBuilder setAdmissionId(Long admissionId) {
        this.admissionId = admissionId;
        return this;
    }

    public BillingBuilder setTotalAmount(Boolean totalAmount) {
        this.totalAmount = totalAmount;
        return this;
    }

    public BillingBuilder setPaidAmount(Boolean paidAmount) {
        this.paidAmount = paidAmount;
        return this;
    }

    public BillingBuilder setBillingDate(Date billingDate) {
        this.billingDate = billingDate;
        return this;
    }

    public BillingBuilder setPaymentStatus(Boolean paymentStatus) {
        this.paymentStatus = paymentStatus;
        return this;
    }

    public BillingBuilder setLabtestId(Long labtestId) {
        this.labtestId = labtestId;
        return this;
    }

    public Billing build() {
        return new Billing(id, patientId, admissionId, totalAmount, paidAmount, billingDate, paymentStatus, labtestId);
    }
}
