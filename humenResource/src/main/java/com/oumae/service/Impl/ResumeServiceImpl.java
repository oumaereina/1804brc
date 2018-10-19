package com.oumae.service.Impl;

import com.oumae.dao.ResumeDao;
import com.oumae.model.Resume;
import com.oumae.service.ResumeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by oumaereina on 2018/10/19.
 */
@Service
public class ResumeServiceImpl implements ResumeService{
    @Resource
    private ResumeDao resumeDao;
    public boolean insertResume(Resume resume) {
        return false;
    }

    public boolean deleteResumeById(Integer r_id) {
        return false;
    }

    public boolean updateResumeById(Resume resume) {
        return false;
    }

    public List<Resume> selectResumeByVid(Integer r_vid) {
        return null;
    }
}
