package main.java.com.babalola.resumehelper.services;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Single;
import main.java.com.babalola.resumehelper.openai.utils.basics.CompletionRequest;
import main.java.com.babalola.resumehelper.openai.utils.basics.CompletionResult;
import main.java.com.babalola.resumehelper.openai.utils.chat.OpenAiCompletionRequest;
import main.java.com.babalola.resumehelper.openai.utils.chat.OpenAiCompletionResponse;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Streaming;

public interface OpenAiApi {

    @POST("/v1/completions")
    @NonNull
    CompletionResult createCompletion(@Body CompletionRequest request);

    @Streaming
    @POST("/v1/completions")
    Call<ResponseBody> createCompletionStream(@Body CompletionRequest request);

    @POST("/v1/chat/completions")
    Single<OpenAiCompletionResponse> createChatCompletion(@Body OpenAiCompletionRequest.ChatCompletionRequest request);

    @Streaming
    @POST("/v1/chat/completions")
    Call<ResponseBody> createChatCompletionStream(@Body OpenAiCompletionRequest.ChatCompletionRequest request);


}
