package com.jyl.practice.usmp.dao;

import com.jyl.practice.usmp.po.User;
import org.apache.ibatis.annotations.*;

import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface SampleAnnotatedMapper {

    @Select("select now()")
    LocalDateTime test();

    @SelectProvider(type = TestDemoSqlProvider.class, method = "queryDemo")
    @Results(id = "userMap", value = {
            @Result(column = "id", property = "id", id=true),
            @Result(column = "userName", property = "userName"),
            @Result(column = "passWord", property = "passWord"),
            @Result(column = "realName", property = "realName")
    })
    User queryDemo();

    @SelectProvider(type = TestDemoSqlProvider.class, method = "queryDemo")
    @ResultMap("userMap")
    List<User> queryDemo2(User user);

}
