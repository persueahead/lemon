package com.blog.ln.dao;

import com.blog.ln.bean.MessageInfo;

public interface MessageInfoMapper {
    int deleteByPrimaryKey(Integer messageId);

    int insert(MessageInfo record);

    int insertSelective(MessageInfo record);

    MessageInfo selectByPrimaryKey(Integer messageId);

    int updateByPrimaryKeySelective(MessageInfo record);

    int updateByPrimaryKey(MessageInfo record);
}