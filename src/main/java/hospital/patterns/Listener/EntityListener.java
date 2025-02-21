package hospital.patterns.Listener;

public interface EntityListener {
    void onCreate(Object entity);
    void onUpdate(Object entity);
    void onDelete(Object entity);
}
