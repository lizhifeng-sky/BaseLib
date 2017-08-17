package lzf.common.network;

import lzf.common.network.bean.BaseRequestMode;
import rx.Subscriber;

/**
 * Created by Administrator on 2017/8/10 0010.
 */
public abstract class CustomSubscriber<T> extends Subscriber<BaseRequestMode<T>> {

    private boolean showLoadDialog = false;

    public CustomSubscriber() {
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onCompleted() {

    }

    @Override
    public void onError(Throwable e) {

    }

    /*
    * final修饰方法
    * */
    @Override
    final public void onNext(BaseRequestMode<T> tBaseRequestMode) {
        onSuccess(tBaseRequestMode.getData());
    }

    public abstract void onSuccess(T t);

}
