package by.academy.medvedeva.testandroid.task13;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import by.academy.medvedeva.testandroid.R;
import by.academy.medvedeva.testandroid.base.BaseFragment;
import by.academy.medvedeva.testandroid.databinding.FragmentErrorBinding;

/**
 * Created by Medvedeva Anastasiya
 * on 11.09.2017.
 */

public class ErrorFragment extends BaseFragment {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        this.viewModel = new ErrorViewModel(this);
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FragmentErrorBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_error, container, false);
        binding.setViewModel((ErrorViewModel) viewModel);
        return binding.getRoot();
    }
}
