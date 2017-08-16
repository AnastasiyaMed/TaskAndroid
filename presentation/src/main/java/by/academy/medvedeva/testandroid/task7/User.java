package by.academy.medvedeva.testandroid.task7;

import android.databinding.ObservableField;

/**
 * Created by Medvedeva Anastasiya
 * on 15.08.2017.
 */

public class User {
    // класс ОбсерваблФилд следит за изменениями состояния переменной
    private ObservableField<String> photo;
    private String fullName;
    private String age;
    private String sex;


    public User(ObservableField<String> photo, String fullName, String age, String sex) {
        this.photo = photo;
        this.fullName = fullName;
        this.age = age;
        this.sex = sex;
    }

    public User() {
    }

    public ObservableField<String> getPhoto() {
        return photo;
    }

    public String getFullName() {
        return fullName;
    }

    public String getAge() {
        return age;
    }

    public String getSex() {
        return sex;
    }

    public void setPhoto(ObservableField<String> photo) {
        this.photo = photo;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }


}
