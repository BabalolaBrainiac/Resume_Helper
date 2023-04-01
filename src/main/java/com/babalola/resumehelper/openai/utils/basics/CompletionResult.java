package main.java.com.babalola.resumehelper.openai.utils.basics;


import lombok.Data;
import main.java.com.babalola.resumehelper.openai.Usage;

import java.util.List;

@Data
public class CompletionResult {

    String id;

    String object;

    long created;

    String model;

    List<CompletionChoice> choices;

    Usage usage;
}
