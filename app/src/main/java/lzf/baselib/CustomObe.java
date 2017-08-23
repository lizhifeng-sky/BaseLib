package lzf.baselib;

import rx.Observable;

/**
 * Created by Administrator on 2017/8/22 0022.
 */
public class CustomObe<T> extends Observable<T> {
    /**
     * Creates an Observable with a Function to execute when it is subscribed to.
     * <p>
     * <em>Note:</em> Use {@link #create(OnSubscribe)} to create an Observable, instead of this constructor,
     * unless you specifically have a need for inheritance.
     *
     * @param f {@link OnSubscribe} to be executed when {@link #subscribe(Subscriber)} is called
     */
    protected CustomObe(OnSubscribe<T> f) {
        super(f);
    }
    public void start(){

    }
}
