package by.it_academy.medvedeva.taskandroid.interaction;

import javax.inject.Inject;

import by.it_academy.medvedeva.data.entity.AccessTokenData;
import by.it_academy.medvedeva.data.entity.RegisterData;
import by.it_academy.medvedeva.data.net.RestService;
import by.it_academy.medvedeva.taskandroid.entity.RegisterDomain;
import by.it_academy.medvedeva.taskandroid.entity.RegisterResponse;
import by.it_academy.medvedeva.taskandroid.interaction.base.UseCase;
import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;

/**
 * Created by Medvedeva Anastasiya
 * on 19.09.2017.
 */

public class RegistrUseCase extends UseCase<RegisterDomain, RegisterResponse> {
    AuthService service;

    @Inject
    public RegistrUseCase(AuthService service) {
        this.service = service;
    }

    @Override
    protected Observable<RegisterResponse> buildUseCase(RegisterDomain registerDomain) {

        return RestService.getInstance().register(convert(registerDomain))
                //doOnNext - помогает сделать "что--то с данными
                .doOnNext(new Consumer<AccessTokenData>() {
                    @Override
                    public void accept(AccessTokenData accessTokenData) throws Exception {
                        service.saveAccessToken(accessTokenData.getAccessToken());
                    }
                })
                .map(new Function<AccessTokenData, RegisterResponse>() {
                    @Override
                    public RegisterResponse apply(@NonNull AccessTokenData accessTokenData) throws Exception {
                        return new RegisterResponse();
                    }
                });

    }

    private RegisterData convert(RegisterDomain registerDomain) {
        RegisterData registerData = new RegisterData();
        registerData.setName(registerDomain.getName());
        registerData.setPassword(registerDomain.getPassword());
        return registerData;
    }
}
