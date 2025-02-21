package hospital.patterns.facade;

import hospital.model.Admission;
import hospital.model.Patient;
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

public class mainFacade {
    public static void main(String[] args) {
        try {
            // Инициализация MyBatis
            Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);

            // Создаем сервисы
            PatientServiceImpl patientService = new PatientServiceImpl(sqlSessionFactory);
            AdmissionServiceImpl admissionService = new AdmissionServiceImpl(sqlSessionFactory);

            // Создаем фасад
            HospitalFacade hospitalFacade = new HospitalFacade(patientService, admissionService);

            // 1. Регистрация пациента
            Patient patient = hospitalFacade.registerPatient("John", "Doe", LocalDate.of(1990, 1, 1), "Male", "123 Main St", 123456789L);

            // 2. Госпитализация пациента
            Admission admission = hospitalFacade.admitPatient(patient.getId(), 101L, LocalDate.now());

            // 3. Получение всех пациентов и госпитализаций
            List<Patient> allPatients = hospitalFacade.getAllPatients();
            List<Admission> allAdmissions = hospitalFacade.getAllAdmissions();
            System.out.println("All Patients: " + allPatients);
            System.out.println("All Admissions: " + allAdmissions);

            // 4. Выписка пациента
            hospitalFacade.dischargePatient(admission.getId(), LocalDate.now().plusDays(7));

            // 5. Удаление пациента
            hospitalFacade.removePatient(patient.getId());

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
