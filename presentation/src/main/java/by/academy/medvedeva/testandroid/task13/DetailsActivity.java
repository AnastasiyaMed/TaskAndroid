package by.academy.medvedeva.testandroid.task13;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;

import by.academy.medvedeva.testandroid.R;
import by.academy.medvedeva.testandroid.base.BaseActivity;
import by.academy.medvedeva.testandroid.base.BaseFragmentActivity;
import by.academy.medvedeva.testandroid.databinding.ActivityDetails13Binding;
import by.academy.medvedeva.testandroid.databinding.ActivityDetailsBinding;

/**
 * Created by Medvedeva Anastasiya
 * on 28.08.2017.
 */

public class DetailsActivity extends BaseFragmentActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        DetailsViewModel viewModel = new DetailsViewModel(this);
        this.viewModel = viewModel;
        ActivityDetails13Binding binding = DataBindingUtil.setContentView(this, R.layout.activity_details13);
        binding.setViewModel(viewModel);

        super.onCreate(savedInstanceState);
    }
}
