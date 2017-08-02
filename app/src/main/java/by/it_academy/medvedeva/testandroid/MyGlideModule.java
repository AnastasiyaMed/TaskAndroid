package by.it_academy.medvedeva.testandroid;

import com.bumptech.glide.annotation.GlideModule;

import java.lang.annotation.Annotation;

/**
 * Created by Medvedeva Anastasiya
 * on 01.08.2017.
 */

public class MyGlideModule implements GlideModule {
    @Override
    public String glideName() {
        return null;
    }

    @Override
    public Class<? extends Annotation> annotationType() {
        return null;
    }
}
