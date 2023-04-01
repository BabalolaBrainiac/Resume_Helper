package main.java.com.babalola.resumehelper.openai.utils.chat;


import lombok.Data;
import main.java.com.babalola.resumehelper.openai.Usage;

import java.util.List;

@Data
public class OpenAiCompletionResponse {

    String id;

    String object;


    long created;


    String model;

    List<OpenAiCompletionChoice> choices;

    /**
     * The API usage for this request.
     */
    Usage usage;
}
