package com.jyl.practice.usmp.dao;

import com.jyl.practice.usmp.po.SysUser;
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
    SysUser queryDemo();

    @SelectProvider(type = TestDemoSqlProvider.class, method = "queryDemo")
    @ResultMap("userMap")
    List<SysUser> queryDemo2(SysUser user);

    @InsertProvider(type = TestDemoSqlProvider.class, method = "insertDemo")
    int addUser(SysUser user);

    @SelectProvider(type = TestDemoSqlProvider.class, method = "queryUserByName")
    //@ResultMap("userMap")
    SysUser queryUserByName(String userName, String passWord);

}
