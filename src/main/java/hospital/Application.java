package hospital;


import hospital.model.Admission;
import hospital.model.Patient;

import hospital.patterns.builder.AdmissionBuilder;
import hospital.patterns.builder.PatientBuilder;
import hospital.service.AdmissionService;
import hospital.service.PatientService;

import hospital.service.impl.AdmissionServiceImpl;
import hospital.service.impl.PatientServiceImpl;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


public class Application {
    public static void main(String[] args) {

        try {

            Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            PatientService<Patient, Long> patientService = new PatientServiceImpl(sqlSessionFactory);
            AdmissionService<Admission, Long> admissionService = new AdmissionServiceImpl(sqlSessionFactory); // Добавил сервис для Admission


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


            Admission admission = new AdmissionBuilder()
                    .setPatientId(patient.getId())
                    .setRoomId(2L) // Используем roomId вместо doctorName и diagnosis
                    .setAdmissionDate(LocalDate.parse("2025-02-21"))
                    .setDischargeDate(LocalDate.parse("2025-02-28"))
                    .build();

            admissionService.create(admission);
            System.out.println("Added admission: " + admission);


            Optional<Admission> fetchedAdmission = admissionService.read(admission.getId());
            fetchedAdmission.ifPresent(a -> System.out.println("Fetched admission: " + a));


            fetchedAdmission.ifPresent(a -> {
                Admission updatedAdmission = new AdmissionBuilder()
                        .setId(a.getId())
                        .setPatientId(a.getPatientId())
                        .setRoomId(3L)
                        .setAdmissionDate(a.getAdmissionDate())
                        .setDischargeDate(LocalDate.parse("2025-03-05"))
                        .build();

                admissionService.update(updatedAdmission);
                try {
                    Optional<Admission> result = admissionService.read(updatedAdmission.getId());
                    result.ifPresent(up -> System.out.println("Updated admission: " + up));
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            });


            List<Admission> allAdmissions = admissionService.getAll();
            System.out.println("All admissions: " + allAdmissions);


            fetchedAdmission.ifPresent(a -> {
                admissionService.delete(a.getId());
                System.out.println("Deleted admission with ID: " + a.getId());
            });


            allAdmissions = admissionService.getAll();
            System.out.println("All admissions after deletion: " + allAdmissions);

        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
    }
}