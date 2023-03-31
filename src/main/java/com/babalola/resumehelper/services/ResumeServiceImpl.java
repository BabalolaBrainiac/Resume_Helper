package main.java.com.babalola.resumehelper.services;

import main.java.com.babalola.resumehelper.dto.ResumeDto;
import main.java.com.babalola.resumehelper.entities.Resume;
import org.springframework.stereotype.Service;


@Service
public class ResumeServiceImpl implements ResumeService {

    @Override
    public Resume newResume(ResumeDto resumeDto) {
        return Resume.builder()
                .name(resumeDto.getName())
                .content(resumeDto.getContent())
                .build();
    }
}
