package by.academy.medvedeva.testandroid.task13;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;

import by.academy.medvedeva.testandroid.R;
import by.academy.medvedeva.testandroid.base.BaseActivity;
import by.academy.medvedeva.testandroid.databinding.ActivityTask13Binding;

/**
 * Created by Medvedeva Anastasiya
 * on 28.08.2017.
 */

public class Task13Activity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        Task13ViewModel viewModel = new Task13ViewModel(this);
        this.viewModel = viewModel;

        ActivityTask13Binding binding = DataBindingUtil.setContentView(this, R.layout.activity_task13);
        binding.setViewModel(viewModel);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));

        binding.recyclerView.setAdapter(viewModel.adapter);
        super.onCreate(savedInstanceState);
    }
}
