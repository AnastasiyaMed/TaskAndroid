package by.academy.medvedeva.testandroid.task11;

import android.databinding.ObservableField;
import android.util.Log;

import by.academy.medvedeva.testandroid.base.BaseItemViewModel;
import by.it_academy.medvedeva.taskandroid.entity.ProfileModel;

/**
 * Created by Medvedeva Anastasiya
 * on 18.08.2017.
 */

public class Task11ProfileItemViewModel extends BaseItemViewModel<ProfileModel> {
    public ObservableField<String> name = new ObservableField<>("");
    @Override
    public void setItem(ProfileModel item, int position) {
        Log.e("AAA", "ITEM " + position);
        Log.e("AAA", "ITEM name " + item.getName());
        name.set(item.getName());
    }
}
