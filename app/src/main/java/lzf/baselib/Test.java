package lzf.baselib;

import lzf.common.network.APIService;
import lzf.common.network.CustomSubscriber;
import lzf.common.network.ScheduleTransformer;
import lzf.common.network.SingleRetrofit;
import lzf.common.network.bean.BaseRequestMode;
import rx.Observable;

/**
 * Created by Administrator on 2017/8/23 0023.
 */
public class Test<T> {
    APIService apiService = SingleRetrofit.create();
    private Observable<BaseRequestMode<T>> observable;
    public  static <T> Test<T> create() {
        return new Test<>();
    }
    public Test<T> addObservable(Observable<BaseRequestMode<T>> observable) {
        this.observable = observable;
        return this;
    }
    public Test<T> getData(CustomSubscriber<T> customSubscriber) {
        if (observable!=null) {
            this.observable.compose(new ScheduleTransformer<T>())
                    .subscribe(customSubscriber);
        }
        return this;
    }
}
