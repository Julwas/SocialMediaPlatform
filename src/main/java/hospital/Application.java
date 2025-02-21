package hospital;


import hospital.model.Admission;
import hospital.model.Patient;

import hospital.service.PatientService;

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

            //
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

            //
            Optional<Patient> fetchedPatient = patientService.read(patient.getId());
            fetchedPatient.ifPresent(p -> System.out.println("Fetched patient: " + p));

            //
            fetchedPatient.ifPresent(p -> {
                Patient updatedPatient = new PatientBuilder()
                        .setId(p.getId())
                        .setFirstName(p.getFirstName())
                        .setLastName(p.getLastName())
                        .setDateOfBirth(p.getDateOfBirth())
                        .setGender(p.getGender())
                        .setAddress("456 Elm St")
                        .setContactNumber(987654321L)
                        .build();

                patientService.update(updatedPatient);
                try {
                    Optional<Patient> result = patientService.read(updatedPatient.getId());
                    result.ifPresent(up -> System.out.println("Updated patient: " + up));
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            });

            //
            List<Patient> allPatients = patientService.getAll();
            System.out.println("All patients: " + allPatients);

            //
            fetchedPatient.ifPresent(p -> {
                patientService.delete(p.getId());
                System.out.println("Deleted patient with ID: " + p.getId());
            });


            allPatients = patientService.getAll();
            System.out.println("All patients after deletion: " + allPatients);

        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
    }
}

