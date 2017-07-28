package by.it_academy.medvedeva.testandroid.classwork2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import by.it_academy.medvedeva.testandroid.R;
import by.it_academy.medvedeva.testandroid.task1.Task1Activity;

/**
 * Created by Medvedeva Anastasiya
 * on 26.07.2017.
 */

public class Classwork2Activity extends Activity implements View.OnClickListener {
    private EditText userNameText;
    private EditText passwordText;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classwork2);

        userNameText = (EditText) findViewById(R.id.username_text);
        passwordText = (EditText) findViewById(R.id.password_text);
        final Button sendButton = (Button) findViewById(R.id.login_button);

        sendButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, Task1Activity.class);
        intent.putExtra(Task1Activity.USER_NAME_TEXT, userNameText.getText().toString());
        intent.putExtra(Task1Activity.PASSWORD_TEXT, passwordText.getText().toString());
        startActivity(intent);
    }
}
