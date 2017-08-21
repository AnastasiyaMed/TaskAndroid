package by.academy.medvedeva.testandroid.classwork12;

import android.databinding.ObservableField;

import by.academy.medvedeva.testandroid.base.BaseItemViewModel;
import by.it_academy.medvedeva.taskandroid.entity.ProfileModel;

/**
 * Created by Medvedeva Anastasiya
 * on 18.08.2017.
 */

public class ProfileItemViewModel extends BaseItemViewModel<ProfileModel> {
    public ObservableField<String> name = new ObservableField<>("");

    @Override
    public void setItem(ProfileModel item, int position) {
        name.set(item.getName());
    }
}
