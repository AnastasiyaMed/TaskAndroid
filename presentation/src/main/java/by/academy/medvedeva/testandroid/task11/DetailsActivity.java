package by.academy.medvedeva.testandroid.task11;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;

import by.academy.medvedeva.testandroid.R;
import by.academy.medvedeva.testandroid.base.BaseActivity;
import by.academy.medvedeva.testandroid.databinding.ActivityDetailsBinding;

/**
 * Created by Medvedeva Anastasiya
 * on 28.08.2017.
 */

public class DetailsActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        DetailsViewModel viewModel = new DetailsViewModel(this);
        this.viewModel = viewModel;
        ActivityDetailsBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_details);
        binding.setViewModel(viewModel);

        super.onCreate(savedInstanceState);
    }
}
