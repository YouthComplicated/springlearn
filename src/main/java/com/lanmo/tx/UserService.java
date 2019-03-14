package com.lanmo.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author NJ
 * @date 2019/3/13 15:24
 */
@Service
public class UserService {

    @Autowired
    private UserDao userDao;

//    @Transactional
    public int insertUser(){
        return userDao.insert();
    }

}
