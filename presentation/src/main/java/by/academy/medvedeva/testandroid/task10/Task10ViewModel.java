package by.academy.medvedeva.testandroid.task10;

import android.databinding.ObservableInt;
import android.provider.Settings;

import by.academy.medvedeva.testandroid.base.BaseViewModel;
import by.it_academy.medvedeva.taskandroid.interaction.Task10UseCase;
import io.reactivex.annotations.NonNull;
import io.reactivex.observers.DisposableObserver;

/**
 * Created by Medvedeva Anastasiya
 * on 24.08.2017.
 */

public class Task10ViewModel implements BaseViewModel {
    public ObservableInt interval = new ObservableInt(0);
    private Task10UseCase useCase = new Task10UseCase();

    @Override
    public void init() {

    }

    @Override
    public void release() {
            useCase.dispose();
    }

    @Override
    public void resume() {
        useCase.execute(System.currentTimeMillis(), new DisposableObserver<Integer>() {
            @Override
            public void onNext(@NonNull Integer integer) {
                interval.set(integer);
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
