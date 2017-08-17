package lzf.common.network;

import lzf.common.network.bean.BaseRequestMode;
import rx.Observable;

/**
 * Created by Administrator on 2017/8/11 0011.
 */
public class SchedulesTransformer<T> extends ScheduleTransformer<BaseRequestMode<T>> {
    @Override
    public Observable<BaseRequestMode<T>> call(Observable<BaseRequestMode<T>> observable) {
        return super.call(observable);
    }
}
