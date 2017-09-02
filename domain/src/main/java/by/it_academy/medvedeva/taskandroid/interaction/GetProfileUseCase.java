package by.it_academy.medvedeva.taskandroid.interaction;

import java.util.List;

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

public class GetProfileUseCase extends UseCase<Integer, ProfileModel> {

    @Override
    protected Observable<ProfileModel> buildUseCase(Integer param) {
        return RestService.getInstance().getProfile(param).map(new Function<List<Profile>, ProfileModel>() {
            @Override
            public ProfileModel apply(@NonNull List<Profile> profileList) throws Exception {
                if (profileList.size() != 0) {
                    Profile profileData = profileList.get(0);
                    return convert(profileData);
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
