package main.java.com.babalola.resumehelper.openai.utils.basics;

import lombok.Data;

import java.util.List;

@Data
public class CompletionChunk {

    String id;

    String object;

    long created;

    String model;

    List<CompletionChoice> choices;
}
