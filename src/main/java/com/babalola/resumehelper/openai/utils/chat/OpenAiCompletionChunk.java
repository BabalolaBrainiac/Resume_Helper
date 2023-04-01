package main.java.com.babalola.resumehelper.openai.utils.chat;

import lombok.Data;

import java.util.List;

@Data
public class OpenAiCompletionChunk {

    String id;

    String object;

    long created;

    String model;

    List<OpenAiCompletionChoice> choices;
}
