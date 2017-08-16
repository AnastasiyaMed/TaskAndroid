package by.it_academy.medvedeva.taskandroid.interaction;


import java.util.concurrent.TimeUnit;

import by.it_academy.medvedeva.data.entity.Profile;
import by.it_academy.medvedeva.taskandroid.entity.ProfileModel;
import by.it_academy.medvedeva.taskandroid.entity.ProfileId;
import by.it_academy.medvedeva.taskandroid.interaction.base.UseCase;
import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;

/**
 * Created by Medvedeva Anastasiya
 * on 14.08.2017.
 */

public class ProfileUseCase extends UseCase<ProfileId, ProfileModel> {

    // диспосэбл(rx2) это сабскрайбер (rx1)
    // по умолчанию Обсервэбл не выполнится, если на него никто не подписался (hot Observable)
    // cold Observable выполнится

    @Override
    protected Observable<ProfileModel> buildUseCase() {

        // здесь делается запрос к слою data, в котором дергается какой-то метод на сервере (Rest)


        // создаем объект Profile который лежит в data слое
        // это для теста, в будущем этот объект нам вернет слой data
        Profile profile = new Profile();
        profile.setName("Name");
        profile.setSurname("Surname");
        profile.setAge(20);


        //flat, filter, flatMap, subscribeWith

        return Observable.just(profile)
                .delay(3, TimeUnit.SECONDS)
                .filter(new Predicate<Profile>() {
                    @Override
                    public boolean test(@NonNull Profile profile) throws Exception {
                        return profile.getName() != null;
                    }
                })
                .map(new Function<Profile, ProfileModel>() {
                    @Override
                    public ProfileModel apply(@NonNull Profile profile) throws Exception {
                        ProfileModel profileModel = new ProfileModel();
                        profileModel.setAge(profile.getAge());
                        profileModel.setName(profile.getName());
                        profileModel.setSurname(profile.getSurname());

                        return profileModel;
                    }
                });
    }
}
