package by.it_academy.medvedeva.testandroid.classwork3;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import by.it_academy.medvedeva.testandroid.R;

/**
 * Created by Medvedeva Anastasiya
 * on 28.07.2017.
 */

public class Classwork3Activity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classwork3);

        ImageView imageView = (ImageView) findViewById(R.id.imageCats);

    }
}
