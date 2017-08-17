package by.academy.medvedeva.testandroid.classwork10;


import android.databinding.ObservableField;
import android.databinding.ObservableInt;
import android.util.Log;

import by.academy.medvedeva.testandroid.base.BaseViewModel;
import by.it_academy.medvedeva.taskandroid.entity.ProfileModel;
import by.it_academy.medvedeva.taskandroid.entity.ProfileId;
import by.it_academy.medvedeva.taskandroid.interaction.ProfileUseCase;
import by.it_academy.medvedeva.taskandroid.interaction.SaveProfileUseCase;
import io.reactivex.annotations.NonNull;
import io.reactivex.observers.DisposableObserver;

/**
 * Created by Medvedeva Anastasiya
 * on 14.08.2017.
 */

public class ClassWordk10ViewModel implements BaseViewModel {


    public enum STATE {PROGRESS, DATA}

    public ObservableField<String> name = new ObservableField<>("");
    public ObservableField<String> surname = new ObservableField<>("");
    public ObservableInt age = new ObservableInt(0);
    public ObservableField<STATE> state = new ObservableField<>(STATE.PROGRESS);

    private ProfileUseCase useCase = new ProfileUseCase();

    private SaveProfileUseCase saveProfileUseCase = new SaveProfileUseCase();

    @Override
    public void init() {
    }

    @Override
    public void resume() {

        ProfileModel profileModel = new ProfileModel();
        profileModel.setAge(27);
        profileModel.setName("koh");
        profileModel.setSurname("kugs");
        saveProfileUseCase.execute(profileModel, new DisposableObserver<Void>() {
            @Override
            public void onNext(@NonNull Void aVoid) {
                Log.e("AAA", "OK");
            }

            @Override
            public void onError(@NonNull Throwable e) {
                Log.e("AAA", "error");
            }

            @Override
            public void onComplete() {

            }
        });


        ProfileId profileId = new ProfileId();
        profileId.setId("123"); // это для теста, как будто у нас есть id пользователя
        useCase.execute(profileId, new DisposableObserver<ProfileModel>() {
            @Override
            public void onNext(@NonNull ProfileModel profile) {
                name.set(profile.getName());
                surname.set(profile.getSurname());
                age.set(profile.getAge());

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

    @Override
    public void release() {
    }
}
