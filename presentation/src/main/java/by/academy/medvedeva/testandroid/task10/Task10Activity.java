package by.academy.medvedeva.testandroid.task10;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.database.DatabaseUtilsCompat;

import by.academy.medvedeva.testandroid.R;
import by.academy.medvedeva.testandroid.base.BaseActivity;
import by.academy.medvedeva.testandroid.databinding.ActivityTask10Binding;

/**
 * Created by Medvedeva Anastasiya
 * on 24.08.2017.
 */

public class Task10Activity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        Task10ViewModel viewModel = new Task10ViewModel();
        this.viewModel = viewModel;

        ActivityTask10Binding binding = DataBindingUtil.setContentView(this, R.layout.activity_task10);

        binding.setViewModel(viewModel);

        super.onCreate(savedInstanceState);
    }
}
