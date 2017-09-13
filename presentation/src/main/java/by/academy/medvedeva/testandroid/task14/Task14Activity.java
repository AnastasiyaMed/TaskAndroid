package by.academy.medvedeva.testandroid.task14;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;

import by.academy.medvedeva.testandroid.R;
import by.academy.medvedeva.testandroid.base.BaseActivity;
import by.academy.medvedeva.testandroid.databinding.ActivityTask14Binding;

/**
 * Created by Medvedeva Anastasiya
 * on 11.09.2017.
 */

public class Task14Activity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        Task14ViewModel viewModel = new Task14ViewModel(this);
        this.viewModel = viewModel;
        ActivityTask14Binding binding = DataBindingUtil.setContentView(this, R.layout.activity_task14);
        binding.setViewModel(viewModel);
        super.onCreate(savedInstanceState);

        binding.spinner.setAdapter(viewModel.adapter);
        binding.spinner.setSelection(viewModel.position.get());
    }
}
