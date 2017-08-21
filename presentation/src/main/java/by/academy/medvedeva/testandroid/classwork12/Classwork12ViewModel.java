package by.academy.medvedeva.testandroid.classwork12;

import android.app.Activity;
import android.databinding.ObservableField;
import android.util.Log;

import java.util.List;

import by.academy.medvedeva.testandroid.base.BaseViewModel;
import by.it_academy.medvedeva.taskandroid.entity.ProfileModel;
import by.it_academy.medvedeva.taskandroid.interaction.cw12.GetProfoleListUseCase;
import io.reactivex.annotations.NonNull;
import io.reactivex.observers.DisposableObserver;

/**
 * Created by Medvedeva Anastasiya
 * on 18.08.2017.
 */

public class Classwork12ViewModel implements BaseViewModel {

    private Activity activity;

    public enum STATE {PROGRESS, DATA}

    public ObservableField<STATE> state = new ObservableField<>(STATE.PROGRESS);

    public Classwork12ViewModel(Activity activity) {
        this.activity = activity;
    }

    private GetProfoleListUseCase getProfoleListUseCase = new GetProfoleListUseCase();

    public ProfileAdapter adapter = new ProfileAdapter(activity);

    @Override
    public void init() {
    }

    @Override
    public void release() {
    }

    @Override
    public void resume() {
        getProfoleListUseCase.execute(null, new DisposableObserver<List<? extends ProfileModel>>() {
            @Override
            public void onNext(@NonNull List<? extends ProfileModel> profileModels) {

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

    }
}
