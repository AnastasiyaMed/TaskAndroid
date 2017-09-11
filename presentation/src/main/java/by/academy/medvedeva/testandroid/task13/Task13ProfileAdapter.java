package by.academy.medvedeva.testandroid.task13;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import by.academy.medvedeva.testandroid.base.BaseAdapter;
import by.it_academy.medvedeva.taskandroid.entity.ProfileModel;


/**
 * Created by Medvedeva Anastasiya
 * on 18.08.2017.
 */

public class Task13ProfileAdapter extends BaseAdapter<ProfileModel, Task13ProfileItemViewModel> {


    @Override
    public Task13ProfileItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Task13ProfileItemViewModel itemViewModel = new Task13ProfileItemViewModel();
        return Task13ProfileItemViewHolder.create(LayoutInflater.from(parent.getContext()),
                parent, itemViewModel);
    }

}
