package by.academy.medvedeva.testandroid.task15;

import android.app.Activity;
import android.content.ContextWrapper;
import android.content.Intent;
import android.databinding.ObservableField;
import android.util.Log;
import android.widget.Toast;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import by.academy.medvedeva.testandroid.base.BaseViewModel;
import by.academy.medvedeva.testandroid.task13.Task13ProfileAdapter;
import by.academy.medvedeva.testandroid.task13.Task13ViewModel;
import by.it_academy.medvedeva.taskandroid.entity.CountryDomain;
import by.it_academy.medvedeva.taskandroid.entity.UserDomain;
import by.it_academy.medvedeva.taskandroid.interaction.UserListFromBDUseCase;
import io.reactivex.annotations.NonNull;
import io.reactivex.observers.DisposableObserver;

/**
 * Created by Medvedeva Anastasiya
 * on 14.09.2017.
 */

public class Task15ViewModel implements BaseViewModel {
    public enum STATE {PROGRESS, DATA}

    public ObservableField<STATE> state = new ObservableField<>(STATE.PROGRESS);
    private Activity activity;
    public Task15UserAdapter adapter = new Task15UserAdapter();

    public Task15ViewModel(Activity activity) {
        this.activity = activity;
    }

    UserListFromBDUseCase userListGetter = new UserListFromBDUseCase();

    @Override
    public void init() {

    }

    @Override
    public void release() {

    }

    @Override
    public void resume() {
        // получаем лист пользователей
        ContextWrapper contextWrapper = new ContextWrapper(activity.getBaseContext());
        userListGetter.execute(contextWrapper, new DisposableObserver<List<UserDomain>>() {
            @Override
            public void onNext(@NonNull List<UserDomain> userDomains) {
                // лист стран из JSON
                List<CountryDomain> countryList = new ArrayList<>();
                ObjectMapper mapper = new ObjectMapper();
                try {
                    InputStream is = activity.getAssets().open("countries.json");
                    countryList = mapper.readValue(is, TypeFactory.defaultInstance().constructCollectionType(ArrayList.class, CountryDomain.class));
                } catch (IOException e) {
                    e.printStackTrace();
                }

                for (UserDomain userDomain : userDomains) {
// обновляем страну у пользователя
                    for (CountryDomain country : countryList) {
                        if (userDomain.getCountryDomain().getCode().equals(country.getCode())) {
                            userDomain.getCountryDomain().setName(country.getName());
                            break;
                        }
                    }

                    Log.e("AAAA", userDomain.getName());
                    Log.e("AAAA", userDomain.getCountryDomain().getName());
                    Log.e("AAAA", userDomain.getCountryDomain().getCode());
                    Log.e("AAAA", String.valueOf(userDomain.getAge()));
                    Log.e("AAAA", String.valueOf(userDomain.getId()));
                }
                adapter.setItems(userDomains);
                state.set(STATE.DATA);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                e.getMessage();
                Log.e("AAAA", e.getMessage());
                Log.e("AAAA", "FUCK THAT TWICE!");
                Toast.makeText(activity, "Users not found", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onComplete() {

            }
        });
    }


    @Override
    public void pause() {
        userListGetter.dispose();
    }

    public void onSuperButtonClick() {
        Intent intent = new Intent(activity, AddUserActivity.class);
        activity.startActivity(intent);
    }
}
