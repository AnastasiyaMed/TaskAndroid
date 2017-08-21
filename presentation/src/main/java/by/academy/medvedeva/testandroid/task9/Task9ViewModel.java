package by.academy.medvedeva.testandroid.task9;

import android.databinding.ObservableField;

import by.academy.medvedeva.testandroid.base.BaseViewModel;
import by.it_academy.medvedeva.taskandroid.entity.ImageEntity;
import by.it_academy.medvedeva.taskandroid.entity.ImageId;
import by.it_academy.medvedeva.taskandroid.interaction.ImageUseCase;

/**
 * Created by Medvedeva Anastasiya
 * on 20.08.2017.
 */

public class Task9ViewModel implements BaseViewModel {
    public enum STATE {PROGRESS, DATA}

    public ObservableField<String> url = new ObservableField<>("");
    public ObservableField<STATE> state = new ObservableField<>(STATE.PROGRESS);

    private ImageUseCase useCase = new ImageUseCase();


    @Override
    public void init() {

    }

    @Override
    public void release() {

    }

    @Override
    public void resume() {
        ImageId imageId = new ImageId();
        imageId.setId("123"); // это для теста, как будто у нас есть id пользователя
        ImageEntity entity = useCase.execute(imageId);

        url.set(entity.getUrl());
        state.set(STATE.DATA);
    }


    @Override
    public void pause() {

    }
}
