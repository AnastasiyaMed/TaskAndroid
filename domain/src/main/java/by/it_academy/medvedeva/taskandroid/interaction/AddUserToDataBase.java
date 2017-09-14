package by.it_academy.medvedeva.taskandroid.interaction;

import android.util.Log;

import by.it_academy.medvedeva.data.database.DataBaseManager;
import by.it_academy.medvedeva.data.dbentity.Country;
import by.it_academy.medvedeva.data.dbentity.User;
import by.it_academy.medvedeva.taskandroid.entity.CountryDomain;
import by.it_academy.medvedeva.taskandroid.entity.UserDomain;
import by.it_academy.medvedeva.taskandroid.entity.UserAndContext;
import by.it_academy.medvedeva.taskandroid.interaction.base.UseCase;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.annotations.NonNull;

/**
 * Created by Medvedeva Anastasiya
 * on 06.09.2017.
 */

public class AddUserToDataBase extends UseCase<UserAndContext, String> {

    @Override
    protected Observable<String> buildUseCase(final UserAndContext param) {


        return  Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<String> e) throws Exception {
                DataBaseManager dataBaseManager = new DataBaseManager(param.getContext());
                dataBaseManager.open(true);
                dataBaseManager.insertUser(convert(param.getUserDomain()));
                dataBaseManager.close();
                Log.e("AAA", "DONE!");
            }
        });
    }

    private User convert(UserDomain userDomain) {
        User userData = new User();
        userData.setCountry(convertCountry(userDomain.getCountryDomain()));
        userData.setId(userDomain.getId());
        userData.setName(userDomain.getName());
        userData.setAge(userDomain.getAge());

        return userData;
    }

    private Country convertCountry(CountryDomain countryDomain) {
        Country countryData = new Country();
        countryData.setName(countryDomain.getName());
        countryData.setId(countryDomain.getId());
        return countryData;
    }
}
