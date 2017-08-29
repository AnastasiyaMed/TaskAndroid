package by.it_academy.medvedeva.taskandroid.interaction;

import java.util.ArrayList;
import java.util.List;

import by.it_academy.medvedeva.taskandroid.entity.ImageEntity;
import by.it_academy.medvedeva.taskandroid.interaction.base.UseCaseTask9;

/**
 * Created by Medvedeva Anastasiya
 * on 20.08.2017.
 */

public class ImageUseCase extends UseCaseTask9<Void, List<ImageEntity>> {
    private List<ImageEntity> list = new ArrayList<>();


    @Override
    protected List<ImageEntity> buildUseCase() {

        list.add(new ImageEntity("https://crackberry.com/sites/crackberry.com/files/styles/large/public/topic_images/2013/ANDROID.png?itok=xhm7jaxS&timestamp=1362601455"));
        list.add(new ImageEntity("http://android-mobile.ru/img/Virus-Smartphone-Android.jpg"));
        list.add(new ImageEntity("http://www.sviaziservis.org/smskazax/foto_android-1.jpg"));
        list.add(new ImageEntity("http://www.sviaziservis.org/smskazax/foto_android-2.jpg"));
        list.add(new ImageEntity("http://www.sviaziservis.org/smskazax/foto_android-3.jpg"));
        list.add(new ImageEntity("http://www.sviaziservis.org/smskazax/foto_android-4.jpg"));
        list.add(new ImageEntity("http://www.sviaziservis.org/smskazax/foto_android-6.jpg"));
        list.add(new ImageEntity("http://www.sviaziservis.org/smskazax/foto_android-8.jpg"));
        list.add(new ImageEntity("http://www.sviaziservis.org/smskazax/foto_android-9.jpg"));
        list.add(new ImageEntity("http://www.sviaziservis.org/smskazax/foto_android.jpeg"));
        return list;
    }
}
