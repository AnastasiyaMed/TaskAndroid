package by.academy.medvedeva.testandroid.task15;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import by.academy.medvedeva.testandroid.base.BaseItemViewHolder;
import by.academy.medvedeva.testandroid.databinding.ItemProfileTask13Binding;
import by.academy.medvedeva.testandroid.databinding.ItemUserTask15Binding;
import by.academy.medvedeva.testandroid.task13.Task13ProfileItemViewHolder;
import by.academy.medvedeva.testandroid.task13.Task13ProfileItemViewModel;
import by.it_academy.medvedeva.taskandroid.entity.UserDomain;

/**
 * Created by Medvedeva Anastasiya
 * on 14.09.2017.
 */

public class Task15UserItemViewHolder extends BaseItemViewHolder<UserDomain, Task15UserItemViewModel, ItemUserTask15Binding> {

    public Task15UserItemViewHolder(ItemUserTask15Binding dataBinding, Task15UserItemViewModel viewModel) {
        super(dataBinding, viewModel);
        dataBinding.setViewModel(viewModel);
    }

    public static Task15UserItemViewHolder create(LayoutInflater inflater, ViewGroup parent,
                                                  Task15UserItemViewModel viewModel) {
        ItemUserTask15Binding binding = ItemUserTask15Binding.inflate(inflater, parent, false);
        return new Task15UserItemViewHolder(binding, viewModel);
    }
}
