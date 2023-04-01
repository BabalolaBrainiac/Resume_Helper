package main.java.com.babalola.resumehelper.openai.utils;

import lombok.Data;

@Data
public class DeleteResult {
    String id;

    String object;

    boolean deleted;
}