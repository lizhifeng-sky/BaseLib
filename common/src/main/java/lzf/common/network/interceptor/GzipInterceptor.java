package lzf.common.network.interceptor;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okio.BufferedSink;
import okio.GzipSink;
import okio.Okio;

/**
 * Created by Administrator on 2017/8/23 0023.
 */
public class GzipInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request originRequest = chain.request();
        if (originRequest.body() == null || originRequest.header("Content-Encoding") != null) {
            return chain.proceed(originRequest);
        }
        Request compressRequest = originRequest.newBuilder()
                .header("Content-Encoding", "gzip")
                .method(originRequest.method(), gzip(originRequest.body()))
                .build();
        return chain.proceed(compressRequest);
    }

    private RequestBody gzip(final RequestBody body) {
        return new RequestBody() {
            @Override
            public MediaType contentType() {
                return body.contentType();
            }

            @Override
            public long contentLength() throws IOException {
                return super.contentLength();
            }

            @Override
            public void writeTo(BufferedSink sink) throws IOException {
                BufferedSink gzipSink = Okio.buffer(new GzipSink(sink));
                body.writeTo(gzipSink);
                gzipSink.close();
            }
        };

    }
}
