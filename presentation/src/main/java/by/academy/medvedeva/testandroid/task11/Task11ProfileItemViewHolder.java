package by.academy.medvedeva.testandroid.task11;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import by.academy.medvedeva.testandroid.base.BaseItemViewHolder;
import by.academy.medvedeva.testandroid.databinding.ItemProfileTask11Binding;
import by.it_academy.medvedeva.taskandroid.entity.ProfileModel;

/**
 * Created by Medvedeva Anastasiya
 * on 18.08.2017.
 */

public class Task11ProfileItemViewHolder extends BaseItemViewHolder<ProfileModel,
        Task11ProfileItemViewModel, ItemProfileTask11Binding> {

    public Task11ProfileItemViewHolder(ItemProfileTask11Binding binding, Task11ProfileItemViewModel viewModel) {
        super(binding, viewModel);
        binding.setViewModel(viewModel);
    }

    public static Task11ProfileItemViewHolder create(LayoutInflater inflater, ViewGroup parent,
                                                     Task11ProfileItemViewModel viewModel) {
        ItemProfileTask11Binding binding = ItemProfileTask11Binding.inflate(inflater, parent, false);
        viewModel.setContext(parent.getContext());
        return new Task11ProfileItemViewHolder(binding, viewModel);
    }
}
