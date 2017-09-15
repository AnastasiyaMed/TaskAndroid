package by.academy.medvedeva.testandroid.task15;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;

import by.academy.medvedeva.testandroid.R;
import by.academy.medvedeva.testandroid.base.BaseActivity;
import by.academy.medvedeva.testandroid.databinding.ActivityAddUserBinding;

/**
 * Created by Medvedeva Anastasiya
 * on 15.09.2017.
 */

public class AddUserActivity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        AddUserViewModel viewModel = new AddUserViewModel(this);
        this.viewModel = viewModel;
        ActivityAddUserBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_add_user);
        binding.setViewModel(viewModel);
        super.onCreate(savedInstanceState);

        binding.spinner.setAdapter(viewModel.adapter);
        binding.spinner.setSelection(viewModel.position.get());

    }


}
