package com.bjlemon;
import com.baomidou.mybatisplus.core.conditions.Condition;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.EmptyWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bjlemon.domain.User;
import com.bjlemon.mapper.UserMapper;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Unit test for simple App.
 */
public class AppTest
{

    static  ClassPathXmlApplicationContext  ioc=null;
    static{
        ioc = new ClassPathXmlApplicationContext("application.xml");
    }


    @Test
    public void testInsert(){

        User user = new User();
        user.setName("张三");
        user.setIdCard("5000xxx");
        user.setEmail("zf@163.com");
        user.setAge(100);
        user.setSex("男");

        boolean isOk=  user.insert();
        System.out.println(isOk);

    }

    @Test
    public void testUpdate(){
        User user = new User();
        user.setId(1);
        user.setEmail("xxx@qq.com");
        boolean isOk=  user.updateById();
        System.out.println(isOk);

    }



    @Test
    public void testQuery(){

        User user = new User();
        user.setId(6);
        Model u = user.selectById();
        System.out.println(u);


    }


    @Test
    public void testQueryList(){

        User user = new User();
        List<User> userList=  user.selectList(  null   );
        for (User u:userList
        ) {

            System.out.println(u);

        }
    }

    @Test
    public void testQueryList2(){

        User user = new User();

        List<User> userList=  user.selectList( new QueryWrapper<User>().gt("age",30).orderByDesc("age")  );
        for (User u:userList
        ) {

            System.out.println(u);

        }

    }

    @Test
    public void testQueryAll(){

        User user = new User();

        List list = user.selectAll();
        for (Object u:list
        ) {
            System.out.println(u);
        }
    }

    @Test
    public void testQueryOne(){

        User user = new User();

        Model u=   user.selectOne( new QueryWrapper<User>().eq("name","刘德华") );
        System.out.println(u);
    }


    @Test
    public void testQueryCount(){

        User user = new User();

        Integer count= user.selectCount( new QueryWrapper<User>().eq("sex","男"));
        System.out.println(count);


    }


    @Test
    public void testQueryPage(){
        User user = new User();


        IPage pager = user.selectPage(new Page(1, 2), new QueryWrapper<User>().between("age", 20, 50).eq("sex", "男"));


        System.out.println("查询的数据："+ pager.getRecords() );
        System.out.println("当前页码："+pager.getCurrent());
        System.out.println("每页大小："+pager.getSize());
        System.out.println("总页数："+pager.getPages());
        System.out.println("总记录："+pager.getTotal());


    }



    @Test
    public void testDelete(){

        User user = new User();
        //user.setId(6);
        // boolean isOk= user.deleteById();
        Boolean isOk= user.deleteById(5);
        System.out.println(isOk);


    }



    @Test
    public void testDeleteByWrapper(){

        User user = new User();
        boolean isOk=    user.delete(new QueryWrapper<User>().lt("age",40));
        System.out.println(isOk);
    }





}
