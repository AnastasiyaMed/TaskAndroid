package by.academy.medvedeva.testandroid.base;

/**
 * Created by Medvedeva Anastasiya
 * on 09.09.2017.
 */

public interface BaseFragmentViewModel {
    public void init();

    public void onCreateView();

    public void onViewCreated();

    public void release();


    public void resume();


    public void pause();

}
