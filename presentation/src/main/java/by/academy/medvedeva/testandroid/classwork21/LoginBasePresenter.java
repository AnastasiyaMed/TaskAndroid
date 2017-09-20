package by.academy.medvedeva.testandroid.classwork21;

/**
 * Created by Medvedeva Anastasiya
 * on 19.09.2017.
 */

public interface LoginBasePresenter {
    void init();

    void onResume();

    void onPause();

    void onLoginButtnClick(String name, String password);
}
