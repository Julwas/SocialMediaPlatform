package social.media.platform.enams;

public enum Sex {
    MALE("Male", "Mr."),
    FEMALE("Female", "Ms."),
    OTHER("Other", "Mx.");

    private final String description;
    private final String salutation;

    Sex(String description, String salutation) {
        this.description = description;
        this.salutation = salutation;
    }

    public String getDescription() {
        return description;
    }

    public String getSalutation() {
        return salutation;
    }

    public void displaySexInfo() {
        System.out.println("Sex: " + description);
    }

    public void displaySexSalutation() {

        System.out.println("Salutation: " + salutation);
    }

    static {
        System.out.println("Sex Enum Initialized");
    }
}
