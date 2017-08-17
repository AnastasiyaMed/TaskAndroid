package by.it_academy.medvedeva.data.entity;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Medvedeva Anastasiya
 * on 14.08.2017.
 */

public class Profile implements DataModel {
    @SerializedName("name")
    private String name;
    @SerializedName("surname")
    private String surname;
    @SerializedName("age")
    private int age;

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
