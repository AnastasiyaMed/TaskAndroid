package by.it_academy.medvedeva.taskandroid.entity;

import android.content.Context;

/**
 * Created by Medvedeva Anastasiya
 * on 06.09.2017.
 */

public class UserAndContext {
    private Context context;
    private UserDomain userDomain;

    public UserAndContext(Context context, UserDomain userDomain) {
        this.context = context;
        this.userDomain = userDomain;
    }

    public Context getContext() {
        return context;
    }

    public UserDomain getUserDomain() {
        return userDomain;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public void setUserDomain(UserDomain userDomain) {
        this.userDomain = userDomain;
    }
}
