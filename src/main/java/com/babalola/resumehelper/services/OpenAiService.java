package main.java.com.babalola.resumehelper.services;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Single;
import main.java.com.babalola.resumehelper.openai.AuthenticationInterceptor;
import main.java.com.babalola.resumehelper.openai.utils.basics.CompletionRequest;
import main.java.com.babalola.resumehelper.openai.utils.basics.CompletionResult;
import main.java.com.babalola.resumehelper.openai.utils.chat.OpenAiCompletionRequest;
import main.java.com.babalola.resumehelper.openai.utils.chat.OpenAiCompletionResponse;
import okhttp3.ConnectionPool;
import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static java.time.Duration.ofSeconds;

public class OpenAiService implements OpenAiApi {

    private static final String BASE_URL = "https://api.openai.com/";

    final OpenAiApi api;

    public OpenAiService(final String token) {
        this(token, BASE_URL, ofSeconds(10));
    }

    @Deprecated
    public OpenAiService(final String token, final int timeout) {
        this(token, BASE_URL, ofSeconds(timeout));
    }

    public OpenAiService(final String token, final String baseUrl, final Duration timeout) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        mapper.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);

        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(new AuthenticationInterceptor(token))
                .connectionPool(new ConnectionPool(5, 1, TimeUnit.SECONDS))
                .readTimeout(timeout.toMillis(), TimeUnit.MILLISECONDS)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(client)
                .addConverterFactory(JacksonConverterFactory.create(mapper))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        this.api = retrofit.create(OpenAiApi.class);
    }


    @Override
    public @NonNull CompletionResult createCompletion(CompletionRequest request) {
        return api.createCompletion(request);
    }

    @Override
    public Call<ResponseBody> createCompletionStream(CompletionRequest request) {
        return null;
    }

    @Override
    public Single<OpenAiCompletionResponse> createChatCompletion(OpenAiCompletionRequest.ChatCompletionRequest request) {
        return null;
    }

    @Override
    public Call<ResponseBody> createChatCompletionStream(OpenAiCompletionRequest.ChatCompletionRequest request) {
        return null;
    }
}
