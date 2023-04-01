package main.java.com.babalola.resumehelper.openai;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Usage {

    @JsonProperty("prompt_tokens")
    long promptTokens;


    @JsonProperty("completion_tokens")
    long completionTokens;

    @JsonProperty("total_tokens")
    long totalTokens;
}
