package by.it_academy.medvedeva.taskandroid.interaction;

import by.it_academy.medvedeva.data.entity.Profile;
import by.it_academy.medvedeva.data.net.RestService;
import by.it_academy.medvedeva.taskandroid.entity.ProfileModel;
import by.it_academy.medvedeva.taskandroid.interaction.base.UseCase;
import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;

/**
 * Created by Medvedeva Anastasiya
 * on 27.08.2017.
 */

public class GetProfileUseCase extends UseCase<String, ProfileModel> {

    @Override
    protected Observable<ProfileModel> buildUseCase(String param) {
        return RestService.getInstance().getProfile(param).map(new Function<Profile, ProfileModel>() {
            @Override
            public ProfileModel apply(@NonNull Profile profile) throws Exception {
                if (profile != null) {
                    return convert(profile);
                } else {
                    ProfileModel profileModel = new ProfileModel();
                    profileModel.setName("Профиль не найден");
                    return profileModel;
                }
            }
        });

    }

    private ProfileModel convert(Profile dataModel) {
        ProfileModel profileModel = new ProfileModel();
        profileModel.setName(dataModel.getName());
        profileModel.setSurname(dataModel.getSurname());
        profileModel.setAge(dataModel.getAge());
        profileModel.setId(dataModel.getId());
        return profileModel;
    }

}
