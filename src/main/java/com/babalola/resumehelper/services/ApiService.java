package main.java.com.babalola.resumehelper.services;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ProtocolException;

public interface ApiService {

    public String getNewResume(String oldResume, String jobDescription, String role) throws IOException;
}
