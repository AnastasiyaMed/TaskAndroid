package by.academy.medvedeva.testandroid.task13;

import android.databinding.ObservableField;
import android.databinding.ObservableInt;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import by.academy.medvedeva.testandroid.base.BaseFragmentViewModel;

/**
 * Created by Medvedeva Anastasiya
 * on 10.09.2017.
 */

public class DetailFragmentViewModel implements BaseFragmentViewModel {
    public enum STATE {PROGRESS, DATA}

    public Fragment fragment;
    public ObservableField<String> name = new ObservableField<>("");
    public ObservableField<String> surname = new ObservableField<>("");
    public ObservableField<String> updatingProfile = new ObservableField<>("");
    public ObservableInt age = new ObservableInt(0);
    public ObservableField<String> id = new ObservableField<>("");
    public ObservableField<STATE> state = new ObservableField<>(STATE.DATA);
    String profileId;

    DetailFragmentViewModel(Fragment fragment) {
        this.fragment = fragment;
    }




    @Override
    public void init() {

    }

    @Override
    public void onCreateView() {
        updatingProfile.set(fragment.getArguments().getString("UPDATE_SUCCESS"));
        profileId = fragment.getArguments().getString("ID");
        Bundle bundle = fragment.getArguments();
        if (bundle != null) {
            name.set(bundle.getString("NAME"));
            surname.set(bundle.getString("SURNAME"));
            age.set(bundle.getInt("AGE"));
            id.set(profileId);
        }
    }

    @Override
    public void onViewCreated() {
    }

    @Override
    public void release() {

    }

    @Override
    public void resume() {


    }

    @Override
    public void pause() {

    }
}
