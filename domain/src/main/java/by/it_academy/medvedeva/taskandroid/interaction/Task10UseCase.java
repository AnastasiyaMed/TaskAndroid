package by.it_academy.medvedeva.taskandroid.interaction;


import java.util.concurrent.TimeUnit;

import by.it_academy.medvedeva.taskandroid.interaction.base.UseCase;
import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;

/**
 * Created by Medvedeva Anastasiya
 * on 24.08.2017.
 */

public class Task10UseCase extends UseCase<Long, Integer> {

    @Override
    protected Observable<Integer> buildUseCase(Long aLong) {
        return Observable.interval(1, TimeUnit.SECONDS)
                .filter(new Predicate<Long>() {
                    @Override
                    public boolean test(@NonNull Long aLong1) throws Exception {
                        return aLong1 % 2 == 0;
                    }
                })
                .map(new Function<Long, Integer>() {
                    @Override
                    public Integer apply(@NonNull Long aLong1) throws Exception {
                        return aLong1.intValue();
                    }
                });

    }
}
