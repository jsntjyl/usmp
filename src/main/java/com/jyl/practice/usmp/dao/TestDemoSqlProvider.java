package com.jyl.practice.usmp.dao;

import com.jyl.practice.usmp.po.SysUser;
import org.apache.ibatis.jdbc.SQL;
import org.springframework.util.StringUtils;

/**
 * @program: usmp
 * @description: sqlprovider
 * @author: 19042501
 * @create: 2019-11-07 20:59
 */
public class TestDemoSqlProvider {

    public String queryDemo(SysUser user)
    {
        SQL sql = new SQL().SELECT("*")
                .FROM("user");
        if(user.getId() > 0)
        {
            sql = sql.WHERE("id = #{id}");
        }
        if (!StringUtils.isEmpty(user.getUserName()))
            sql = sql.WHERE("username = #{userName}");

        if (!StringUtils.isEmpty(user.getPassWord()))
            sql = sql.WHERE("password = #{passWord}");

        return sql.toString();
    }

    public String insertDemo(SysUser user)
    {
        SQL sql = new SQL().INSERT_INTO("user").INTO_COLUMNS("userName", "passWord").INTO_VALUES("#{userName}", "#{passWord}");
        return sql.toString();
    }

    public String queryUserByName(String userName)
    {
        SQL sql = new SQL().SELECT("*").FROM("user").WHERE("userName = #{userName}").LIMIT(1);
        return sql.toString();
    }

}
