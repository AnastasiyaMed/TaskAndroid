package by.it_academy.medvedeva.taskandroid.entity;

import android.content.Context;

/**
 * Created by Medvedeva Anastasiya
 * on 06.09.2017.
 */

public class UserAndContext {
    private Context context;
    private User user;

    public Context getContext() {
        return context;
    }

    public User getUser() {
        return user;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
