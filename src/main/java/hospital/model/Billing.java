package hospital.model;

public class Billing {
    private Long id;
    private Long patientId;
    private Double amount;
    private String billingDate;
    private Boolean paid;

    public Billing(Long id, Long patientId, Double amount, String billingDate, Boolean paid) {
        this.id = id;
        this.patientId = patientId;
        this.amount = amount;
        this.billingDate = billingDate;
        this.paid = paid;
    }

    public Billing(Long patientId, Double amount, String billingDate, Boolean paid) {
        this(null, patientId, amount, billingDate, paid);
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

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getBillingDate() {
        return billingDate;
    }

    public void setBillingDate(String billingDate) {
        this.billingDate = billingDate;
    }

    public Boolean getPaid() {
        return paid;
    }

    public void setPaid(Boolean paid) {
        this.paid = paid;
    }
}
