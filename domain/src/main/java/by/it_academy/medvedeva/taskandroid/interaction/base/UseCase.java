package by.it_academy.medvedeva.taskandroid.interaction.base;


import by.it_academy.medvedeva.taskandroid.entity.ProfileModel;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Medvedeva Anastasiya
 * on 14.08.2017.
 */
public abstract class UseCase<InParam, OutParam> {
    private Disposable disposable;

    protected abstract Observable<OutParam> buildUseCase();

    public ProfileModel execute(InParam param, DisposableObserver<OutParam> disposableObserver) {
        disposable = buildUseCase()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribeWith(disposableObserver);
        return null;
    }

    public void dispose() {
        if (!disposable.isDisposed()) {
            disposable.dispose();
        }
    }
}
