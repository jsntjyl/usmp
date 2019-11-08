package com.jyl.practice.usmp.dao;

import com.jyl.practice.usmp.po.User;
import org.apache.ibatis.jdbc.SQL;
import org.springframework.util.StringUtils;

/**
 * @program: usmp
 * @description: sqlprovider
 * @author: 19042501
 * @create: 2019-11-07 20:59
 */
public class TestDemoSqlProvider {

    public String queryDemo(User user)
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

}
