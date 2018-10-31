package com.oumae.service.Impl;

import com.oumae.dao.ResumeDao;
import com.oumae.model.Resume;
import com.oumae.model.Reward;
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
        if(resume!=null){
            Integer row = resumeDao.insertResume(resume);
            if(row==1){
                return true;
            }
        }
        return false;
    }

    public boolean deleteResumeById(Integer r_id) {
        if(r_id!=null){
            Integer row = resumeDao.deleteResumeById(r_id);
            if(row==1){
                return true;
            }
        }
        return false;
    }

    public boolean updateResumeById(Resume resume) {
        if(resume!=null){
            Integer row = resumeDao.updateResumeById(resume);
            if(row==1){
                return true;
            }
        }
        return false;
    }

    public List<Resume> selectResumeByVid(Integer r_vid) {
        if(r_vid!=null){
            List<Resume> resumes = resumeDao.selectResumeByVid(r_vid);
            return resumes;
        }
        return null;
    }

    public List<Resume> selectResumeByState(Integer r_state) {
        if(r_state!=null){
            List<Resume> resumes = resumeDao.selectResumeByState(r_state);
            return resumes;
        }
        return null;
    }

}
