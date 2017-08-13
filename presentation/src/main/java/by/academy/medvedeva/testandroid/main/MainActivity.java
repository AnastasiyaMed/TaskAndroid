package by.academy.medvedeva.testandroid.main;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import by.academy.medvedeva.testandroid.R;
import by.academy.medvedeva.testandroid.classwork2.Classwork2Activity;
import by.academy.medvedeva.testandroid.classwork3.Classwork3Activity;
import by.academy.medvedeva.testandroid.classwork4.Classwork4Activity;
import by.academy.medvedeva.testandroid.classwork5.Classwork5Activity;
import by.academy.medvedeva.testandroid.classwork6.Classwork6Activity;
import by.academy.medvedeva.testandroid.classwork7.Classwork7Activity;
import by.academy.medvedeva.testandroid.classwork8.Classwork8Activity;
import by.academy.medvedeva.testandroid.task1.Task1Activity;
import by.academy.medvedeva.testandroid.task2.Task2Activity;
import by.academy.medvedeva.testandroid.task3.Task3Activity;
import by.academy.medvedeva.testandroid.task4.Task4Activity;
import by.academy.medvedeva.testandroid.task5.Task5Activity;
import by.academy.medvedeva.testandroid.task6.Task6Activity;

/**
 * Created by Medvedeva Anastasiya
 * on 26.07.2017.
 */

public class MainActivity extends Activity implements View.OnClickListener {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // ContextCompat помогает управлять разрешениями в разных версиях андроида

        final Button task1Button = (Button) findViewById(R.id.task1_button);
        final Button task2Button = (Button) findViewById(R.id.task2_button);
        final Button task3Button = (Button) findViewById(R.id.task3_button);
        final Button task4Button = (Button) findViewById(R.id.task4_button);
        final Button task5Button = (Button) findViewById(R.id.task5_button);
        final Button task6Button = (Button) findViewById(R.id.task6_button);
        final Button class2 = (Button) findViewById(R.id.class2_button);
        final Button class3 = (Button) findViewById(R.id.class3_button);
        final Button class4 = (Button) findViewById(R.id.class4_button);
        final Button class5 = (Button) findViewById(R.id.class5_button);
        final Button class6 = (Button) findViewById(R.id.class6_button);
        final Button class7 = (Button) findViewById(R.id.class7_button);
        final Button class8 = (Button) findViewById(R.id.class8_button);

        class2.setOnClickListener(this);
        class3.setOnClickListener(this);
        class4.setOnClickListener(this);
        class5.setOnClickListener(this);
        class6.setOnClickListener(this);
        class7.setOnClickListener(this);
        class8.setOnClickListener(this);
        task2Button.setOnClickListener(this);
        task3Button.setOnClickListener(this);
        task4Button.setOnClickListener(this);
        task5Button.setOnClickListener(this);
        task6Button.setOnClickListener(this);

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
            case (R.id.class2_button):
                intent = new Intent(getApplicationContext(), Classwork2Activity.class);
                startActivity(intent);
                break;
            case (R.id.class3_button):
                intent = new Intent(getApplicationContext(), Classwork3Activity.class);
                startActivity(intent);
                break;
            case (R.id.class4_button):
                intent = new Intent(getApplicationContext(), Classwork4Activity.class);
                startActivity(intent);
                break;
            case (R.id.class5_button):
                intent = new Intent(getApplicationContext(), Classwork5Activity.class);
                startActivity(intent);
                break;
            case (R.id.class6_button):
                intent = new Intent(getApplicationContext(), Classwork6Activity.class);
                startActivity(intent);
                break;
            case (R.id.class7_button):
                intent = new Intent(getApplicationContext(), Classwork7Activity.class);
                startActivity(intent);
                break;
            case (R.id.class8_button):
                intent = new Intent(getApplicationContext(), Classwork8Activity.class);
                startActivity(intent);
                break;
            case (R.id.task1_button):
                intent = new Intent(getApplicationContext(), Task1Activity.class);
                startActivity(intent);
                break;
            case (R.id.task2_button):
                intent = new Intent(getApplicationContext(), Task2Activity.class);
                startActivity(intent);
                break;
            case (R.id.task3_button):
                intent = new Intent(getApplicationContext(), Task3Activity.class);
                startActivity(intent);
                break;
            case (R.id.task4_button):
                intent = new Intent(getApplicationContext(), Task4Activity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.translate, R.anim.alpha);
                break;
            case (R.id.task5_button):
                intent = new Intent(getApplicationContext(), Task5Activity.class);
                startActivity(intent);
                break;
            case (R.id.task6_button):
                intent = new Intent(getApplicationContext(), Task6Activity.class);
                startActivity(intent);
                break;
        }

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
