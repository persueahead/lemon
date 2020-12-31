package com.bjlemon.springboot;

import com.bjlemon.springboot.domain.User;
import com.bjlemon.springboot.service.UserService;
import com.bjlemon.springboot.vo.UserQueryVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.Date;

@SpringBootTest
class SpringbootDataJpaDemoApplicationTests {

    @Autowired
    private UserService userService;

    @Test
    public void addUser() {
        User user = new User();
        user.setName("zhangsan");
        user.setPassword("123456");
        user.setSalary(12.34F);
        user.setBirthday(new Date());

        this.userService.addUser(user);
    }

    @Test
    public void testFindUserPaginationList1() {
        int pageNum = 1;
        int pageSize = 3;
        PageRequest pageRequest = PageRequest.of(pageNum, pageSize);

        UserQueryVO userQueryVO = new UserQueryVO();
        userQueryVO.setName("a");
        userQueryVO.setPassword("1");

        Page<User> page = this.userService.findUserPaginationList(pageRequest, userQueryVO);
        System.out.println(page.getTotalElements());
        System.out.println(page.getTotalPages());
        page.getContent().stream().forEach(System.out::println);
        System.out.println(page.getNumber());
        System.out.println(page.getSize());
    }
}
