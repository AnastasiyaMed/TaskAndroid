package by.academy.medvedeva.testandroid.task15;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import by.academy.medvedeva.testandroid.base.BaseAdapter;
import by.it_academy.medvedeva.taskandroid.entity.UserDomain;

/**
 * Created by Medvedeva Anastasiya
 * on 14.09.2017.
 */

public class Task15UserAdapter extends BaseAdapter<UserDomain, Task15UserItemViewModel> {

    @Override
    public Task15UserItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Task15UserItemViewModel itemViewModel = new Task15UserItemViewModel();
        return Task15UserItemViewHolder.create(LayoutInflater.from(parent.getContext()),
                parent, itemViewModel);
    }

}
