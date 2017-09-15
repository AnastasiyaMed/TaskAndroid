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

        AddUserToDataBase addHelper = new AddUserToDataBase();

        CountryDomain country = new CountryDomain();
        country.setCode("AL");
        UserDomain user = new UserDomain();
        user.setName("Julia");
        user.setAge(38);
        user.setCountryDomain(country);

        UserAndContext uac = new UserAndContext(this, user);

        addHelper.execute(uac, new DisposableObserver<String>() {

            @Override
            public void onNext(@NonNull String s) {
                Log.e("AAA", s);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                Log.e("AAA", e.getMessage());
                Log.e("AAA", "FUCK THAT!");
            }

            @Override
            public void onComplete() {

            }
        });

        //List<UserDomain> userDomainList = new ArrayList<>();
//        UserListFromBDUseCase userListGetter = new UserListFromBDUseCase();
//
//        ContextWrapper contextWrapper = new ContextWrapper(getBaseContext());
//        userListGetter.execute(contextWrapper, new DisposableObserver<List<UserDomain>>() {
//            @Override
//            public void onNext(@NonNull List<UserDomain> userDomains) {
//                List<CountryDomain> countryList = new ArrayList<>();
//                ObjectMapper mapper = new ObjectMapper();
//                try {
//                    InputStream is = getAssets().open("countries.json");
//                    countryList = mapper.readValue(is, TypeFactory.defaultInstance().constructCollectionType(ArrayList.class, CountryDomain.class));
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//                for (UserDomain userDomain : userDomains) {
//                    CountryDomain countryDomain = new CountryDomain();
//
//                    for (CountryDomain country : countryList) {
//                        if (userDomain.getCountryDomain().getCode().equals(country.getCode())) {
//                            countryDomain.setCode(country.getCode());
//                            countryDomain.setName(country.getName());
//                        }
//                    }
//
//                    Log.e("AAAA", userDomain.getName());
//                    Log.e("AAAA", countryDomain.getName());
//                    Log.e("AAAA", countryDomain.getCode());
//                    Log.e("AAAA", String.valueOf(userDomain.getAge()));
//                    Log.e("AAAA", String.valueOf(userDomain.getId()));
//                }
//            }
//
//            @Override
//            public void onError(@NonNull Throwable e) {
//                e.getMessage();
//                Log.e("AAAA", e.getMessage());
//                Log.e("AAAA", "FUCK THAT TWICE!");
//            }
//
//            @Override
//            public void onComplete() {
//
//            }
//        });
    }
}
