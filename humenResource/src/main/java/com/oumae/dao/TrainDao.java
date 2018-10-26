package com.oumae.dao;

import com.oumae.model.Emp;
import com.oumae.model.Train;

import java.util.List;

/**
 * Created by oumaereina on 2018/10/26.
 */
public interface TrainDao {
    Train selectById(Integer t_id);
    List<Emp> selectByTid(Integer t_id);
    Integer insertTrain(Train train);
    Integer deleteTrain(Integer t_id);
    Integer updateTrain(Train train);
}
