package by.academy.medvedeva.testandroid.task14;

import android.app.Activity;
import android.databinding.ObservableField;
import android.widget.ArrayAdapter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import by.academy.medvedeva.testandroid.R;
import by.academy.medvedeva.testandroid.base.BaseViewModel;

/**
 * Created by Medvedeva Anastasiya
 * on 11.09.2017.
 */

public class Task14ViewModel implements BaseViewModel {
    ArrayAdapter<Country> adapter;
    private Activity activity;

    public Task14ViewModel(Activity activity) {
        this.activity = activity;
    }


    @Override
    public void init() {

    }

    @Override
    public void release() {

    }

    @Override
    public void resume() {

        List<Country> countryList = convertFromJson();
        if (countryList != null) {
            adapter = new ArrayAdapter<Country>(activity, R.layout.activity_task14, countryList);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        }


    }

    @Override
    public void pause() {

    }

    private List<Country> convertFromJson() {

        List<Country> countryList = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();
        try {
            InputStream is = activity.getAssets().open("countries");
            countryList = mapper.readValue(is, TypeFactory.defaultInstance().constructCollectionType(ArrayList.class, Country.class));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return countryList;
    }

}
