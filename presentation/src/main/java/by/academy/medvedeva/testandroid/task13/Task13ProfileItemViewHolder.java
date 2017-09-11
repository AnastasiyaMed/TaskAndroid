package by.academy.medvedeva.testandroid.task13;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import by.academy.medvedeva.testandroid.base.BaseItemViewHolder;
import by.academy.medvedeva.testandroid.databinding.ItemProfileTask13Binding;
import by.it_academy.medvedeva.taskandroid.entity.ProfileModel;

/**
 * Created by Medvedeva Anastasiya
 * on 18.08.2017.
 */

public class Task13ProfileItemViewHolder extends BaseItemViewHolder<ProfileModel,
        Task13ProfileItemViewModel, ItemProfileTask13Binding> {

    public Task13ProfileItemViewHolder(ItemProfileTask13Binding binding, Task13ProfileItemViewModel viewModel) {
        super(binding, viewModel);
        binding.setViewModel(viewModel);
    }

    public static Task13ProfileItemViewHolder create(LayoutInflater inflater, ViewGroup parent,
                                                     Task13ProfileItemViewModel viewModel) {
        ItemProfileTask13Binding binding = ItemProfileTask13Binding.inflate(inflater, parent, false);
        viewModel.setContext(parent.getContext());
        return new Task13ProfileItemViewHolder(binding, viewModel);
    }
}
