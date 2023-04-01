package main.java.com.babalola.resumehelper.services;

import io.reactivex.rxjava3.core.Single;
import main.java.com.babalola.resumehelper.openai.utils.basics.CompletionRequest;
import main.java.com.babalola.resumehelper.openai.utils.basics.CompletionResult;
import main.java.com.babalola.resumehelper.openai.utils.chat.OpenAiCompletionRequest;
import main.java.com.babalola.resumehelper.openai.utils.chat.OpenAiCompletionResponse;
import okhttp3.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import retrofit2.Call;

import java.io.IOException;


@Service
public class ApiServiceImpl implements ApiService {
    @Autowired
    PdfServiceImpl pdfService;
    @Value("${openaiuri}")
    private String openAiUrl;
    OpenAiService openAiService = new OpenAiService(this.openAiUrl);

    public ApiServiceImpl(PdfServiceImpl pdfService) {
        this.pdfService = pdfService;
    }

    @Override
    public Single<CompletionResult> createCompletionFromPDF(MultipartFile file, String jobDescription, String role) {
        CompletionRequest request = new CompletionRequest();
        try {

            String oldResume = this.pdfService.extractFileFromPdf(file);
//
//            System.out.println(oldResume);
//            System.out.println(jobDescription);
//            System.out.println(role);

            String requestParam = "Edit this resume" + oldResume + ":" + "Ensure that it is SEO optimized, and also is ATS compliant" +
                    " for the role of " + role + "whose job description is " + ":"
                    + jobDescription;

            request.setPrompt(requestParam);

            CompletionRequest completionRequest = CompletionRequest.builder()
                    .prompt(request.getPrompt())
                    .model(request.getModel())
                    .echo(true)
                    .build();
            this.openAiService.createCompletion(completionRequest).getChoices().forEach(System.out::println);
//
            return null;

        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

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
