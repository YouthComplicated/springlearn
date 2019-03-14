package com.lanmo.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @author NJ
 * @date 2019/3/13 15:24
 */
@Repository
public class UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int insert(){
        String sql = "INSERT INTO `dev`.`user` (`name`, `age`, `desc`) VALUES (?, ?, ?);";
        int result = jdbcTemplate.update(sql, "aa",11,"fwefwfw");
        int oo = 10/0;
        return result;
    }
}
