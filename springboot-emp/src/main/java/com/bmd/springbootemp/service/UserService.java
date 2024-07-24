package com.bmd.springbootemp.service;

import com.bmd.springbootemp.entity.Dept;
import com.bmd.springbootemp.entity.User;
import com.bmd.springbootemp.entity.Community;

import java.util.List;


public interface UserService {
    //用户登录

    User userLoginService(String uname, String upwd);

    List<User> selectAllEmpService();

    List<Dept> selectAllDeptDataMapper();

    User selectUserByIdService(Integer id);

    void addUserService(User user);

    User selectUserByNameService(String uname);

    void updateUserById(User user);

    void deleteUserByIdService(int id);

    List<Community> selectAllComService();

    Community selctComByIdService(Integer cId);

    void updateComById(Community community);

    void deleteCommunityByIdService(int cId);

    User selectComByNameService(String cName);

    void addComService(Community community);

    List<Community> selectAllComDataMapper();

    List<Community> selectAllComSomeDataMapper();

    List<Community> selectComByName(String community);
}
