package com.bjlemon;
import com.baomidou.mybatisplus.core.conditions.Condition;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.EmptyWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
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

        UserMapper userMapper=  ioc.getBean(UserMapper.class);

        User u02 = new User();
        u02.setName("admin");
        u02.setEmail("12345@163.com");
        u02.setIdCard("5002383929384");

        int row=  userMapper.insert(u02);

        System.out.println(row);
        System.out.println(u02);

    }

    @Test
    public void testDeleteById(){

        UserMapper userMapper=  ioc.getBean(UserMapper.class);

        int row = userMapper.deleteById(129);

        System.out.println(row);
    }

    @Test
    public void testDeleteByMap(){

        UserMapper userMapper=  ioc.getBean(UserMapper.class);

        Map<String,Object> map = new HashMap<>();
        // key: 列明   value: 筛选值
        map.put("name","张学友");
        map.put("card",null);
        int row =userMapper.deleteByMap(map);
        System.out.println(row);
    }

    @Test
    public void testBatchIds(){


        UserMapper userMapper=  ioc.getBean(UserMapper.class);

        ArrayList<Integer> ids= new ArrayList<>();
        ids.add(123);
        ids.add(128);
        ids.add(130);

        int row =userMapper.deleteBatchIds(ids);
        System.out.println(row);

    }

    @Test
    public void testUpdateById(){

        UserMapper userMapper=  ioc.getBean(UserMapper.class);


        User u01 = new User();
        u01.setId(4);
        u01.setIdCard("50043433443X");
        u01.setEmail("gfc@qq.com");

        int row= userMapper.updateById(u01);
        System.out.println(row);



    }

    @Test
    public void testSelectById(){

        UserMapper userMapper=  ioc.getBean(UserMapper.class);

        User user= userMapper.selectById(1);

        System.out.println(user);


    }

    @Test
    public void testSelectList(){

        UserMapper userMapper=  ioc.getBean(UserMapper.class);

        List<User> list = userMapper.selectList(null);
        System.out.println(list);


    }


    @Test
    public void testSelectBatchIds(){

        UserMapper userMapper=  ioc.getBean(UserMapper.class);

        ArrayList<Integer> ids= new ArrayList<>();
        ids.add(1);
        ids.add(4);


        List<User> list = userMapper.selectBatchIds(ids);
        System.out.println(list);


    }

    @Test
    public void testSelectByMap(){
        UserMapper userMapper=  ioc.getBean(UserMapper.class);

        Map<String,Object> map = new HashMap<>();
        map.put("name","黎明");
        map.put("card",null);

        List<User> list = userMapper.selectByMap(map);
        System.out.println(list);

    }



    //根据条件删除（名字叫 黎明 同时邮箱包含 @  ）
    @Test
    public void testDeleteByWrapper(){


        UserMapper userMapper=  ioc.getBean(UserMapper.class);

        //条件为列名，费属性名字
        int row=  userMapper.delete(  new QueryWrapper<User>().eq("name","黎明").like("email","@"));

        System.out.println(row);

    }



    //根据条件更新（把 编号大于1  同时 邮箱包含 163.com  的身份证信息改为500xxx  ）
    @Test
    public void testUpdateByWrapper(){



        UserMapper userMapper=  ioc.getBean(UserMapper.class);

        //条件为列名，费属性名字
        User u = new User();
        u.setIdCard("500xxx");
        int row = userMapper.update(u, new UpdateWrapper<User>().gt("id",1).like("email","163.com")  );

        System.out.println(row);

    }




    //根据条件更新（把 名字叫xx  或者 身份证信息改为xxx ）
    @Test
    public void queryByWrapper(){



        UserMapper userMapper=  ioc.getBean(UserMapper.class);


        User user=  userMapper.selectOne( new QueryWrapper<User>().eq("name","刘德华").or().eq("card","123") );
        System.out.println(user);
    }


    // 查询使用qq邮箱的用户
    @Test
    public void testcount(){

        UserMapper userMapper = ioc.getBean(UserMapper.class);
        Integer row= userMapper.selectCount( new QueryWrapper<User>().like("email","@qq.com") );

        System.out.println(row);
    }


    //查询 年龄在20 - 50间 同时 性别为男的用户
    @Test
    public void testqueryListByWrapper(){

        UserMapper userMapper = ioc.getBean(UserMapper.class);
        List<User> list = userMapper.selectList(new QueryWrapper<User>().between("age", 20, 50).eq("sex", "男"));
        System.out.println(list);



    }



    @Test
    public void testPage(){
        UserMapper userMapper = ioc.getBean(UserMapper.class);

        //   IPage<User> pager = userMapper.selectPage(new Page<User>(2, 3), null);

        IPage<User> pager = userMapper.selectPage(new Page<User>(1, 3),
                new QueryWrapper<User>().gt("age",20));

        System.out.println(pager.getRecords());

        System.out.println("当前页"+ pager.getCurrent() );
        System.out.println("每页记录数"+pager.getSize());
        System.out.println("总页数页"+ pager.getPages()  );
        System.out.println("总记录数"+pager.getTotal());

    }

    @Test
    public void test22(){

        UserMapper userMapper = ioc.getBean(UserMapper.class);
        List<User> li = userMapper.selectList(new QueryWrapper<User>().orderBy(true, true, "age"));
        for (User i:li
        ) {
            System.out.println(i);
        }
    }

}
