package by.academy.medvedeva.testandroid.task7;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

import by.academy.medvedeva.testandroid.GlideApp;

/**
 * Created by Medvedeva Anastasiya
 * on 15.08.2017.
 */

public class User {
    // класс ОбсерваблФилд следит за изменениями состояния переменной
    public String photo;
    private String fullName;
    private String age;
    private String sex;


    public User(String photo, String fullName, String age, String sex) {
        this.photo = photo;
        this.fullName = fullName;
        this.age = age;
        this.sex = sex;
    }

    public User() {
    }

   // public String getPhoto() {
 //       return photo;
 //   }

    public String getFullName() {
        return fullName;
    }

    public String getAge() {
        return age;
    }

    public String getSex() {
        return sex;
    }

    @BindingAdapter("bind:src")
    public static void setPhoto(ImageView photoImage, String imageUrl) {
        GlideApp.with(photoImage.getContext()).load(imageUrl).into(photoImage);
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
