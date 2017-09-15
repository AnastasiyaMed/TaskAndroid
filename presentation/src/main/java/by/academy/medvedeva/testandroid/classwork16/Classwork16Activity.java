package by.academy.medvedeva.testandroid.classwork16;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import by.academy.medvedeva.testandroid.R;
import io.realm.Realm;
import io.realm.RealmChangeListener;
import io.realm.RealmModel;

/**
 * Created by Medvedeva Anastasiya
 * on 08.09.2017.
 */


public class Classwork16Activity extends FragmentActivity {
    private Realm realm;
    private EditText editText;
    private Button button;
    private UserR user;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classwork16);

        editText = findViewById(R.id.username_text);
        button = findViewById(R.id.save_data);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                saveData();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        Realm.init(this);
        realm = Realm.getDefaultInstance();
        loadData();
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (user!=null){
            user.removeAllChangeListeners();
            realm.close();
        }
    }

    private void saveData() {
        //если user = null, т. е. не загрузился методом loadData(),
        // то создаем новый
        if(user == null) {
            user = new UserR();
            user.setId(11);
            realm.beginTransaction();
            user = realm.copyToRealmOrUpdate(user);
            realm.commitTransaction();
        }
        // сохранение юзера в базу данных Realm
        // просто делаем set, realm самостоятельно сохранит все в базу
        realm.beginTransaction();
        user.setName(String.valueOf(editText.getText()));
        realm.commitTransaction();
    }

    private void loadData() {

        user = realm.where(UserR.class)
                .equalTo("id", 11)
                .findFirst();

        if(user != null) {
            editText.setText(user.getName());

            user.addChangeListener(new RealmChangeListener<RealmModel>() {
                @Override
                public void onChange(RealmModel realmModel) {
                    //когда объект изменится на который мы повесили лисенер
                    Log.e("AAA", "user changed");
                    editText.setText(user.getName());
                }
            });
        }
    }

}
