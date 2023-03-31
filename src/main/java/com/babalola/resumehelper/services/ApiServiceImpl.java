package main.java.com.babalola.resumehelper.services;

import com.fasterxml.jackson.databind.exc.InvalidDefinitionException;
import jdk.jshell.spi.ExecutionControl;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;


@Service
public class ApiServiceImpl implements ApiService  {

    private final String  openAiUrl = "https://api.openai.com/v1/completions";

    public ApiServiceImpl() throws MalformedURLException {
    }

    @Override
    public String getNewResume(String oldResume, String jobDescription, String role) throws IOException {

        String requestParam = "Edit this resume" + oldResume +":"+  "Ensure that it is SEO optimized, and also is ATS compliant" +
                " for the role of " + role + "whose job description is " + ":"
                + jobDescription;
        URL url = new URL(openAiUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Authorization","Bearer ");
        connection.setRequestProperty("Accept", "application/json");
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setDoOutput(true);

        try (OutputStream os = connection.getOutputStream()) {
            byte[] input = requestParam.getBytes("utf-8");
            os.write(input, 0, input.length);
        }

        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(connection.getInputStream(), "utf-8"))) {
            StringBuilder response = new StringBuilder();
            String responseLine = null;
            while ((responseLine = br.readLine()) != null) {
                response.append(responseLine.trim());
            }
            System.out.println(response);

            return response.toString();
        }

        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
