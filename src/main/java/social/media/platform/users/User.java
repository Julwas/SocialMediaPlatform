package social.media.platform.users;

import social.media.platform.base.SocialEntity;

public class User extends SocialEntity {
    private String username;
    private String email;
    private String surname;
    private int age;

    public User(String username, String email, String surname, int age) {
        this.username = username;
        this.email = email;
        this.surname = surname;
        this.age = age;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void displayInfo() {
        System.out.println("Username: " + username + ", surname: " + surname + ",  age:  " + age +
                ", Email: " + email);
    }
}
