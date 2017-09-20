package by.academy.medvedeva.testandroid.classwork21;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import by.academy.medvedeva.testandroid.R;
import by.academy.medvedeva.testandroid.main.MainActivity;

/**
 * Created by Medvedeva Anastasiya
 * on 19.09.2017.
 */

public class LoginActivity extends AppCompatActivity implements LoginView {

    // есть интерфейс у активити и интерфейс у презентера. Друг о друге активити и презентер ничего не знают
    // зато знают об интерфейсах друг друга
    private LoginBasePresenter presenter;

    private ProgressBar progressBar;
    private Button loginButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
// здесь можно решать, какой презентер мы делаем. Можно брать разных, например чуть чуть разная логика. Только эти
        // два презентера должны имплементить один общий интерфейс
        // это полиморфизм, детка :)
        presenter = new LoginPresenter(this);

        progressBar = findViewById(R.id.progress);
        loginButton = findViewById(R.id.login_button);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.onLoginButtnClick("username", "password");
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        presenter.onPause();
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void dissmissProgress() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void showError() {
        Toast.makeText(this, "Ooops", Toast.LENGTH_LONG).show();
    }

    @Override
    public void goToMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }
}
