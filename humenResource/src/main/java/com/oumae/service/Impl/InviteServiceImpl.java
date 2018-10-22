package com.oumae.service.Impl;

import com.oumae.dao.InviteDao;
import com.oumae.model.Invite;
import com.oumae.service.InviteService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by oumaereina on 2018/10/22.
 */
@Service
public class InviteServiceImpl implements InviteService{
    @Resource
    private InviteDao inviteDao;
    public boolean insertInvite(Invite invite) {
        if(invite!=null){
            Integer integer = inviteDao.insertInvite(invite);
            if(integer==1){
                return true;
            }
        }
        return false;
    }

    public boolean updateInvite(Invite invite) {
        if(invite!=null){
            Integer integer = inviteDao.updateInvite(invite);
            if(integer==1){
                return true;
            }
        }
        return false;
    }

    public List<Invite> selectInviteByVid(Integer I_VID) {
        List<Invite> invites = inviteDao.selectInviteByVid(I_VID);
        if(invites!=null){
            return invites;
        }
        return null;
    }

    public Invite selectById(Integer I_ID) {
        Invite invite = inviteDao.selectById(I_ID);
        return invite;
    }
}
