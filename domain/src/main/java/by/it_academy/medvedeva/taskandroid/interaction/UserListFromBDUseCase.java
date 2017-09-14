package by.it_academy.medvedeva.taskandroid.interaction;

import android.content.ContextWrapper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import by.it_academy.medvedeva.data.database.DataBaseManager;
import by.it_academy.medvedeva.data.dbentity.User;
import by.it_academy.medvedeva.taskandroid.entity.CountryDomain;
import by.it_academy.medvedeva.taskandroid.entity.UserDomain;
import by.it_academy.medvedeva.taskandroid.interaction.base.UseCase;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.annotations.NonNull;

/**
 * Created by Medvedeva Anastasiya
 * on 14.09.2017.
 */

public class UserListFromBDUseCase extends UseCase<ContextWrapper, List<UserDomain>> {


    @Override
    protected Observable<List<UserDomain>> buildUseCase(final ContextWrapper contextWrapper) {

        return Observable.create(new ObservableOnSubscribe<List<UserDomain>>() {

            @Override
            public void subscribe(@NonNull ObservableEmitter<List<UserDomain>> e) throws Exception {
                DataBaseManager dataBaseManager = new DataBaseManager(contextWrapper);
                dataBaseManager.open(false);
                List<User> userList = dataBaseManager.getUsers();
                dataBaseManager.close();
                if (userList.size() != 0) {
                    Log.e("AAA", convert(userList).toString());
                    e.onNext(convert(userList));
                    e.onComplete();
                } else {
                    e.onError(new Throwable("users not found"));
                }
            }
        });
    }

    private List<UserDomain> convert(List<User> userList) {
        List<UserDomain> userDomainList = new ArrayList<>();
        for (User user : userList) {
            UserDomain userDomain = new UserDomain();
            CountryDomain countryDomain = new CountryDomain();
            countryDomain.setName(user.getCountry().getName());
            countryDomain.setId(user.getCountry().getId());

            userDomain.setCountryDomain(countryDomain);
            userDomain.setId(user.getId());
            userDomain.setName(user.getName());
            userDomain.setAge(user.getAge());

            userDomainList.add(userDomain);
        }
        return userDomainList;
    }
}
