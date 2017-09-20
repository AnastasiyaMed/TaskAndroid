package by.it_academy.medvedeva.taskandroid.interaction;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

import javax.inject.Inject;
import javax.inject.Singleton;

import by.it_academy.medvedeva.taskandroid.entity.AuthState;
import io.reactivex.Observable;
import io.reactivex.subjects.BehaviorSubject;

/**
 * Created by Medvedeva Anastasiya
 * on 19.09.2017.
 */
@Singleton
public class AuthService {
    private static final String KEY_ACCESS_TOKEN = "accessToken";
    private static final String NAME_SHARED_PREFERENCE = "sharedPref";
    private Context context;
    private BehaviorSubject<AuthState> state = BehaviorSubject.createDefault(new AuthState(false));

    @Inject
    public AuthService(Context context) {
        this.context = context;
        restoreAccessToken();
    }


    void saveAccessToken(String accessToken) {
        SharedPreferences preferences = context.getSharedPreferences(NAME_SHARED_PREFERENCE, Context.MODE_PRIVATE);
        preferences.edit().putString(KEY_ACCESS_TOKEN, accessToken).apply();
        //уведомляет всех подписчиков, которые вызвали observeState(), что пользователь залогинен
        state.onNext(new AuthState(true));
    }


    void deleteAccessToken() {
        SharedPreferences preferences = context.getSharedPreferences(NAME_SHARED_PREFERENCE, Context.MODE_PRIVATE);
        preferences.edit().remove(KEY_ACCESS_TOKEN).apply();

        //уведомляет всех подписчиков, которые вызвали observeState(), что пользователь разлогинен
        state.onNext(new AuthState(false));
    }


    private void restoreAccessToken() {
        SharedPreferences preferences = context.getSharedPreferences(NAME_SHARED_PREFERENCE, Context.MODE_PRIVATE);
        String tokenn = preferences.getString(KEY_ACCESS_TOKEN, null);

        if (!TextUtils.isEmpty(tokenn)) {
            state.onNext(new AuthState(true));
        } else {
            state.onNext(new AuthState(false));
        }
    }

    public Observable<AuthState> observState() {
        return state;
    }
}
