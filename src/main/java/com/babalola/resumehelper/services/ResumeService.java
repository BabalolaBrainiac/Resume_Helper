package main.java.com.babalola.resumehelper.services;

import main.java.com.babalola.resumehelper.dto.ResumeDto;
import main.java.com.babalola.resumehelper.entities.Resume;

public interface ResumeService {
    public Resume newResume(ResumeDto resumeDto);
}
