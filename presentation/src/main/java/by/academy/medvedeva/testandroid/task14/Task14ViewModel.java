package by.academy.medvedeva.testandroid.task14;

import android.app.Activity;
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
    ArrayAdapter<Country> adapter;
    List<Country> countryList;

    Task14ViewModel(Activity activity) {
        this.activity = activity;
        countryList = convertFromJson();
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
     //   countryList = convertFromJson();
    }

    @Override
    public void pause() {

    }

    private List<Country> convertFromJson() {

        List<Country> countryList = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();
        try {
            InputStream is = activity.getAssets().open("countries.json");
            countryList = mapper.readValue(is, TypeFactory.defaultInstance().constructCollectionType(ArrayList.class, Country.class));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return countryList;
    }

    private ArrayAdapter<Country> createAdapter() {
        final List<Country> countryList = convertFromJson();
        ArrayAdapter<Country> adapter = null;
        if (countryList != null) {
            adapter = new ArrayAdapter<>(activity, android.R.layout.simple_spinner_item, countryList);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        } else {
            Toast.makeText(activity, "list counties is empty", Toast.LENGTH_LONG).show();
        }
        return adapter;
    }


}
