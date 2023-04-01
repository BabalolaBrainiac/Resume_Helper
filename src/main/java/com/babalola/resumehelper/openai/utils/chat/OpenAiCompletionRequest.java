package main.java.com.babalola.resumehelper.openai.utils.chat;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

public class OpenAiCompletionRequest {

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public class ChatCompletionRequest {


        String model;

        List<OpenAiMessage> messages;

        Double temperature;

        @JsonProperty("top_p")
        Double topP;

        Integer n;

        Boolean stream;

        List<String> stop;

        @JsonProperty("max_tokens")
        Integer maxTokens;

        @JsonProperty("presence_penalty")
        Double presencePenalty;

        @JsonProperty("frequency_penalty")
        Double frequencyPenalty;

        @JsonProperty("logit_bias")
        Map<String, Integer> logitBias;

        String user;
    }
}
