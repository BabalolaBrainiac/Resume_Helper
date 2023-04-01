package main.java.com.babalola.resumehelper.openai;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class AuthenticationInterceptor implements Interceptor {

    private final String token;

    public AuthenticationInterceptor(String token) {
        this.token = token;
    }

    public Response intercept(okhttp3.Interceptor.Chain chain) throws IOException {
        Request request = chain.request()
                .newBuilder()
                .header("Authorization", "Bearer " + token)
                .build();
        return chain.proceed(request);
    }
}
