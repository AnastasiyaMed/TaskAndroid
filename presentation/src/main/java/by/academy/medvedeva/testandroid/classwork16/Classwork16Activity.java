package by.academy.medvedeva.testandroid.classwork16;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.widget.Button;
import android.widget.EditText;

import by.academy.medvedeva.testandroid.R;
import io.realm.Realm;

/**
 * Created by Medvedeva Anastasiya
 * on 08.09.2017.
 */


public class Classwork16Activity extends FragmentActivity {
    private Realm realm;
    private EditText editText;
    private Button  button;
    private UserR user;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classwork16);
    }
}
