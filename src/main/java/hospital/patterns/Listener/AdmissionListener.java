package hospital.patterns.Listener;

import hospital.model.Admission;

public class AdmissionListener implements EntityListener{
    @Override
    public void onCreate(Object entity) {
        if (entity instanceof Admission) {
            Admission admission = (Admission) entity;
            System.out.println("Admission created: " + admission);
        }
    }

    @Override
    public void onUpdate(Object entity) {
        if (entity instanceof Admission) {
            Admission admission = (Admission) entity;
            System.out.println("Admission updated: " + admission);
        }
    }

    @Override
    public void onDelete(Object entity) {
        if (entity instanceof Admission) {
            Admission admission = (Admission) entity;
            System.out.println("Admission deleted: " + admission);
        }
    }
}
