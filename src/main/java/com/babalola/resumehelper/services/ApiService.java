package main.java.com.babalola.resumehelper.services;

import io.reactivex.rxjava3.core.Single;
import main.java.com.babalola.resumehelper.openai.utils.basics.CompletionRequest;
import main.java.com.babalola.resumehelper.openai.utils.basics.CompletionResult;
import main.java.com.babalola.resumehelper.openai.utils.chat.OpenAiCompletionRequest;
import main.java.com.babalola.resumehelper.openai.utils.chat.OpenAiCompletionResponse;
import okhttp3.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import retrofit2.Call;
import retrofit2.http.Body;

public interface ApiService {
    Single<CompletionResult> createCompletionFromPDF(@Body MultipartFile file, String jobDescription, String rol);

    Call<ResponseBody> createCompletionStream(@Body CompletionRequest request);

    Single<OpenAiCompletionResponse> createChatCompletion(@Body OpenAiCompletionRequest.ChatCompletionRequest request);

    Call<ResponseBody> createChatCompletionStream(@Body OpenAiCompletionRequest.ChatCompletionRequest request);
}
