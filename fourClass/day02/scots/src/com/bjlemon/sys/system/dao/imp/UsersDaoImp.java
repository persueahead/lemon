package com.bjlemon.sys.system.dao.imp;

import com.bjlemon.pojo.Users;
import com.bjlemon.sys.system.dao.IUsersDao;
import com.bjlemon.utiles.C3p0Util;

public class UsersDaoImp implements IUsersDao {
    /**
     * 用户登录  名称
     * @param tUsers  查询用户条件信息数据对象
     * @return  查询用户的数据的信息对象
     * @throws Exception
     */
    @Override
    public Users loginDao(Users tUsers) throws Exception {
        //查询数据
        String Sql="SELECT u.*,r.roleName  FROM t_users  u  INNER JOIN  t_role  r ON  u.roleId=r.roleId  AND  u.usersAccout=?   AND  u.usersPwd=?  AND  u.usersMrak=?";


        Users users = C3p0Util.queryOne(Sql, Users.class, tUsers.getUsersAccout(), tUsers.getUsersPwd(), tUsers.getUsersMrak());
        return users;
    }

    @Override
    public int updateUsersMessageDao(Users tUsers) throws Exception {

        //SQL
        String  sql="UPDATE  t_users u  SET  u.usersName =?,u.usersAge=?,u.usersSex=?,u.usersPhone=?,u.usersPwd=? WHERE  u.roleId=?";

        int update = C3p0Util.update(sql, tUsers.getUsersName(), tUsers.getUsersAge(), tUsers.getUsersSex(), tUsers.getUsersPhone(), tUsers.getUsersPwd(), tUsers.getUsersId());

        return update;
    }
}
