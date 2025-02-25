package hospital.patterns.Listener;

import hospital.model.Admission;
import hospital.model.Patient;

import java.time.LocalDate;

public class ListenerMain {
    public static void main(String[] args) {

        Admission admission = new Admission(1L, 1L, 101L, LocalDate.now(), null);
        admission.create();
        admission.setRoomId(102L);
        admission.delete();

        Patient patient = new Patient(1L,"Laura", "Pitt",
                LocalDate.of(2017,12,12), "female",
                "120 Palm Str", 123456789L);

        patient.create();

        patient.setFirstName("Anna ");
        patient.setAddress("456 New St");
        patient.setContactNumber(987654321L);
        patient.delete();

    }
}
