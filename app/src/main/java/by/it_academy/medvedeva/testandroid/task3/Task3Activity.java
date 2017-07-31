package by.it_academy.medvedeva.testandroid.task3;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import by.it_academy.medvedeva.testandroid.BuildConfig;
import by.it_academy.medvedeva.testandroid.R;

/**
 * Created by Medvedeva Anastasiya
 * on 30.07.2017.
 */

public class Task3Activity extends Activity implements View.OnClickListener {
    TextView uriText;
    ImageView imageView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task3);

        uriText = (TextView) findViewById(R.id.uri_text);
        imageView = (ImageView) findViewById(R.id.imageView);
        Button imageSwitcherButton = (Button) findViewById(R.id.imageSwitcherButton);
        TextView varStringText = (TextView) findViewById(R.id.varStringText);

        varStringText.setText("Добавляем содержимое API_ENDPOINT:  " + BuildConfig.API_ENDPOINT);

        imageSwitcherButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Picasso.with(this).load(uriText.getText().toString())
                .error(R.drawable.wer).placeholder(R.drawable.wer).resize(400, 260).into(imageView);
    }
}
