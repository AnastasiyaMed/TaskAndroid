package by.academy.medvedeva.testandroid.task13;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.databinding.ObservableField;
import android.util.Log;

import by.academy.medvedeva.testandroid.base.BaseViewModel;
import by.it_academy.medvedeva.taskandroid.entity.ProfileModel;
import by.it_academy.medvedeva.taskandroid.interaction.GetProfileUseCase;
import by.it_academy.medvedeva.taskandroid.interaction.SaveProfileUseCase;
import io.reactivex.annotations.NonNull;
import io.reactivex.observers.DisposableObserver;

/**
 * Created by Medvedeva Anastasiya
 * on 01.09.2017.
 */

public class EditProfileViewModel implements BaseViewModel {
    public enum STATE {PROGRESS, DATA}

    public Activity activity;
    public ObservableField<String> name = new ObservableField<>("");
    public ObservableField<String> surname = new ObservableField<>("");
    public ObservableField<String> age = new ObservableField<>("");
    public ObservableField<String> id = new ObservableField<>("");
    public ObservableField<STATE> state = new ObservableField<>(STATE.PROGRESS);

    EditProfileViewModel(Activity activity) {
        this.activity = activity;
    }

    private GetProfileUseCase getProfileUseCase = new GetProfileUseCase();
    private SaveProfileUseCase saveProfileUseCase = new SaveProfileUseCase();

    @Override
    public void init() {

    }

    @Override
    public void release() {

    }

    @Override
    public void resume() {
        final String profileId = activity.getIntent().getStringExtra("ID");
        getProfileUseCase.execute(profileId, new DisposableObserver<ProfileModel>() {
            @Override
            public void onNext(@NonNull ProfileModel profile) {
                name.set(profile.getName());
                surname.set(profile.getSurname());
                age.set(String.valueOf(profile.getAge()));
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

    public void onSuperButtonClick(final Context context) {
        ProfileModel profileModel = new ProfileModel();
        profileModel.setAge(Integer.valueOf(age.get()));
        profileModel.setId(id.get());
        profileModel.setName(name.get());
        profileModel.setSurname(surname.get());
        saveProfileUseCase.execute(profileModel, new DisposableObserver<String>() {
            @Override
            public void onNext(@NonNull String string) {
                Log.e("AAA", "OK");
                Intent intent = new Intent(context, DetailsActivity.class);
                intent.putExtra("UPDATE_SUCCESS", "Profile updated");
                intent.putExtra("ID", id.get());
                context.startActivity(intent);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                Log.e("AAA", e.getMessage());
            }

            @Override
            public void onComplete() {

            }
        });

    }

    @Override
    public void pause() {
        if (saveProfileUseCase != null) {
            saveProfileUseCase.dispose();
        }
        getProfileUseCase.dispose();
    }
}
