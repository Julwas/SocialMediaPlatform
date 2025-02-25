package hospital.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import hospital.patterns.Listener.EntityListener;
import hospital.patterns.Listener.PatientListener;
import hospital.utils.LocalDateAdapter;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;

import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import java.time.LocalDate;


@XmlAccessorType(XmlAccessType.FIELD)
public class Patient {
    @JsonProperty("patients_id")
    @XmlElement(name = "patients_id")
    private Long id;

    @JsonProperty("first_name")
    @XmlElement(name = "first_name")
    private String firstName;

    @JsonProperty("last_name")
    @XmlElement(name = "last_name")
    private String lastName;

    @JsonProperty("date_of_birth")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @XmlElement(name = "date_of_birth")
    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    private LocalDate dateOfBirth;

    @JsonProperty("gender")
    @XmlElement(name = "gender")
    private String gender;

    @JsonProperty("address")
    @XmlElement(name = "address")
    private String address;

    @JsonProperty("contact_number")
    @XmlElement(name = "contact_number")
    private Long contactNumber;
    private EntityListener listener;


    public Patient(Long id, String firstName, String lastName, LocalDate dateOfBirth, String gender,
                   String address, Long contactNumber) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.address = address;
        this.contactNumber = contactNumber;
       this.listener = new PatientListener();
    }


    public Patient() {

    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
        if (listener != null) {
            listener.onUpdate(this);
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
        if (listener != null) {
            listener.onUpdate(this);
        }
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
        if (listener != null) {
            listener.onUpdate(this);
        }
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
        if (listener != null) {
            listener.onUpdate(this);
        }
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
        if (listener != null) {
            listener.onUpdate(this);
        }
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
        if (listener != null) {
            listener.onUpdate(this);
        }
    }

    public Long getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(Long contactNumber) {
        this.contactNumber = contactNumber;
        if (listener != null) {
            listener.onUpdate(this);
        }
    }
    public void create() {
        if (listener != null) {
            listener.onCreate(this);
        }
    }

    public void delete() {
        if (listener != null) {
            listener.onDelete(this);
        }
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", gender='" + gender + '\'' +
                ", address='" + address + '\'' +
                ", contactNumber=" + contactNumber +
                '}';
    }
}

