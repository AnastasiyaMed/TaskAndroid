package by.academy.medvedeva.testandroid.task11;

import android.app.Activity;
import android.databinding.ObservableField;
import android.util.Log;

import java.util.List;

import by.academy.medvedeva.testandroid.base.BaseViewModel;
import by.it_academy.medvedeva.taskandroid.entity.ProfileModel;
import by.it_academy.medvedeva.taskandroid.interaction.GetProfileListUseCase;
import io.reactivex.annotations.NonNull;
import io.reactivex.observers.DisposableObserver;

/**
 * Created by Medvedeva Anastasiya
 * on 18.08.2017.
 */

public class Task11ViewModel implements BaseViewModel {

    public enum STATE {PROGRESS, DATA}

    public ObservableField<STATE> state = new ObservableField<>(STATE.PROGRESS);

    private Activity activity;


    public Task11ViewModel(Activity activity) {
        this.activity = activity;
    }

    private GetProfileListUseCase getProfileListUseCase = new GetProfileListUseCase();

    public Task11ProfileAdapter adapter = new Task11ProfileAdapter();

    @Override
    public void init() {
    }

    @Override
    public void release() {
    }

    @Override
    public void resume() {
        getProfileListUseCase.execute(null, new DisposableObserver<List<ProfileModel>>() {
            @Override
            public void onNext(@NonNull List<ProfileModel> profileModels) {
                adapter.setItems(profileModels);
                state.set(STATE.DATA);
                Log.e("AAAA items =" + profileModels.size(), "");
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
        getProfileListUseCase.dispose();
    }
}
