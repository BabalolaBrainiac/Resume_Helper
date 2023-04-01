package main.java.com.babalola.resumehelper.openai.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OpenAiError {

    public OpenAiErrorDetails error;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class OpenAiErrorDetails {

       public String message;

       public String type;

        public String param;

        public String code;
    }
}
