package by.academy.medvedeva.testandroid.datainjection;

import javax.inject.Singleton;

import by.academy.medvedeva.testandroid.classwork17.UI;
import dagger.Component;

/**
 * Created by Medvedeva Anastasiya
 * on 11.09.2017.
 */
@Component (modules = AppModule.class)
@Singleton
public interface AppComponent {

    //тут пишем где хотим инжектить
    public void inject (UI ui);
}
