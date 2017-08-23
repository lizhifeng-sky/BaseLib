package lzf.common.network;

import lzf.common.network.bean.BaseRequestMode;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Administrator on 2017/8/11 0011.
 */
public class ScheduleTransformer<T> implements Observable.Transformer<BaseRequestMode<T>,BaseRequestMode<T>> {

    @Override
    public Observable<BaseRequestMode<T>> call(Observable<BaseRequestMode<T>> baseRequestModeObservable) {
        return baseRequestModeObservable.subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
