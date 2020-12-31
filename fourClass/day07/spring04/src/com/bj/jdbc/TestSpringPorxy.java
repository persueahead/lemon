package com.bj.jdbc;

import com.bj.jdbc.dao.IUsersDao;
import com.bj.jdbc.pojo.Users;
import com.bj.serivce.IStudentSerivce;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:appliactionContext.xml")
public class TestSpringPorxy {

    @Resource(name = "usersDao")
    private IUsersDao iusersdao;

    @Test
    public   void testSElAll() throws Exception {

        List<Users> all = iusersdao.getALL();
        for (Users users : all) {
            System.out.println(users);
        }
    }
    /**
     *
     */
    @Test
    public   void test() throws Exception {
        Users users = new Users();
        users.setUserMoney(1234);
        users.setUserName("隔壁二哥12");
        iusersdao.add(users);
       // iStudentSerivce.save();
    }
    @Test
    public   void testUp() throws Exception {
        Users users = new Users();
        users.setUserId(1);
        users.setUserMoney(12345);
        users.setUserName("隔壁老大爷");
        iusersdao.upeate(users);
        // iStudentSerivce.save();
    }
}
