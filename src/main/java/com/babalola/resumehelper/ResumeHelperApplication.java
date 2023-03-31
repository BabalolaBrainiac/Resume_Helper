package main.java.com.babalola.resumehelper;

import main.java.com.babalola.resumehelper.controllers.PdfExtractorController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class ResumeHelperApplication {

    public static void main(String[] args) {
        SpringApplication.run(ResumeHelperApplication.class, args);
    }

}
