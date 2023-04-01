package main.java.com.babalola.resumehelper.openai.utils.basics;


import lombok.Data;

@Data
public class CompletionChoice {

    String text;

    Integer index;
    
    LogProbResult logprobs;

    String finish_reason;
}
