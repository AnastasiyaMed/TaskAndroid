package by.academy.medvedeva.testandroid.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import by.academy.medvedeva.testandroid.R;


/**
 * Created by Medvedeva Anastasiya
 * on 07.09.2017.
 */

abstract public class BaseFragment extends Fragment {

    protected BaseViewModel viewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel.init();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup
            container, @Nullable Bundle savedInstanceState) {
        viewModel.onCreateView();
        // Здесь не желательно вешать листенеры на какие-то элементы фрагмента, потому что на момент вызова этого метода, экран еще не создан
        return inflater.inflate(R.layout.fragment_classwork13, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModel.onViewCreated();
        // Всю логику сюда!!!
    }

    @Override
    public void onResume() {
        super.onResume();
        viewModel.resume();
    }

    @Override
    public void onPause() {
        super.onPause();
        viewModel.pause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        viewModel.release();
    }
}
