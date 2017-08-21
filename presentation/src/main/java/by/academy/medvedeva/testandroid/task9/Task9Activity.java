package by.academy.medvedeva.testandroid.task9;

import android.app.Activity;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;

import by.academy.medvedeva.testandroid.R;
import by.academy.medvedeva.testandroid.base.BaseActivity;
import by.academy.medvedeva.testandroid.databinding.ActivityTask9Binding;

/**
 * Created by Medvedeva Anastasiya
 * on 20.08.2017.
 */

public class Task9Activity extends BaseActivity {
    public static void show(Activity activity) {
        Intent intent = new Intent(activity, Task9Activity.class);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        Task9ViewModel viewModel = new Task9ViewModel();
        this.viewModel = viewModel;

        ActivityTask9Binding binding = DataBindingUtil
                .setContentView(this, R.layout.activity_task9);

        binding.setViewModel(viewModel);

        super.onCreate(savedInstanceState);

    }
}
