package by.academy.medvedeva.testandroid.main;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import by.academy.medvedeva.testandroid.R;
import by.academy.medvedeva.testandroid.classwork10.Classwork10Activity;
import by.academy.medvedeva.testandroid.classwork12.Classwork12Activity;
import by.academy.medvedeva.testandroid.classwork13.Classwork13Activity;
import by.academy.medvedeva.testandroid.classwork14.ClassWork14Activity;
import by.academy.medvedeva.testandroid.classwork16.Classwork16Activity;
import by.academy.medvedeva.testandroid.classwork18.Classwork18Activity;
import by.academy.medvedeva.testandroid.classwork2.Classwork2Activity;
import by.academy.medvedeva.testandroid.classwork3.Classwork3Activity;
import by.academy.medvedeva.testandroid.classwork4.Classwork4Activity;
import by.academy.medvedeva.testandroid.classwork5.Classwork5Activity;
import by.academy.medvedeva.testandroid.classwork6.Classwork6Activity;
import by.academy.medvedeva.testandroid.classwork7.Classwork7Activity;
import by.academy.medvedeva.testandroid.classwork8.Classwork8Activity;
import by.academy.medvedeva.testandroid.task1.Task1Activity;
import by.academy.medvedeva.testandroid.task10.Task10Activity;
import by.academy.medvedeva.testandroid.task11.Task11Activity;
import by.academy.medvedeva.testandroid.task13.Task13Activity;
import by.academy.medvedeva.testandroid.task14.Task14Activity;
import by.academy.medvedeva.testandroid.task15.Task15Activity;
import by.academy.medvedeva.testandroid.task2.Task2Activity;
import by.academy.medvedeva.testandroid.task3.Task3Activity;
import by.academy.medvedeva.testandroid.task4.Task4Activity;
import by.academy.medvedeva.testandroid.task5.Task5Activity;
import by.academy.medvedeva.testandroid.task6.Task6Activity;
import by.academy.medvedeva.testandroid.task7.Task7Activity;
import by.academy.medvedeva.testandroid.task9.Task9Activity;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.subjects.BehaviorSubject;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.ReplaySubject;

/**
 * Created by Medvedeva Anastasiya
 * on 26.07.2017.
 */

public class MainActivity extends Activity implements View.OnClickListener {
    @BindView(R.id.class14_button)
    Button class14;


    public PublishSubject<String> publishSubject = PublishSubject.create();
    // behaviorSubject хранит историю. Он кэширует один объект,
    // то есть последний до подписки на него и все что после
    // и есть возможность задавать количество сообщений, которые будут кэшироваться
    public BehaviorSubject<String> behaviorSubject = BehaviorSubject.create();
    // replaySubject хранит ВСЮ историю. Когда бы сообщения не были отправлены, он покажет все
    public ReplaySubject<String> replaySubject = ReplaySubject.create();

    Disposable disposable;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        // посылаем информацию в паблишсабжэект
        // эти данные мы не получили, потому что не подписались на них еще
        publishSubject.onNext("1");
        publishSubject.onNext("2");
        publishSubject.onNext("3");
        publishSubject.onNext("4");

        // подписываемся на него, и обязательно потом отписаться
        disposable = publishSubject.subscribeWith(new DisposableObserver<String>() {
            @Override
            public void onNext(@NonNull String s) {
                Log.e("AAA", s);
            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
        // эти данные мы уже получим, потому что уже подписались
        publishSubject.onNext("5");
        publishSubject.onNext("6");
        publishSubject.onNext("7");


        behaviorSubject.onNext("123");


        // ContextCompat помогает управлять разрешениями в разных версиях андроида

        final Button task1Button = findViewById(R.id.task1_button);
        final Button task2Button = findViewById(R.id.task2_button);
        final Button task3Button = findViewById(R.id.task3_button);
        final Button task4Button = findViewById(R.id.task4_button);
        final Button task5Button = findViewById(R.id.task5_button);
        final Button task6Button = findViewById(R.id.task6_button);
        final Button task7Button = findViewById(R.id.task7_button);
        final Button task9Button = findViewById(R.id.task9_button);
        final Button task10Button = findViewById(R.id.task10_button);
        final Button task11Button = findViewById(R.id.task11_button);
        final Button task13Button = findViewById(R.id.task13_button);
        final Button task14Button = findViewById(R.id.task14_button);
        final Button task15Button = findViewById(R.id.task15_button);
        final Button class2 = findViewById(R.id.class2_button);
        final Button class3 = findViewById(R.id.class3_button);
        final Button class4 = findViewById(R.id.class4_button);
        final Button class5 = findViewById(R.id.class5_button);
        final Button class6 = findViewById(R.id.class6_button);
        final Button class7 = findViewById(R.id.class7_button);
        final Button class8 = findViewById(R.id.class8_button);
        final Button class10 = findViewById(R.id.class10_button);
        final Button class12 = findViewById(R.id.class12_button);
        final Button class13 = findViewById(R.id.class13_button);
        final Button class16 = findViewById(R.id.class16_button);
        final Button class18 = findViewById(R.id.class18_button);

        class2.setOnClickListener(this);
        class3.setOnClickListener(this);
        class4.setOnClickListener(this);
        class5.setOnClickListener(this);
        class6.setOnClickListener(this);
        class7.setOnClickListener(this);
        class8.setOnClickListener(this);
        class10.setOnClickListener(this);
        class12.setOnClickListener(this);
        class13.setOnClickListener(this);
        class14.setOnClickListener(this);
        class16.setOnClickListener(this);
        class18.setOnClickListener(this);
        task2Button.setOnClickListener(this);
        task3Button.setOnClickListener(this);
        task4Button.setOnClickListener(this);
        task5Button.setOnClickListener(this);
        task6Button.setOnClickListener(this);
        task7Button.setOnClickListener(this);
        task9Button.setOnClickListener(this);
        task10Button.setOnClickListener(this);
        task11Button.setOnClickListener(this);
        task13Button.setOnClickListener(this);
        task14Button.setOnClickListener(this);
        task15Button.setOnClickListener(this);


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
            case (R.id.class10_button):
                intent = new Intent(getApplicationContext(), Classwork10Activity.class);
                startActivity(intent);
                break;
            case (R.id.class12_button):
                intent = new Intent(getApplicationContext(), Classwork12Activity.class);
                startActivity(intent);
                break;
            case (R.id.class13_button):
                intent = new Intent(getApplicationContext(), Classwork13Activity.class);
                startActivity(intent);
                break;
            case (R.id.class14_button):
                intent = new Intent(getApplicationContext(), ClassWork14Activity.class);
                startActivity(intent);
                break;
            case (R.id.class16_button):
                intent = new Intent(getApplicationContext(), Classwork16Activity.class);
                startActivity(intent);
                break;
            case (R.id.class18_button):
                intent = new Intent(getApplicationContext(), Classwork18Activity.class);
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
            case (R.id.task7_button):
                intent = new Intent(getApplicationContext(), Task7Activity.class);
                startActivity(intent);
                break;
            case (R.id.task9_button):
                intent = new Intent(getApplicationContext(), Task9Activity.class);
                startActivity(intent);
                break;
            case (R.id.task10_button):
                intent = new Intent(getApplicationContext(), Task10Activity.class);
                startActivity(intent);
                break;
            case (R.id.task11_button):
                intent = new Intent(getApplicationContext(), Task11Activity.class);
                startActivity(intent);
                break;
            case (R.id.task13_button):
                intent = new Intent(getApplicationContext(), Task13Activity.class);
                startActivity(intent);
                break;
            case (R.id.task14_button):
                intent = new Intent(getApplicationContext(), Task14Activity.class);
                startActivity(intent);
                break;
            case (R.id.task15_button):
                intent = new Intent(getApplicationContext(), Task15Activity.class);
                startActivity(intent);
                break;
        }

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (!disposable.isDisposed()) {
            disposable.dispose();
        }
    }
}
