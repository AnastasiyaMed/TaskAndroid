package by.academy.medvedeva.testandroid.task15;

import android.app.Activity;
import android.content.Intent;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import by.academy.medvedeva.testandroid.base.BaseViewModel;
import by.academy.medvedeva.testandroid.task14.Country;
import by.it_academy.medvedeva.taskandroid.entity.CountryDomain;
import by.it_academy.medvedeva.taskandroid.entity.UserAndContext;
import by.it_academy.medvedeva.taskandroid.entity.UserDomain;
import by.it_academy.medvedeva.taskandroid.interaction.AddUserToDataBase;
import io.reactivex.annotations.NonNull;
import io.reactivex.observers.DisposableObserver;

/**
 * Created by Medvedeva Anastasiya
 * on 15.09.2017.
 */

public class AddUserViewModel implements BaseViewModel {
    public enum STATE {PROGRESS, DATA}

    public Activity activity;
    public ObservableField<String> name = new ObservableField<>("");
    public ObservableField<String> age = new ObservableField<>("");
    ArrayAdapter<String> adapter;
    private List<String> countryNameList;
    public ObservableInt position = new ObservableInt(1);

    public ObservableField<STATE> state = new ObservableField<>(STATE.PROGRESS);
    private AddUserToDataBase addHelper = new AddUserToDataBase();

    AddUserViewModel(Activity activity) {
        this.activity = activity;
        countryNameList = convertFromJson();
        adapter = createAdapter();
    }


    @Override
    public void init() {

    }

    @Override
    public void release() {

    }

    @Override
    public void resume() {


    }

    @Override
    public void pause() {
        if (addHelper != null) {
            addHelper.dispose();
        }
    }

    private List<String> convertFromJson() {

        List<Country> countryList = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();
        try {
            InputStream is = activity.getAssets().open("countries.json");
            countryList = mapper.readValue(is, TypeFactory.defaultInstance().constructCollectionType(ArrayList.class, Country.class));
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<String> countryNameList = new ArrayList<>();
        for (Country country : countryList) {
            countryNameList.add(country.getName());
        }

        return countryNameList;
    }

    private ArrayAdapter<String> createAdapter() {
        final List<String> countryNameList = convertFromJson();
        ArrayAdapter<String> adapter = null;
        if (countryNameList != null) {
            adapter = new ArrayAdapter<>(activity, android.R.layout.simple_spinner_item, countryNameList);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        } else {
            Toast.makeText(activity, "list counties is empty", Toast.LENGTH_LONG).show();
        }
        return adapter;
    }

    public void onSuperButtonClick() {
        // лист стран из JSON
        List<CountryDomain> countryList = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();
        try {
            InputStream is = activity.getAssets().open("countries.json");
            countryList = mapper.readValue(is, TypeFactory.defaultInstance().constructCollectionType(ArrayList.class, CountryDomain.class));
        } catch (IOException e) {
            e.printStackTrace();
        }

        CountryDomain countryDomain = new CountryDomain();

        for (CountryDomain country : countryList) {
            if (countryNameList.get(position.get()).equals(country.getName())) {
                countryDomain.setName(country.getName());
                countryDomain.setCode(country.getCode());
            }
        }

        UserDomain user = new UserDomain();
        user.setName(name.get());
        user.setAge(Integer.valueOf(age.get()));
        user.setCountryDomain(countryDomain);

        UserAndContext uac = new UserAndContext(activity, user);

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
        Intent intent = new Intent(activity, Task15Activity.class);
        activity.startActivity(intent);
    }
}
