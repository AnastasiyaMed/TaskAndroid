package by.academy.medvedeva.testandroid.task4;

import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import by.academy.medvedeva.testandroid.R;

/**
 * Created by Medvedeva Anastasiya
 * on 05.08.2017.
 */

public class Task4Activity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task4);

        ImageView imageView = (ImageView) findViewById(R.id.sovaImage);
        imageView.setBackgroundResource(R.drawable.sova_anim);

        // Get the background, which has been compiled to an AnimationDrawable object.
        AnimationDrawable animation = (AnimationDrawable) imageView.getBackground();

        // Start the animation (looped playback by default).
        animation.start();


    }
}
