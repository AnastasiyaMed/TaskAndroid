package by.academy.medvedeva.testandroid.datainjection;

import javax.inject.Singleton;

import by.academy.medvedeva.testandroid.classwork17.UI;
import by.academy.medvedeva.testandroid.classwork21.LoginPresenter;
import by.it_academy.medvedeva.taskandroid.interaction.RegistrUseCase;
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

    // если аннотация @Inject ставится над конструктором, то метод в АппКомпонент можно не описывать
    // если над полем, то надо
    public void inject (RegistrUseCase useCase);
}
