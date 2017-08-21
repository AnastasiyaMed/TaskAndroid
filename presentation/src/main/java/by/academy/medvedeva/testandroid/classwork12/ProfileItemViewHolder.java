package by.academy.medvedeva.testandroid.classwork12;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import by.academy.medvedeva.testandroid.base.BaseItemViewHolder;
import by.academy.medvedeva.testandroid.databinding.ItemProfileBinding;
import by.it_academy.medvedeva.taskandroid.entity.ProfileModel;

/**
 * Created by Medvedeva Anastasiya
 * on 18.08.2017.
 */

public class ProfileItemViewHolder extends BaseItemViewHolder<ProfileModel,
        ProfileItemViewModel, ItemProfileBinding> {

    public ProfileItemViewHolder(ItemProfileBinding dataBinding,
                                 ProfileItemViewModel viewModel) {
        super(dataBinding, viewModel);
    }

    public static ProfileItemViewHolder create(LayoutInflater inflater, ViewGroup parent,
                                               ProfileItemViewModel viewModel) {
        ItemProfileBinding binding = ItemProfileBinding.inflate(inflater, parent, false);
        return new ProfileItemViewHolder(binding, viewModel);
    }
}
