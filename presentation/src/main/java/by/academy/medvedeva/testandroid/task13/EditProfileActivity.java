package by.academy.medvedeva.testandroid.task13;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;

import by.academy.medvedeva.testandroid.R;
import by.academy.medvedeva.testandroid.base.BaseActivity;
import by.academy.medvedeva.testandroid.databinding.ActivityEditProfile13Binding;

/**
 * Created by Medvedeva Anastasiya
 * on 01.09.2017.
 */

public class EditProfileActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        EditProfileViewModel viewModel = new EditProfileViewModel(this);
        this.viewModel = viewModel;
        ActivityEditProfile13Binding binding = DataBindingUtil.setContentView(this, R.layout.activity_edit_profile13);
        binding.setViewModel(viewModel);
        super.onCreate(savedInstanceState);
    }
}
