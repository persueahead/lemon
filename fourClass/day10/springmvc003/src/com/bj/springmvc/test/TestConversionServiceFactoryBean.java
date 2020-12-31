package com.bj.springmvc.test;

import com.bj.spring.pojo.Users;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class TestConversionServiceFactoryBean  implements Converter<String ,Users> {

    @Override
    public Users convert(String s) {
            if(s !=null){
                  String [] str=      s.split(",");
                    if(str !=null  && str.length==2){
                        Users users = new Users();
                        users.setId(Integer.parseInt(str[0]));
                        users.setName(str[1]);
                        return users;
                    }
            }
        return null;
    }
}
