package com.taotao.sso.query.service;

import com.taotao.sso.query.bean.User;

public interface UserQueryService {

    /**
     * ����token��ѯUser����
     * 
     * @return
     */
    public User queryUserByToken(String token);

}
