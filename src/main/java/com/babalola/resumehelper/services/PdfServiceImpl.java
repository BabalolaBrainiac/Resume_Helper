package main.java.com.babalola.resumehelper.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.type.MapType;
import io.github.jonathanlink.PDFLayoutTextStripper;
import org.apache.pdfbox.io.RandomAccessFile;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.text.PDFTextStripper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Map;


@Service
public class PdfServiceImpl implements PdfService {
    private Path fileStorageLocation;

    private String getFileExtension(String fileName) {
        if (fileName == null) {
            return null;
        }
        String[] fileNameParts = fileName.split("\\.");

        return fileNameParts[fileNameParts.length - 1];
    }

    @Autowired
    public void FileStorageService(Environment env) {
        this.fileStorageLocation = Paths.get(env.getProperty("app.file.upload-dir", "./uploads/files"))
                .toAbsolutePath().normalize();

        try {

            Files.createDirectories(this.fileStorageLocation);
        } catch (Exception ex) {
            throw new RuntimeException(
                    "Could not create the directory where the uploaded files will be stored.", ex);
        }
    }

    @Override
    public String extractFileFromPdf(MultipartFile file) throws IOException {
        try {

            String fileName = file.getOriginalFilename();

            Path targetLocation = fileStorageLocation.resolve(fileName);
            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);

            PDFParser pdfParser = new PDFParser(new RandomAccessFile(new File("uploads/files/" + fileName), "r"));
            pdfParser.parse();
            PDDocument pdDocument = new PDDocument(pdfParser.getDocument());
            PDFTextStripper pdfTextStripper = new PDFLayoutTextStripper();
            String string = pdfTextStripper.getText(pdDocument);

            return string;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String createPdf(String text) {

        try (PDDocument document = new PDDocument()) {

            File jsonFile = new File("./resource/test.json").getAbsoluteFile();

            ObjectMapper mapper = new ObjectMapper();
            mapper.enable(SerializationFeature.INDENT_OUTPUT);

            MapType mapType = mapper.getTypeFactory().constructMapType(Map.class, String.class, Object.class);
            Map<String, Object> map = mapper.readValue(jsonFile, mapType);


            String json = mapper.writeValueAsString(map);

            String[] strings = json.split(System.lineSeparator());


            PDPage page = new PDPage();
            document.addPage(page);


            try (PDPageContentStream cont = new PDPageContentStream(document, page)) {
                cont.beginText();
                cont.setFont(PDType1Font.TIMES_ROMAN, 12);
                cont.setLeading(14.5f);
                cont.newLineAtOffset(25, 700);

                for (String string : strings) {
                    cont.showText(string);
                    cont.newLine();
                }
                cont.endText();
                cont.close();

                document.save("filename");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
