package by.academy.medvedeva.testandroid.task15;

import android.content.ContextWrapper;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import by.academy.medvedeva.testandroid.R;
import by.academy.medvedeva.testandroid.base.BaseActivity;
import by.academy.medvedeva.testandroid.databinding.ActivityTask15Binding;
import by.it_academy.medvedeva.taskandroid.entity.CountryDomain;
import by.it_academy.medvedeva.taskandroid.entity.UserAndContext;
import by.it_academy.medvedeva.taskandroid.entity.UserDomain;
import by.it_academy.medvedeva.taskandroid.interaction.AddUserToDataBase;
import by.it_academy.medvedeva.taskandroid.interaction.UserListFromBDUseCase;
import io.reactivex.annotations.NonNull;
import io.reactivex.observers.DisposableObserver;

/**
 * Created by Medvedeva Anastasiya
 * on 13.09.2017.
 */

public class Task15Activity extends BaseActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        Task15ViewModel viewModel = new Task15ViewModel(this);
        this.viewModel = viewModel;

        ActivityTask15Binding binding = DataBindingUtil.setContentView(this, R.layout.activity_task15);
        binding.setViewModel(viewModel);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));

        binding.recyclerView.setAdapter(viewModel.adapter);
        super.onCreate(savedInstanceState);

    }
}
