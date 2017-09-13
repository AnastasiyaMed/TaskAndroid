package by.academy.medvedeva.testandroid.task15;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import by.it_academy.medvedeva.taskandroid.entity.CountryDomain;
import by.it_academy.medvedeva.taskandroid.entity.UserAndContext;
import by.it_academy.medvedeva.taskandroid.entity.UserDomain;
import by.it_academy.medvedeva.taskandroid.interaction.AddUserToDataBase;
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
                Log.e("AAA", "SAVED SUCCESS");
            }

            @Override
            public void onError(@NonNull Throwable e) {
                Log.e("AAA", "FUCK THAT!");
            }

            @Override
            public void onComplete() {

            }
        });
    }
}
