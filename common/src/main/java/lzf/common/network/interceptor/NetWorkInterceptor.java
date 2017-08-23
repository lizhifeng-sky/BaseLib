package lzf.common.network.interceptor;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Administrator on 2017/8/23 0023.
 */
public class NetWorkInterceptor implements Interceptor {
    private Context context;
    private ConnectivityManager connectivityManager;
    /**
     * @author lzf
     * create at 2017/8/23 0023 15:42
     * description
     * @param context 1、用于获取网络状态 2、用于弹窗（如看视频 大流量根据网络状态 给出提示）
     */
    public NetWorkInterceptor(Context context) {
        //避免内存泄漏
        this.context = context.getApplicationContext();
        connectivityManager= (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        NetworkInfo networkInfo=connectivityManager.getActiveNetworkInfo();
        boolean isNetWorkActive=networkInfo!=null&&networkInfo.isConnectedOrConnecting();
        if (isNetWorkActive){
            Request request=chain.request();
            String url=request.url().toString();
            //规则自己定
            if ((url.startsWith("rmtp")||url.endsWith(".m3u8"))
                    &&networkInfo.getType()!=ConnectivityManager.TYPE_WIFI){
                //弹窗提示 看视频耗流量啊
                showDialog(chain);
                return null;
            }
            return chain.proceed(request);
        }else {
            Toast.makeText(context,"当前网络不可用",Toast.LENGTH_SHORT).show();
            return null;
        }
    }

    private void showDialog(Chain chain) {

    }
}
