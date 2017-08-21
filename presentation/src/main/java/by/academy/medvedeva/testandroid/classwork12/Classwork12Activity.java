package by.academy.medvedeva.testandroid.classwork12;

import android.app.Activity;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;

import by.academy.medvedeva.testandroid.R;
import by.academy.medvedeva.testandroid.base.BaseActivity;
import by.academy.medvedeva.testandroid.databinding.ActivityClasswork12Binding;

/**
 * Created by Medvedeva Anastasiya
 * on 18.08.2017.
 */

public class Classwork12Activity extends BaseActivity {

    public static void show(Activity activity) {
        Intent intent = new Intent(activity, Classwork12Activity.class);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        Classwork12ViewModel viewModel = new Classwork12ViewModel(this);
        this.viewModel = viewModel;

        ActivityClasswork12Binding binding = DataBindingUtil.setContentView(this, R.layout.activity_classwork12);
        binding.setViewModel(viewModel);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        binding.recyclerView.setAdapter(viewModel.adapter);

        super.onCreate(savedInstanceState);
    }
}
