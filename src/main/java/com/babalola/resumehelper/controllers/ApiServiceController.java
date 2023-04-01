package main.java.com.babalola.resumehelper.controllers;


import main.java.com.babalola.resumehelper.openai.utils.basics.CompletionResult;
import main.java.com.babalola.resumehelper.services.ApiServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class ApiServiceController {
    @Autowired
    private final ApiServiceImpl apiService;

    public ApiServiceController(ApiServiceImpl apiService) {
        this.apiService = apiService;
    }

    @PostMapping("/completion")
    public CompletionResult createCompletion(
            @RequestBody MultipartFile file,
            @RequestParam("jobDescription") String jobDescription,
            @RequestParam("name") String role
    ) {

        CompletionResult result = this.apiService.createCompletionFromPDF(file, jobDescription, role).blockingGet();
        System.out.println(result);
        return result;
    }
}
