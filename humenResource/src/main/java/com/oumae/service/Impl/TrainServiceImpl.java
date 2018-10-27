package com.oumae.service.Impl;

import com.oumae.dao.TrainDao;
import com.oumae.model.Emp;
import com.oumae.model.Train;
import com.oumae.service.TrainService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by oumaereina on 2018/10/26.
 */
@Service
public class TrainServiceImpl implements TrainService{
    @Resource
    private TrainDao trainDao;
    public Train selectById(Integer t_id) {
        if(t_id!=null){
            Train train = trainDao.selectById(t_id);
            return train;
        }
        return null;
    }

    public List<Train> selectAll() {
        List<Train> trains = trainDao.selectAll();
        return trains;
    }


    public boolean insertTrain(Train train) {
        if(train!=null){
            Integer integer = trainDao.insertTrain(train);
            if(integer==1){
                return true;
            }
        }
        return false;
    }

    public boolean deleteTrain(Integer t_id) {
        if(t_id!=null){
            Integer integer = trainDao.deleteTrain(t_id);
            if(integer==1){
                return true;
            }
        }
        return false;
    }

    public boolean updateTrain(Train train) {
        if(train!=null){
            Integer integer = trainDao.updateTrain(train);
            if(integer==1){
                return true;
            }
        }
        return false;
    }
}
