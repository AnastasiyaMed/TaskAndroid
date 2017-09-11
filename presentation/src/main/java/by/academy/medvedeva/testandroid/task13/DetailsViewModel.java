package by.academy.medvedeva.testandroid.task13;

import android.content.Context;
import android.content.Intent;
import android.databinding.ObservableField;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;

import by.academy.medvedeva.testandroid.R;
import by.academy.medvedeva.testandroid.base.BaseViewModel;
import by.it_academy.medvedeva.taskandroid.entity.ProfileModel;
import by.it_academy.medvedeva.taskandroid.interaction.GetProfileUseCase;
import io.reactivex.annotations.NonNull;
import io.reactivex.observers.DisposableObserver;

/**
 * Created by Medvedeva Anastasiya
 * on 30.08.2017.
 */

public class DetailsViewModel implements BaseViewModel {
    public enum STATE {PROGRESS, DATA}
    public ObservableField<STATE> state = new ObservableField<>(STATE.PROGRESS);
    private String profileId;
    private String name;
    private String surname;
    private int age;

    public FragmentActivity activity;
    private GetProfileUseCase getProfileUseCase = new GetProfileUseCase();


    DetailsViewModel(FragmentActivity activity) {
        this.activity = activity;
    }


    @Override
    public void init() {

    }

    @Override
    public void release() {

    }

    @Override
    public void resume() {
        profileId = activity.getIntent().getStringExtra("ID");

        getProfileUseCase.execute(profileId, new DisposableObserver<ProfileModel>() {
            @Override
            public void onNext(@NonNull ProfileModel profile) {
                name = (profile.getName());
                surname = (profile.getSurname());
                age = (profile.getAge());
                state.set(STATE.DATA);

                DetailFragment fragment = new DetailFragment();
                FragmentTransaction fragmentTransaction = activity.getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.container, fragment, DetailFragment.class.getName());
                Bundle bundle = new Bundle();
                bundle.putString("NAME", name);
                bundle.putString("SURNAME", surname);
                bundle.putInt("AGE", age);
                fragment.setArguments(bundle);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });


    }

    @Override
    public void pause() {
        getProfileUseCase.dispose();
    }

    public void onSuperButtonClick(Context context) {
        Intent intent = new Intent(context, EditProfileActivity.class);
        intent.putExtra("ID", profileId);
        context.startActivity(intent);
    }
}
