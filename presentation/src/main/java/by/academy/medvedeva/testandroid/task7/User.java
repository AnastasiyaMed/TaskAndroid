package by.academy.medvedeva.testandroid.task7;

/**
 * Created by Medvedeva Anastasiya
 * on 17.08.2017.
 */

public class User {
    private String photo;
    private String fullName;
    private int age;
    private String sex;

    public User() {
    }

    public User(String photo, String fullName, int age, String sex) {
        this.photo = photo;
        this.fullName = fullName;
        this.age = age;
        this.sex = sex;
    }

    public String getPhoto() {
        return photo;
    }

    public String getFullName() {
        return fullName;
    }

    public int getAge() {
        return age;
    }

    public String getSex() {
        return sex;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
