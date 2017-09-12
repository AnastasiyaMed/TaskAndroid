package by.academy.medvedeva.testandroid.datainjection;

import javax.inject.Singleton;

import by.academy.medvedeva.testandroid.classwork17.Gson;
import by.academy.medvedeva.testandroid.classwork17.OkHttp;
import by.academy.medvedeva.testandroid.classwork17.Rest;
import by.academy.medvedeva.testandroid.classwork17.SharedPref;
import by.academy.medvedeva.testandroid.classwork17.UseCase1;
import dagger.Module;
import dagger.Provides;

/**
 * Created by Medvedeva Anastasiya
 * on 11.09.2017.
 */

@Module
public class AppModule {

    @Provides
    @Singleton // делает UseCase1 синглтоном
    public UseCase1 provideUseCase1(Rest rest, SharedPref sharedPref){
        return new UseCase1(rest, sharedPref);
    }

    @Provides
    public OkHttp provideOkHttp (){
        return new OkHttp();
    }
    @Provides
    public Gson provideGson(){
        return  new Gson();
    }

    @Provides
    public Rest provideRest (OkHttp okHttp, Gson gson) {
        return new Rest(okHttp, gson);
    }

    @Provides
    public SharedPref providesSharedPref(){
        return new SharedPref();
    }

}
