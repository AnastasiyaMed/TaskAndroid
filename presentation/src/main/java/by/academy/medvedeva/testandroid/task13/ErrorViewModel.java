package by.academy.medvedeva.testandroid.task13;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;

import by.academy.medvedeva.testandroid.base.BaseFragmentViewModel;
import by.academy.medvedeva.testandroid.main.MainActivity;

/**
 * Created by Medvedeva Anastasiya
 * on 11.09.2017.
 */

public class ErrorViewModel implements BaseFragmentViewModel {

    public Fragment fragment;

    public ErrorViewModel(Fragment fragment) {
        this.fragment = fragment;
    }

    @Override
    public void init() {

    }

    @Override
    public void onCreateView() {

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

    public void onSuperButtonClick() {
        Intent intent = new Intent(fragment.getActivity(), MainActivity.class);
        fragment.getContext().startActivity(intent);
    }
}
