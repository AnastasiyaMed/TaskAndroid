package by.academy.medvedeva.testandroid.task15;

import android.app.Activity;
import android.content.ContextWrapper;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import by.it_academy.medvedeva.taskandroid.entity.CountryDomain;
import by.it_academy.medvedeva.taskandroid.entity.UserAndContext;
import by.it_academy.medvedeva.taskandroid.entity.UserDomain;
import by.it_academy.medvedeva.taskandroid.interaction.AddUserToDataBase;
import by.it_academy.medvedeva.taskandroid.interaction.UserListFromBDUseCase;
import io.reactivex.annotations.NonNull;
import io.reactivex.observers.DisposableObserver;

/**
 * Created by Medvedeva Anastasiya
 * on 13.09.2017.
 */

public class Task15Activity extends Activity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        AddUserToDataBase addHelper = new AddUserToDataBase();

        CountryDomain country = new CountryDomain();
        country.setName("Vaisnoria");
        UserDomain user = new UserDomain();
        user.setName("Uasia");
        user.setAge(25);
        user.setCountryDomain(country);

        UserAndContext uac = new UserAndContext(this, user);

        addHelper.execute(uac, new DisposableObserver<String>() {

            @Override
            public void onNext(@NonNull String s) {
                Log.e("AAA", s);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                Log.e("AAA", e.getMessage());
                Log.e("AAA", "FUCK THAT!");
            }

            @Override
            public void onComplete() {

            }
        });

        //List<UserDomain> userDomainList = new ArrayList<>();
        UserListFromBDUseCase userListGetter = new UserListFromBDUseCase();

        ContextWrapper contextWrapper = new ContextWrapper(getBaseContext());
        userListGetter.execute(contextWrapper, new DisposableObserver<List<UserDomain>>() {
            @Override
            public void onNext(@NonNull List<UserDomain> userDomains) {
                Log.e("AAAA", userDomains.toString());
            }

            @Override
            public void onError(@NonNull Throwable e) {
                e.getMessage();
                Log.e("AAAA", e.getMessage());
                Log.e("AAAA", "FUCK THAT TWICE!");
            }

            @Override
            public void onComplete() {

            }
        });
    }
}
