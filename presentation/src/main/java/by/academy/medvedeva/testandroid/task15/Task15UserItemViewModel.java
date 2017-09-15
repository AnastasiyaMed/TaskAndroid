package by.academy.medvedeva.testandroid.task15;

import android.databinding.ObservableField;
import android.databinding.ObservableInt;
import android.util.Log;

import by.academy.medvedeva.testandroid.base.BaseItemViewModel;
import by.it_academy.medvedeva.taskandroid.entity.UserDomain;

/**
 * Created by Medvedeva Anastasiya
 * on 15.09.2017.
 */

public class Task15UserItemViewModel extends BaseItemViewModel<UserDomain> {
    public ObservableField<String> name = new ObservableField<>("");
    public ObservableInt age = new ObservableInt(0);
    public ObservableField<String> country = new ObservableField<>("");


    @Override
    public void setItem(UserDomain item, int position) {
        Log.e("AAA", "ITEM " + position);
        Log.e("AAA", "ITEM name " + item.getName());
        name.set(item.getName());
        age.set(item.getAge());
        country.set(item.getCountryDomain().getName());
    }
}
