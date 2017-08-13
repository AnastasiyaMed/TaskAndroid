package by.academy.medvedeva.testandroid.classwork8;

import android.app.Activity;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;

import by.academy.medvedeva.testandroid.R;
import by.academy.medvedeva.testandroid.base.BaseActivity;
import by.academy.medvedeva.testandroid.classwork7.Classwork7Activity;
import by.academy.medvedeva.testandroid.databinding.ActivityClasswork8Binding;


/**
 * Created by Medvedeva Anastasiya
 * on 09.08.2017.
 */

public class Classwork8Activity extends BaseActivity {

    public static void show(Activity activity) {
        Intent intent = new Intent(activity, Classwork7Activity.class);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        Classwork8ViewModel viewModel = new Classwork8ViewModel(this);
        this.viewModel = viewModel;

        // сетает viewModel в xml
        ActivityClasswork8Binding binding = DataBindingUtil.setContentView(this, R.layout.activity_classwork8);
        binding.setViewModel(viewModel);

        // это делать после инициализации модели, иначе налпоинтер
        super.onCreate(savedInstanceState);

    }
}
