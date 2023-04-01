package main.java.com.babalola.resumehelper.openai;

import lombok.Data;

import java.util.List;

@Data
public class OpenAiResponse<T> {

    public List<T> data;

    public String object;
}
