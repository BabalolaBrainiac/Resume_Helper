package main.java.com.babalola.resumehelper.services;

import main.java.com.babalola.resumehelper.enums.PdfFontEnum;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public interface PdfService {
   public String extractFileFromPdf(MultipartFile file) throws IOException;

   public String createPdf(String text);
}
