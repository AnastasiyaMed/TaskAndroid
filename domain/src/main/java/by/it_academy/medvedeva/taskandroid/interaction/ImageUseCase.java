package by.it_academy.medvedeva.taskandroid.interaction;

import by.it_academy.medvedeva.taskandroid.entity.ImageEntity;
import by.it_academy.medvedeva.taskandroid.entity.ImageId;
import by.it_academy.medvedeva.taskandroid.interaction.base.UseCaseTask9;

/**
 * Created by Medvedeva Anastasiya
 * on 20.08.2017.
 */

public class ImageUseCase extends UseCaseTask9<ImageId, ImageEntity> {
    @Override
    protected ImageEntity buildUseCase() {
        ImageEntity imageEntity = new ImageEntity();
        imageEntity.setUrl("https://crackberry.com/sites/crackberry.com/files/styles/large/public/topic_images/2013/ANDROID.png?itok=xhm7jaxS&timestamp=1362601455");
        return imageEntity;
    }
}
