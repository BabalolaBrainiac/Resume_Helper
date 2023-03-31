package main.java.com.babalola.resumehelper.controllers;

import main.java.com.babalola.resumehelper.services.PdfServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

@Controller
public class PdfExtractorController {
        @Autowired
        private PdfServiceImpl pdfService;

        @PostMapping("/upload")
        public ResponseEntity<String> uploadAndExtractResumeDataFromPDF(@RequestBody MultipartFile file) throws IOException {



            String data = pdfService.extractFileFromPdf(file);
            return ResponseEntity.ok(data);
        }


    @PostMapping("/create")
    public ResponseEntity<String> createPdfFromResponse(@RequestBody MultipartFile file) throws IOException {


        String data = pdfService.extractFileFromPdf(file);
        return ResponseEntity.ok(data);
    }


}

