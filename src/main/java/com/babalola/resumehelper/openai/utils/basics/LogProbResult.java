package main.java.com.babalola.resumehelper.openai.utils.basics;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class LogProbResult {


    List<String> tokens;


    @JsonProperty("token_logprobs")
    List<Double> tokenLogprobs;

    @JsonProperty("top_logprobs")
    List<Map<String, Double>> topLogprobs;

    List<Integer> textOffset;
}

