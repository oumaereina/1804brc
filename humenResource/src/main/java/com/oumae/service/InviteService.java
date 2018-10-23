package com.oumae.service;

import com.oumae.model.Invite;

import java.util.List;

/**
 * Created by oumaereina on 2018/10/22.
 */
public interface InviteService {
    boolean insertInvite(Invite invite);
    boolean updateInvite(Invite invite);
    List<Invite> selectInviteByVid(Integer I_VID);
    Invite selectById(Integer I_ID);
    List<Invite> selectInviteByState(Integer I_STATE);
}
