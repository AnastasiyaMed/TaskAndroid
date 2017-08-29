package by.academy.medvedeva.testandroid.task11;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;

import by.academy.medvedeva.testandroid.R;
import by.academy.medvedeva.testandroid.base.BaseActivity;
import by.academy.medvedeva.testandroid.databinding.ActivityTask11Binding;

/**
 * Created by Medvedeva Anastasiya
 * on 28.08.2017.
 */

public class Task11Activity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        Task11ViewModel viewModel = new Task11ViewModel(this);
        this.viewModel = viewModel;

        ActivityTask11Binding binding = DataBindingUtil.setContentView(this, R.layout.activity_task11);
        binding.setViewModel(viewModel);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));

        binding.recyclerView.setAdapter(viewModel.adapter);
        super.onCreate(savedInstanceState);
    }
}
