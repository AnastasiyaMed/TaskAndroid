package by.academy.medvedeva.testandroid.task11;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import by.academy.medvedeva.testandroid.base.BaseAdapter;
import by.it_academy.medvedeva.taskandroid.entity.ProfileModel;


/**
 * Created by Medvedeva Anastasiya
 * on 18.08.2017.
 */

public class Task11ProfileAdapter extends BaseAdapter<ProfileModel, Task11ProfileItemViewModel> {


    @Override
    public Task11ProfileItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Task11ProfileItemViewModel itemViewModel = new Task11ProfileItemViewModel();
        return Task11ProfileItemViewHolder.create(LayoutInflater.from(parent.getContext()),
                parent, itemViewModel);
    }

}
