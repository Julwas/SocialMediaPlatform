package hospital.patterns.Listener;

import hospital.model.Patient;

public class PatientListener implements EntityListener  {
    @Override
    public void onCreate(Object entity) {
        if (entity instanceof Patient) {
            Patient patient = (Patient) entity;
            System.out.println("Patient created: " + patient);
        }
    }

    @Override
    public void onUpdate(Object entity) {
        if (entity instanceof Patient) {
            Patient patient = (Patient) entity;
            System.out.println("Patient updated: " + patient);
        }
    }

    @Override
    public void onDelete(Object entity) {
        if (entity instanceof Patient) {
            Patient patient = (Patient) entity;
            System.out.println("Patient deleted: " + patient);
        }
    }
}
