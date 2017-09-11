package by.academy.medvedeva.testandroid.task14;

import android.app.Activity;
import android.widget.ArrayAdapter;

import java.util.List;

import by.academy.medvedeva.testandroid.base.BaseViewModel;

/**
 * Created by Medvedeva Anastasiya
 * on 11.09.2017.
 */

public class Task14ViewModel implements BaseViewModel {
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

     //   ArrayAdapter <Country> adapter =



    }

    @Override
    public void pause() {

    }

    private List<Country> convertFromJson(){
        return null;
    }

}
