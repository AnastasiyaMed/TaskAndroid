package by.it_academy.medvedeva.taskandroid.interaction;

import by.it_academy.medvedeva.data.database.DataBaseManager;
import by.it_academy.medvedeva.taskandroid.entity.Country;
import by.it_academy.medvedeva.taskandroid.entity.User;
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

public class AddUserToDataBase extends UseCase<UserAndContext, Void> {
    @Override
    protected Observable<Void> buildUseCase(final UserAndContext param) {


        Observable.create(new ObservableOnSubscribe<Void>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<Void> e) throws Exception {
                DataBaseManager dataBaseManager = new DataBaseManager(param.getContext());
                dataBaseManager.open(true);
                dataBaseManager.insertUser(convert(param.getUser()));
                dataBaseManager.close();
            }
        });
        return Observable.just(null);
    }

    private by.it_academy.medvedeva.data.dbentity.User convert(User user) {
        by.it_academy.medvedeva.data.dbentity.User userData = new by.it_academy.medvedeva.data.dbentity.User();
        userData.setCountry(convertCountry(user.getCountry()));
        userData.setId(user.getId());
        userData.setName(user.getName());
        userData.setAge(user.getAge());

        return userData;
    }

    private by.it_academy.medvedeva.data.dbentity.Country convertCountry(Country country) {
        by.it_academy.medvedeva.data.dbentity.Country countryData = new by.it_academy.medvedeva.data.dbentity.Country();
        countryData.setName(country.getName());
        countryData.setId(country.getId());
        return countryData;
    }
}
