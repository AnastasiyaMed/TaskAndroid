package by.academy.medvedeva.testandroid.classwork17;

import javax.inject.Inject;

import by.academy.medvedeva.testandroid.LeakCanaryTool;

/**
 * Created by Medvedeva Anastasiya
 * on 11.09.2017.
 */

public class UI {

    @Inject
    UseCase1 useCase1;

    public UI() {
        LeakCanaryTool.appComponent.inject(this);
    }

    public void testUseCase1(){

    }
}
