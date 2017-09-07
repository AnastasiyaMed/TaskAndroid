package by.academy.medvedeva.testandroid.classwork14;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import by.academy.medvedeva.testandroid.R;

/**
 * Created by Medvedeva Anastasiya
 * on 04.09.2017.
 */

public class ClassWork14Activity extends FragmentActivity {
    @BindView(R.id.editText)
    EditText title;

    @BindView(R.id.button)
    Button button;

    SharedPreferences preferences;
    private static final String SHARED_PREFERENCES_NAME = "dushgliisgu";
    private static final String KEY_NAME = "KEY_NAME";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classwork14);

        ButterKnife.bind(this);

        preferences = getSharedPreferences(SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                preferences.edit().putString(KEY_NAME, title.getText().toString())
                        .apply();
            }
        });

        // берем данные из SharedPreferences, которые сохранили выше
        String data = preferences.getString(KEY_NAME, null);
        if (data != null) {
            title.setText(data);
        } else {
            title.setText(R.string.empty_data);
        }
    }
}
