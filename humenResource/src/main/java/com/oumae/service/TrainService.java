package com.oumae.service;

import com.oumae.model.Emp;
import com.oumae.model.Train;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by oumaereina on 2018/10/26.
 */
public interface TrainService {
    Train selectById(Integer t_id);
    List<Train> selectAll();
    boolean insertTrain(Train train);
    boolean deleteTrain(Integer t_id);
    boolean updateTrain(Train train);
}
