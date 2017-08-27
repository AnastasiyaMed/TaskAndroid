package by.academy.medvedeva.testandroid.classwork12;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import by.academy.medvedeva.testandroid.base.BaseAdapter;
import by.it_academy.medvedeva.taskandroid.entity.ProfileModel;


/**
 * Created by Medvedeva Anastasiya
 * on 18.08.2017.
 */

public class ProfileAdapter extends BaseAdapter<ProfileModel, ProfileItemViewModel> {


    @Override
    public ProfileItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ProfileItemViewModel itemViewModel = new ProfileItemViewModel();
        return ProfileItemViewHolder.create(LayoutInflater.from(parent.getContext()),
                parent, itemViewModel);
    }

}
