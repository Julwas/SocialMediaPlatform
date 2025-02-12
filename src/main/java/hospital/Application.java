package hospital;

import hospital.model.Patient;
import hospital.service.impl.PatientServiceImpl;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


import java.io.IOException;
import java.io.Reader;
import java.time.LocalDate;


public class Application {
    public static void main(String[] args) {
        try {

            Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);

            PatientServiceImpl patientService = new PatientServiceImpl(sqlSessionFactory);

            // Example of working with a Patient
            Patient patient = new Patient();
            patient.setFirstName("John");
            patient.setLastName("Doe");
            patient.setDateOfBirth(LocalDate.parse("1990-01-01"));
            patient.setGender("Male");
            patient.setAddress("123 Main St");
            patient.setContactNumber(123456789L);

            patientService.create(patient);
            System.out.println("Added patient: " + patientService.read(patient.getId()));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    }

