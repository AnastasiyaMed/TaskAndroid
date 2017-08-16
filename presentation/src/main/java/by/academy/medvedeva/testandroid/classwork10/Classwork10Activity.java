package by.academy.medvedeva.testandroid.classwork10;

import android.app.Activity;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;

import by.academy.medvedeva.testandroid.R;
import by.academy.medvedeva.testandroid.base.BaseActivity;
import by.academy.medvedeva.testandroid.databinding.ActivityClasswork10Binding;

/**
 * Created by Medvedeva Anastasiya
 * on 14.08.2017.
 */

public class Classwork10Activity extends BaseActivity {
    public static void show(Activity activity) {
        Intent intent = new Intent(activity, Classwork10Activity.class);
        activity.startActivity(intent);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {

        ClassWordk10ViewModel viewModel = new ClassWordk10ViewModel();
        this.viewModel = viewModel;

        ActivityClasswork10Binding binding = DataBindingUtil
                .setContentView(this, R.layout.activity_classwork10);

        binding.setViewModel(viewModel);

        super.onCreate(savedInstanceState);
    }

}
