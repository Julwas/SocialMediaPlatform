package hospital.dao;

import hospital.model.Patient;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface PatientDAO {
    /*@Insert("INSERT INTO patients (first_name, last_name, date_of_birth, gender, address, contact_number) " +
            "VALUES (#{firstName}, #{lastName}, #{dateOfBirth}, #{gender}, #{address}, #{contactNumber})")
    @Options(useGeneratedKeys = true, keyProperty = "id")*/
    void insertPatient(Patient patient);

    //@Select("SELECT * FROM patients WHERE patients_id = #{id}")
    Patient getPatientById(Long id);

   /* @Update("UPDATE patients SET first_name = #{firstName}, last_name = #{lastName}, date_of_birth = #{dateOfBirth}, " +
            "gender = #{gender}, address = #{address}, contact_number = #{contactNumber} WHERE patients_id = #{id}")*/
    void updatePatient(Patient patient);

   // @Delete("DELETE FROM patients WHERE patients_id = #{id}")
    void deletePatient(Long id);

    //@Select("SELECT * FROM patients")
    List<Patient> getAllPatients();
}
