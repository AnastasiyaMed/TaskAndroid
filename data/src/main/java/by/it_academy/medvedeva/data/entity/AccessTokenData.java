package by.it_academy.medvedeva.data.entity;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Medvedeva Anastasiya
 * on 19.09.2017.
 */

public class AccessTokenData implements DataModel {
    @SerializedName("accsess-token")
    private String accessToken;

    public AccessTokenData() {
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }
}
