package lzf.common.network;

import android.os.Environment;

import java.io.File;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 2017/8/10 0010.
 */
public class SingleRetrofit {
    public static final int DEFAULT_TIMEOUT = 5;
    private static APIService apiService;
    private static SingleRetrofit mInstance;

    private SingleRetrofit() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
        File httpCacheDirectory = new File(Environment.getExternalStorageDirectory(), "responses");
        builder.cache(new Cache(httpCacheDirectory,10 * 1024 * 1024));
        Retrofit mRetrofit = new Retrofit.Builder()
                .client(builder.build())
                .baseUrl(APIService.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        apiService = mRetrofit.create(APIService.class);
    }

    public static SingleRetrofit getInstance() {
        if (mInstance == null) {
            synchronized (SingleRetrofit.class) {
                mInstance = new SingleRetrofit();
            }
        }
        return mInstance;
    }

    public static APIService create() {
        getInstance();
        return apiService;
    }
}
