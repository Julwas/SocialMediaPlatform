package social.media.platform.users;

import social.media.platform.base.SocialEntity;
import social.media.platform.enams.Sex;
import social.media.platform.exceptions.NameContainsOfDigitException;
import social.media.platform.interfaces.Summarizable;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.logging.Logger;


public class User extends SocialEntity implements Summarizable {
    private static final Logger logger = Logger.getLogger(User.class.getName());
    protected String username;
    private String email;
    private String surname;
    private int age;
    public Set<User> friends;
    private Sex sex;

    public User(String username, String email, String surname, int age, Sex sex) {
        this.username = username;
        this.email = email;
        this.surname = surname;
        this.age = age;
        this.friends = new HashSet<>();
        this.sex = sex;
    }
    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
        logger.info("User " + username + " updated their sex to " + sex.getDescription());
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return age == user.age && Objects.equals(username, user.username) && Objects.equals(email, user.email)
                && Objects.equals(surname, user.surname) && Objects.equals(getId(), user.getId());
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + username + '\'' +
                ", email='" + email + '\'' +
                ", lastName='" + surname + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, email, surname, age, getId());
    }

    public void displayName() {
        System.out.println("" + username + " " + surname);
    }

    public static boolean containsDigits(String username) {
        for (char digit : username.toCharArray()) {
            if (Character.isDigit(digit)) {
                return true;
            }
        }
        return false;
    }

    public void addName() throws NameContainsOfDigitException {

        if (containsDigits(username)) {
            throw new NameContainsOfDigitException("The name cannot contain digits, the name has not been added");
        } else {
            System.out.println(" The name was added");
        }
    }

    @Override
    public void displaySummary() {
        sex.displaySexSalutation();
        System.out.println("Username: " + username + ", surname: " + surname + ",  age:  " + age +
                ", Email: " + email );
        sex.displaySexInfo();
    }

    public boolean isFriend(User user) {
        return friends.contains(user);
    }

    public Set<User> getFriends() {
        return friends;
    }

    public void addFriend(User friend) {
        if (friends.add(friend)) {
            friend.friends.add(this);
            logger.info("You are now friends.");
            //System.out.println(username + " and " + friend.getUsername() + " are now friends.");
        } else {
            System.out.println(username + " and " + friend.getUsername() + " are already friends.");
        }
    }
}
