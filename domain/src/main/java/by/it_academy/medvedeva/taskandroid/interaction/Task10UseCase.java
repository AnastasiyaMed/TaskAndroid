package by.it_academy.medvedeva.taskandroid.interaction;


import java.util.concurrent.TimeUnit;

import by.it_academy.medvedeva.taskandroid.interaction.base.UseCase;
import io.reactivex.Observable;

/**
 * Created by Medvedeva Anastasiya
 * on 24.08.2017.
 */

public class Task10UseCase extends UseCase<Long, Integer> {

    @Override
    protected Observable<Integer> buildUseCase(Long aLong) {
        return Observable.interval(1, TimeUnit.SECONDS)
                .filter(aLong1 -> aLong1 % 2 == 0)
                .map(Long::intValue);

    }
}
