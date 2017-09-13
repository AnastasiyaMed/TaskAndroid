package by.academy.medvedeva.testandroid.task14;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
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

/**
 * Created by Medvedeva Anastasiya
 * on 11.09.2017.
 */

public class Task14ViewModel implements BaseViewModel {
    private Activity activity;
    ArrayAdapter<String> adapter;
    private List<String> countryNameList;
    public ObservableInt position = new ObservableInt(1);

    Task14ViewModel(Activity activity) {
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
        SharedPreferences pref = activity.getPreferences(Context.MODE_PRIVATE);
        position.set(pref.getInt("POSITION", 1));
    }

    @Override
    public void pause() {
        SharedPreferences.Editor editPref = activity.getPreferences(Context.MODE_PRIVATE).edit();
        editPref.putInt("POSITION", position.get()).apply();
        Log.e("TEST", String.valueOf(position.get()));
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


}
