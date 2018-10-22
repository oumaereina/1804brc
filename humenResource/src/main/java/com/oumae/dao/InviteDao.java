package com.oumae.dao;

import com.oumae.model.Invite;

import java.util.List;

/**
 * Created by oumaereina on 2018/10/22.
 */
public interface InviteDao {
    Integer insertInvite(Invite invite);
    Integer updateInvite(Invite invite);
    List<Invite> selectInviteByVid(Integer I_VID);
    Invite selectById(Integer I_ID);
}
