package by.it_academy.medvedeva.testandroid.main;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import by.it_academy.medvedeva.testandroid.R;
import by.it_academy.medvedeva.testandroid.classwork2.Classwork2Activity;
import by.it_academy.medvedeva.testandroid.task1.Task1Activity;
import by.it_academy.medvedeva.testandroid.task2.Task2Activity;

/**
 * Created by Medvedeva Anastasiya
 * on 26.07.2017.
 */

public class MainActivity extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button task1Button = (Button) findViewById(R.id.task1_button);
        final Button task2Button = (Button) findViewById(R.id.task2_button);
        final Button class2 = (Button) findViewById(R.id.class2_button);

        class2.setOnClickListener(this);
        task2Button.setOnClickListener(this);

        task1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Task1Activity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case (R.id.task1_button):
                intent = new Intent(getApplicationContext(), Task1Activity.class);
                startActivity(intent);
                break;
            case (R.id.class2_button):
                intent = new Intent(getApplicationContext(), Classwork2Activity.class);
                startActivity(intent);
                break;
            case (R.id.task2_button):
                intent = new Intent(getApplicationContext(), Task2Activity.class);
                startActivity(intent);
                break;
        }
    }
}
