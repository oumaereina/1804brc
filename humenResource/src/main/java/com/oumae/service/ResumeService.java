package com.oumae.service;

import com.oumae.model.Resume;

import java.util.List;

/**
 * Created by oumaereina on 2018/10/19.
 */
public interface ResumeService {
    boolean insertResume(Resume resume);
    boolean deleteResumeById(Integer r_id);
    boolean updateResumeById(Resume resume);
    List<Resume> selectResumeByVid(Integer r_vid);
}
