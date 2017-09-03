package by.academy.medvedeva.testandroid.task11;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;
import android.util.Log;

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

    public Activity activity;
    public ObservableField<String> name = new ObservableField<>("");
    public ObservableField<String> surname = new ObservableField<>("");
    public ObservableField<String> updatingProfile = new ObservableField<>("");
    public ObservableInt age = new ObservableInt(0);
    public ObservableInt id = new ObservableInt(0);
    public ObservableField<STATE> state = new ObservableField<>(STATE.PROGRESS);

    DetailsViewModel(Activity activity) {
        this.activity = activity;
    }

    private GetProfileUseCase getProfileUseCase = new GetProfileUseCase();


    @Override
    public void init() {

    }

    @Override
    public void release() {

    }

    @Override
    public void resume() {
        updatingProfile.set(activity.getIntent().getStringExtra("UPDATE_SUCCESS"));

        final int profileId = activity.getIntent().getIntExtra("ID", 0);
        getProfileUseCase.execute(profileId, new DisposableObserver<ProfileModel>() {
            @Override
            public void onNext(@NonNull ProfileModel profile) {
                name.set(profile.getName());
                surname.set(profile.getSurname());
                age.set(profile.getAge());
                id.set(profile.getId());

                state.set(STATE.DATA);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                Log.e("AAA", "error= ", e);
            }

            @Override
            public void onComplete() {

            }
        });
    }

    @Override
    public void pause() {

    }

    public void onSuperButtonClick(Context context) {
        Intent intent = new Intent(context, EditProfileActivity.class);
        intent.putExtra("ID", id.get());
        context.startActivity(intent);
    }
}
