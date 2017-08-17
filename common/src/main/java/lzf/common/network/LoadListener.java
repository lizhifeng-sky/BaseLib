package lzf.common.network;

/**
 * Created by Administrator on 2017/8/10 0010.
 */
public interface LoadListener {
    void onStart();
    void onSuccess();
    void onFail();
}
