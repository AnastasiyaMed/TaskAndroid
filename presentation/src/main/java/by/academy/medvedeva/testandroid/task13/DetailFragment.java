package by.academy.medvedeva.testandroid.task13;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import by.academy.medvedeva.testandroid.R;
import by.academy.medvedeva.testandroid.base.BaseFragment;
import by.academy.medvedeva.testandroid.databinding.FragmentDetails13Binding;

/**
 * Created by Medvedeva Anastasiya
 * on 10.09.2017.
 */

public class DetailFragment extends BaseFragment {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {

//        FragmentDetails13Binding binding = FragmentDetails13Binding.inflate(getActivity().getLayoutInflater());

        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        DetailFragmentViewModel viewModel = new DetailFragmentViewModel(this);
        this.viewModel = viewModel;
        FragmentDetails13Binding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_details13, container, false);
        binding.setViewModel(viewModel);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
