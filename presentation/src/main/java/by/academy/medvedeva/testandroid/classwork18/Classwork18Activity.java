package by.academy.medvedeva.testandroid.classwork18;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import by.academy.medvedeva.testandroid.R;

/**
 * Created by Medvedeva Anastasiya
 * on 13.09.2017.
 */

public class Classwork18Activity extends AppCompatActivity {
    View view;
    Button buttonOk;
    Button buttonCancel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classwork18);
        view = findViewById(R.id.viewNew);
        buttonOk = findViewById(R.id.button3);
        buttonCancel = findViewById(R.id.button2);
        final View viewRoot = findViewById(R.id.root);

        final Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //если есть фрагмент, то там и описывается, что добавить в тулбар
        //setNavigationIcon это иконка слева
        toolbar.setNavigationIcon(R.drawable.ic_3d_rotation_black_24dp);


        view.setVisibility(View.VISIBLE);
        ViewCompat.setZ(view, 20000);
        ViewCompat.setZ(buttonOk, 50000);

        buttonOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ViewCompat.setZ(view, 50000);
                ViewCompat.setZ(buttonCancel, 70000);
            }
        });
    }

    // само меню в xml в папке menu в res
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

getMenuInflater().inflate(R.menu.classwork18menu, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
}
