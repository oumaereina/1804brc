package com.oumae.dao;

import com.oumae.model.Resume;

import java.util.List;

/**
 * Created by oumaereina on 2018/10/19.
 */
public interface ResumeDao {
    Integer insertResume(Resume resume);
    Integer deleteResumeById(Integer r_id);
    Integer updateResumeById(Resume resume);
    List<Resume> selectResumeByVid(Integer r_vid);
}
