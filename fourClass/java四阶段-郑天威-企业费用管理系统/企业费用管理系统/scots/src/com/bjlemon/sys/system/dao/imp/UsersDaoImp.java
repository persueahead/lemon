package com.bjlemon.sys.system.dao.imp;

import com.bjlemon.pojo.Menu;
import com.bjlemon.pojo.Salary;
import com.bjlemon.pojo.Users;
import com.bjlemon.sys.system.dao.IUsersDao;
import com.bjlemon.utiles.C3p0Util;
import com.bjlemon.utiles.ThisCode;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class UsersDaoImp implements IUsersDao {
    /**
     * 用户登录  名称
     *
     * @param tUsers 查询用户条件信息数据对象
     * @return 查询用户的数据的信息对象
     * @throws Exception
     */
    @Override
    public Users loginDao(Users tUsers) throws Exception {
        //查询数据
        String Sql = "SELECT u.*,r.roleName  FROM t_users  u  INNER JOIN  t_role  r ON  u.roleId=r.roleId  AND  u.usersAccount=?   AND  u.usersPwd=?  AND  u.usersMark=?";
//      女	18	213213232	jack	jack	4000	0	经理
        Users users = C3p0Util.queryOne(Sql, Users.class, tUsers.getUsersAccount(), tUsers.getUsersPwd(), tUsers.getUsersMark());
        System.out.println("查询所有后mark：" + users.getUsersMark());
        return users;
    }

    /**
     * 更新用户信息
     * @param tUsers
     * @return
     * @throws Exception
     */
    @Override
    public int updateUsersMessageDao(Users tUsers) throws Exception {

        //SQL update 表名 set 列=值，列=值？.....更新想要更新的
        String sql = "UPDATE  t_users u  SET  u.usersName =?,u.usersAge=?,u.usersSex=?,u.usersPhone=?,u.usersPwd=? WHERE  u.roleId=?";

        int update = C3p0Util.update(sql, tUsers.getUsersName(), tUsers.getUsersAge(), tUsers.getUsersSex(), tUsers.getUsersPhone(), tUsers.getUsersPwd(), tUsers.getUsersId());

        return update;
    }

    /**
     * 通过角色id查询权限
     * @param roleId
     * @return
     * @throws Exception
     */
    @Override
    public List<Menu> selectMenuDao(Integer roleId) throws Exception {
        String sql = "SELECT  m.*   FROM  t_role_menu  rm INNER JOIN  t_menu m on\n" +
                " rm.menuId=m.menuId AND   rm.roleId=? ";
        List<Menu> menuList = C3p0Util.queryList(sql, Menu.class, roleId);
        return menuList;
    }

    /**
     * 添加用户
     * @param tUsers
     * @return
     * @throws Exception
     */

    @Override
    public int addUsersDao(Users tUsers) throws Exception {
        String sql = "INSERT  INTO t_users (roleId,usersName,usersAge,usersPhone,usersSalary,usersAccount,usersSex,usersPwd)\n" +
                " VALUES (?,?,?,?,?,?,?,?)";
//            接收是否成功数值指标
        int update = C3p0Util.update(sql, tUsers.getRoleId(), tUsers.getUsersName(), tUsers.getUsersAge(), tUsers.getUsersPhone(),
                tUsers.getUsersSalary(), tUsers.getUsersAccount(), tUsers.getUsersSex(), tUsers.getUsersPwd());
        return update;
    }

    /**
     * 条件查询
     * @param o
     * @return
     * @throws Exception
     */
    @Override
    public List<Users> selectListUsers(Users o) throws Exception {
        //string
        //String  sql="SELECT u.*,r.roleName  FROM t_users  u  INNER JOIN  t_role  r ON  u.roleId=r.roleId    AND  u.usersMrak=?";
        //条件性的模糊查询    用户 角色
        StringBuffer sql = new StringBuffer("SELECT u.*,r.roleName  FROM t_users  u  INNER JOIN  t_role  r ON  u.roleId=r.roleId    AND  u.usersMark=?");
//       用来装参数
        ArrayList<Object> objects = new ArrayList<>();
        objects.add(ThisCode.OBJ_CODE);

        //使用if语句进行判断，条件查询    id是否有值 有就在sql上加上去
        if (o.getUsersId() != null && o.getUsersId() != 0) {
            sql.append("   AND u.usersId=?");
            objects.add(o.getUsersId());

        }
//        if判断    条件查询  名称是否有值 有就在sql上加上去
        if (o.getUsersName() != null && !"".equals(o.getUsersName())) {
            sql.append("  AND  u.usersName LIKE  ?");
            objects.add("%" + o.getUsersName() + "%");
        }
        //都没有 则就是SELECT u.*,r.roleName  FROM t_users  u  INNER JOIN  t_role  r ON  u.roleId=r.roleId    AND  u.usersMark=? 只需要一个参数
        return C3p0Util.queryList(sql.toString(), Users.class, objects.toArray());
    }

    /**
     * 删除
     * @param users
     * @return
     * @throws Exception
     */
    @Override
    public int delUsersDao(Users users) throws Exception {
        //进行删除用户的,
        //注意，由于可以进行材删除多个用户,那么这里就需要事务，

        //所有的删除都是假删除，没有真删除.。说白了就是修改的语句
        Connection conn = null;
        int j = 0;
        try {
            conn = C3p0Util.getConn();
            QueryRunner queryRunner = new QueryRunner();

            //手动的提交
            conn.setAutoCommit(false);
//            删除就是修改数据  通过id将matk设置为1
            String sql = "UPDATE t_users u  SET u.usersMark=? WHERE u.usersId=?";
//          getCk里面input框属性全是ids 它的值全是编号RequestBeanUtil封装的时候装入了属性ids数组
            Integer[] ids = users.getIds();
//            每次更改一条
            for (int i = 0; i < ids.length; i++) {
                j += queryRunner.update(conn, sql, ThisCode.NO_CODE, ids[i]);
            }
            //手动提交
            conn.commit();
            conn.setAutoCommit(true);
        } catch (Exception e) {
            conn.rollback();
            e.printStackTrace();
        }
        return j;
    }

    /**
     * 修改员工信息
     * @param users
     * @return
     * @throws Exception
     */
    @Override
    public int updateUsersDao(Users users) throws Exception {
        //SQL
        String sql = "UPDATE  t_users u  SET  u.usersName =?,u.usersAge=?,u.usersSex=?" +
                " ,u.usersPhone=?,u.usersPwd=?,roleId=?,usersSalary=? WHERE  u.usersId=? ";

        int update = C3p0Util.update(sql, users.getUsersName(), users.getUsersAge(), users.getUsersSex(), users.getUsersPhone()
                , users.getUsersPwd(), users.getRoleId(), users.getUsersSalary(), users.getUsersId());

        return update;
    }

    /**
     * 设置图形报表
     * @param usersId
     * @return
     * @throws Exception
     */
    @Override
    public List<Salary> selectSalaryIMG(Integer usersId) throws Exception {
        String sql="SELECT s.salaryMonth ,SUM(s.salaryBasic) salaryBasic ,SUM(s.salaryComm) salaryComm  FROM t_salary_record s WHERE 1=1 GROUP BY s.salaryMonth\n" +
                "AND s.usersId=?";

        return C3p0Util.queryList(sql,Salary.class,usersId);
    }
}
