package by.it_academy.medvedeva.data.entity;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Medvedeva Anastasiya
 * on 19.09.2017.
 */

public class RegisterData implements DataModel {
    @SerializedName("username")
    private String name;
    @SerializedName("password")
    private String password;

    public RegisterData() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
