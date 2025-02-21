package hospital.patterns.Listener;

import hospital.model.Admission;

import java.time.LocalDate;

public class ListenerMain {
    public static void main(String[] args) {

        Admission admission = new Admission(1L, 1L, 101L, LocalDate.now(), null);
        admission.create();
        admission.setRoomId(102L);
        admission.delete();
    }
}
