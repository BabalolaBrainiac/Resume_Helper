package main.java.com.babalola.resumehelper.openai.utils.chat;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;


@Data
public class OpenAiCompletionChoice  {

    Integer index;

    @JsonAlias("delta")
    OpenAiMessage message;


    @JsonProperty("finish_reason")
    String finishReason;
}
