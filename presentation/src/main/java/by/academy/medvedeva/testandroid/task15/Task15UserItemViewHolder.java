package by.academy.medvedeva.testandroid.task15;

import by.academy.medvedeva.testandroid.base.BaseItemViewHolder;
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
}
