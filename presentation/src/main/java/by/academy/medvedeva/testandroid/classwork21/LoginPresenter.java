package by.academy.medvedeva.testandroid.classwork21;

import javax.inject.Inject;

import by.it_academy.medvedeva.taskandroid.entity.RegisterDomain;
import by.it_academy.medvedeva.taskandroid.entity.RegisterResponse;
import by.it_academy.medvedeva.taskandroid.interaction.RegistrUseCase;
import io.reactivex.annotations.NonNull;
import io.reactivex.observers.DisposableObserver;

/**
 * Created by Medvedeva Anastasiya
 * on 19.09.2017.
 */

public class LoginPresenter implements LoginBasePresenter {
    @Inject
    RegistrUseCase useCase;
    private LoginView view;

    public LoginPresenter(LoginView view) {
        this.view = view;
    }

    @Override
    public void init() {

    }

    @Override
    public void onResume() {

    }

    @Override
    public void onPause() {
        useCase.dispose();
    }

    @Override
    public void onLoginButtnClick(String name, String password) {
        view.showProgress();
        RegisterDomain register = new RegisterDomain();
        register.setName(name);
        register.setPassword(password);
        useCase.execute(register, new DisposableObserver<RegisterResponse>() {
            @Override
            public void onNext(@NonNull RegisterResponse registerResponse) {
                view.dissmissProgress();
                view.goToMainActivity();
            }

            @Override
            public void onError(@NonNull Throwable e) {
                view.showError();
            }

            @Override
            public void onComplete() {

            }
        });
    }
}
