package by.it_academy.medvedeva.taskandroid.entity;

/**
 * Created by Medvedeva Anastasiya
 * on 14.08.2017.
 */

public class ProfileModel implements DomainModel {

    private String name;
    private String surname;
    private int age;
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
}
