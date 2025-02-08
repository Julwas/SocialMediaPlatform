package hospital.model;

import java.sql.Date;

public class Billing {
    private Long id;
    private Long patientId;
    private Long admissionId;
    private Boolean totalAmount;
    private Boolean paidAmount;
    private Date billingDate;
    private Boolean paymentStatus;
    private Long labtestId;

    public Billing(Long id, Long patientId, Long admissionId, boolean totalAmount, boolean paidAmount,
                   Date billingDate, Boolean paymentStatus, Long labtestId) {
        this.id = id;
        this.patientId = patientId;
        this.admissionId = admissionId;
        this.totalAmount = totalAmount;
        this.paidAmount = paidAmount;
        this.billingDate = billingDate;
        this.paymentStatus = paymentStatus;
        this.labtestId = labtestId;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }



    public Date getBillingDate() {
        return billingDate;
    }

    public void setBillingDate(Date billingDate) {
        this.billingDate = billingDate;
    }

    public Long getAdmissionId() {
        return admissionId;
    }

    public void setAdmissionId(Long admissionId) {
        this.admissionId = admissionId;
    }

    public Boolean getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Boolean totalAmount) {
        this.totalAmount = totalAmount;
    }

    public boolean getPaidAmount() {
        return paidAmount;
    }

    public void setPaidAmount(Boolean paidAmount) {
        this.paidAmount = paidAmount;
    }

    public Boolean getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(Boolean paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public Long getLabtestId() {
        return labtestId;
    }

    public void setLabtestId(Long labtestId) {
        this.labtestId = labtestId;
    }
}
