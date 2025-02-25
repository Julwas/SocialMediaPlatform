package hospital.patterns.builder;

import hospital.model.*;
import hospital.service.*;
import hospital.service.impl.*;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


public class AplicMain {
    public static void main(String[] args) {
     try{

        Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);

        // Сервисы для Patient, Admission, TestResult, Billing, Prescription
        PatientService<Patient, Long> patientService = new PatientServiceImpl(sqlSessionFactory);
        AdmissionService<Admission, Long> admissionService = new AdmissionServiceImpl(sqlSessionFactory);
        TestResultService<TestResult, Long> testResultService = new TestResultServiceImpl(sqlSessionFactory);
        BillingService<Billing, Long> billingService = new BillingServiceImpl(sqlSessionFactory);
        PrescriptionService<Prescription, Long> prescriptionService = new PrescriptionServiceImpl(sqlSessionFactory);

        // Создание пациента
        Patient patient = new PatientBuilder()
                .setFirstName("John")
                .setLastName("Doe")
                .setDateOfBirth(LocalDate.parse("1990-01-01"))
                .setGender("Male")
                .setAddress("123 Main St")
                .setContactNumber(123456789L)
                .build();
        patientService.create(patient);
        System.out.println("Added patient: " + patient);

        // Создание Admission для пациента
        Admission admission = new AdmissionBuilder()
                .setPatientId(patient.getId())
                .setRoomId(2L)
                .setAdmissionDate(LocalDate.parse("2025-02-21"))
                .setDischargeDate(LocalDate.parse("2025-02-28"))
                .build();
        admissionService.create(admission);
        System.out.println("Added admission: " + admission);

        // Пример использования TestResult
        TestResult testResult = new TestResultBuilder()
                .setLabTestId(2L)
                .setPatientId(patient.getId())
                .setDoctorId(2002L)
                .setResult("Positive")
                .setDate(Date.valueOf(LocalDate.parse("2025-02-21")))
                .build();
        testResultService.create(testResult);
        System.out.println("Added test result: " + testResult);

        // Пример использования Billing
        Billing billing = new BillingBuilder()
                .setPatientId(patient.getId())
                .setAdmissionId(admission.getId())
                .setTotalAmount(true)
                .setPaidAmount(true)
                .setBillingDate(Date.valueOf(LocalDate.parse("2025-02-21")))
                .setPaymentStatus(true)
                .setLabtestId(2L)
                .build();
        billingService.create(billing);
        System.out.println("Added billing: " + billing);

        /*/ Пример использования Prescription
        Prescription prescription = new PrescriptionBuilder()
                .setPatientId(patient.getId())
                .setDoctorId(2002L)
                .setMedicationId(12L)
                .setDosage("1 tablet")
                .setFrequency("Twice a day")
                .setStartDate(LocalDate.parse("2025-02-21"))
                .setEndDate(LocalDate.parse("2025-03-21"))
                .build();
        prescriptionService.create(prescription);
        System.out.println("Added prescription: " + prescription);*/

        // Прочитать все Admissions, TestResults, Billing и Prescription
        List<Admission> allAdmissions = admissionService.getAll();
        System.out.println("All admissions: " + allAdmissions);

        List<TestResult> allTestResults = testResultService.getAll();
        System.out.println("All test results: " + allTestResults);

        List<Billing> allBillings = billingService.getAll();
        System.out.println("All billings: " + allBillings);

        /*List<Prescription> allPrescriptions = prescriptionService.getAll();
        System.out.println("All prescriptions: " + allPrescriptions);*/

         Optional<Patient> fetchedPatient = patientService.read(patient.getId());
         fetchedPatient.ifPresent(p -> System.out.println("Fetched patient: " + p));

         Optional<Admission> fetchedAdmission = admissionService.read(admission.getId());
         fetchedAdmission.ifPresent(a -> System.out.println("Fetched admission: " + a));

        // Удаление admission, billing, test result и prescription (например, по ID)
        fetchedAdmission.ifPresent(a -> {
            admissionService.delete(a.getId());
            System.out.println("Deleted admission with ID: " + a.getId());
        });

        fetchedPatient.ifPresent(p -> {
            patientService.delete(p.getId());
            System.out.println("Deleted patient with ID: " + p.getId());
        });

    } catch (IOException | SQLException e) {
        e.printStackTrace();
    }
}
}
