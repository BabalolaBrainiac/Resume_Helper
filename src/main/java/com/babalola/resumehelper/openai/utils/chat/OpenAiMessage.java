package main.java.com.babalola.resumehelper.openai.utils.chat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class OpenAiMessage {

        String role;
        String content;

}
