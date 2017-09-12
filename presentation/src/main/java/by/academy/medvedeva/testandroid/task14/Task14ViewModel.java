package by.academy.medvedeva.testandroid.task14;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import by.academy.medvedeva.testandroid.R;
import by.academy.medvedeva.testandroid.base.BaseViewModel;
import by.academy.medvedeva.testandroid.databinding.ActivityTask14Binding;

/**
 * Created by Medvedeva Anastasiya
 * on 11.09.2017.
 */

public class Task14ViewModel implements BaseViewModel {
        public ArrayAdapter<Country> adapter;
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

        final List<Country> countryList = convertFromJson();
        if (countryList != null) {

            ArrayAdapter<Country> adapter = new ArrayAdapter<Country>(activity, android.R.layout.simple_spinner_item, countryList);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            ActivityTask14Binding binding = DataBindingUtil.setContentView(activity, R.layout.activity_task14);
            binding.spinner.setAdapter(adapter);
            binding.spinner.setSelection(1);

        } else {
            Toast.makeText(activity, "list counties is empty", Toast.LENGTH_LONG).show();
        }


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

}
