package socialMediaPlatform;

public class User extends SocialEntity {
    private String username;
    private String email;
    private String surname;
    private int age;

    public User(Long id, String username, String email, String surname, int age) {
        super(id);
        this.username = username;
        this.email = email;
        this.surname = surname;
        this.age = age;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void createUser() {
        setUsername("Mary");
        setSurname("Bin");
        setEmail("m_bin@yahoo.com");
        setAge(30);
    }

    public void displayInfo() {
        System.out.println("Username: " + username + ", surname: " + surname + "age: " + age + ", Email: " + email);
    }
}
