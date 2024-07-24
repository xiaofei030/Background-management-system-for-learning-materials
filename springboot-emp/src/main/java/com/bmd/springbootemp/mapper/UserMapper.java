package com.bmd.springbootemp.mapper;

import com.bmd.springbootemp.entity.Dept;
import com.bmd.springbootemp.entity.User;
import com.bmd.springbootemp.entity.Community;
import org.apache.ibatis.annotations.*;

import java.util.List;

//持久层也是映射层
@Mapper
public interface UserMapper {
    @Select("select * from user where uname=#{uname} and upwd=#{upwd}")
     User userLoginMapper(@Param("uname") String uname,@Param("upwd") String upwd);

    @Select("select u.*,d.pname from user u join dept d on u.dept_id=d.id order by id desc")
    List<User> selectAllEmpService();

    @Select("select * from dept")
    List<Dept> selectAllDeptDataMapper();

    @Select("select * from user where id=#{id}")
    User selectUserByIdService(Integer id);

    @Insert("insert into user values (null,#{uname},#{upwd},#{email},#{phone},#{gender},#{dept_id})")
    void  addUserMapper(User user);

    @Insert("insert into community values (null,#{Category},#{cName},#{cAuthor},#{cDate},#{cNumber},#{cCode})")
    void addComMapper(Community community);

    @Select("select * from user where uname=#{uname}")
    User selectUserByNameMapper(String uname);

    @Select("select * from community where cName=#{cName}")
    User selectComByNameMapper1(String cName);

    @Update("update user set uname=#{uname},upwd=#{upwd},email=#{email},phone=#{phone},gender=#{gender},dept_id=#{dept_id} where id=#{id}")
    void updateUserByIdMapper(User user);

    @Update("update community set cName=#{cName},Category=#{Category},cAuthor=#{cAuthor},cDate=#{cDate},cNumber=#{cNumber},cCode=#{cCode} where cId=#{cId}")
    void updateComByIdMapper(Community community);

    @Delete("delete from user where id=#{id}")
    void deleteUserByIdMapper(int id);

    @Select("select * from community")
    List<Community> selectAllComDataMapper();

    @Select("select * from community where cId=#{cId}")
    Community selectComByIdService(Integer cId);

    @Delete("delete from community where cId=#{cId}")
    void deleteComByIdMapper(int cId);

    @Select("SELECT * FROM employees WHERE name LIKE '%John%';")
    List<Community> selectAllComSomeDataMapper();

    List<Community> selectComByNameMapper(String community);
}
