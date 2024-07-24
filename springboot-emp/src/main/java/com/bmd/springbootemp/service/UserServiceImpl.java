package com.bmd.springbootemp.service;

import com.bmd.springbootemp.entity.Dept;
import com.bmd.springbootemp.entity.User;
import com.bmd.springbootemp.entity.Community;
import com.bmd.springbootemp.mapper.UserMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    //注入持久层
    @Resource
    private UserMapper userMapper;

    @Override
    public User userLoginService(String uname, String upwd) {
        User user =  userMapper.userLoginMapper(uname,upwd);
        return user;
    }

    @Override
    public List<User> selectAllEmpService() {
        List<User> list = userMapper.selectAllEmpService();
        return list;
    }

    @Override
    public List<Dept> selectAllDeptDataMapper() {
        List<Dept> depts = userMapper.selectAllDeptDataMapper();
        return depts;
    }
    @Override
    public List<Community> selectAllComDataMapper() {
        List<Community> coms = userMapper.selectAllComDataMapper();
        return coms;
    }



    @Override
    public List<Community> selectAllComSomeDataMapper() {
        List<Community> coms = userMapper.selectAllComSomeDataMapper();
        return coms;
    }



    @Override
    public User selectUserByIdService(Integer id) {
        User user = userMapper.selectUserByIdService(id);
        return user;
    }

    @Override
    public void addUserService(User user) {
        userMapper.addUserMapper(user);
    }

    @Override
    public void addComService(Community community) {
        userMapper.addComMapper(community);
    }



    @Override
    public User selectUserByNameService(String uname) {
        return userMapper.selectUserByNameMapper(uname);
    }

    @Override
    public User selectComByNameService(String cName) {
        return userMapper.selectComByNameMapper1(cName);
    }


    @Override
    public List<Community> selectComByName(String community) {
        return userMapper.selectComByNameMapper(community);
    }

    @Override
    public void updateUserById(User user) {
        userMapper.updateUserByIdMapper(user);
    }

    @Override
    public void updateComById(Community community) {
        userMapper.updateComByIdMapper(community);
    }

    @Override
    public void deleteUserByIdService(int id) {
        userMapper.deleteUserByIdMapper(id);
    }

    @Override
    public List<Community> selectAllComService() {
        List<Community> communities = userMapper.selectAllComDataMapper();
        return communities;
    }

    @Override
    public Community selctComByIdService(Integer cId) {
        Community community = userMapper.selectComByIdService(cId);
        return community;
    }

    @Override
    public void deleteCommunityByIdService(int cId) {
        userMapper.deleteComByIdMapper(cId);
    }




}
