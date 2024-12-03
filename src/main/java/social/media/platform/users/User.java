package social.media.platform.users;

import social.media.platform.base.SocialEntity;
import social.media.platform.exeptions.EmoticonNotFoundExeption;
import social.media.platform.exeptions.NameContaihsfDigitExeption;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return age == user.age && Objects.equals(username, user.username) && Objects.equals(email, user.email)
                && Objects.equals(surname, user.surname) && Objects.equals(getId(), user.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, email, surname, age, getId());
    }

    public void displayInfo() {
        System.out.println("Username: " + username + ", surname: " + surname + ",  age:  " + age +
                ", Email: " + email);
    }

    public void displayName() {
        System.out.println("" + username + " " + surname);
    }
    public static boolean containsDigits(String username){
        for (char digit: username.toCharArray()){
            if(Character.isDigit(digit)){
                return true;
            }
        }return false;
    }
    public void addName()throws NameContaihsfDigitExeption {

        if(containsDigits(username))
        {
            throw new NameContaihsfDigitExeption("The name cannot contain digits, the name has not been added");
        }else {
            System.out.println(" The name was added");
        }
    }
    /*public void userCreateProfile(){
        System.out.println(" User add name :" + username);
        try{
        addName();
        }catch (NameContaihsfDigitExeption e) {
            System.err.println(e.getMessage());
        }
        System.out.println(" User add surname :" + surname);
        System.out.println(" User add email :" + email);
        System.out.println(" User add age :" + age);
    }*/
}
