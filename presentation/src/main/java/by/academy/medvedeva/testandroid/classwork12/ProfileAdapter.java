package by.academy.medvedeva.testandroid.classwork12;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import by.academy.medvedeva.testandroid.base.BaseAdapter;
import by.academy.medvedeva.testandroid.base.BaseItemViewHolder;
import by.it_academy.medvedeva.taskandroid.entity.ProfileModel;


/**
 * Created by Medvedeva Anastasiya
 * on 18.08.2017.
 */

public class ProfileAdapter extends BaseAdapter<ProfileModel, ProfileItemViewModel> {

    private Context context;

    public ProfileAdapter(Context context) {
        this.context = context;
    }

    @Override
    public BaseItemViewHolder<ProfileModel, ProfileItemViewModel, ?>
    onCreateViewHolder(ViewGroup parent, int viewType) {
        ProfileItemViewModel itemViewModel = new ProfileItemViewModel();
        return ProfileItemViewHolder.create(LayoutInflater.from(context),
                parent, itemViewModel);
    }

}
