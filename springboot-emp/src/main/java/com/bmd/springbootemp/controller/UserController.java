package com.bmd.springbootemp.controller;

import com.bmd.springbootemp.entity.Dept;
import com.bmd.springbootemp.entity.User;
import com.bmd.springbootemp.commons.Result;
import com.bmd.springbootemp.entity.Community;
import com.bmd.springbootemp.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
//404:页面找不到，
@RequestMapping("/user")
@Controller
public class UserController {
    //注入业务层
    @Resource
    private UserService userService;
    //登录页面
    @RequestMapping("/loginHTML")
    public String loginHtml(){
        return "login";
    }

    //首页面
    @RequestMapping("/tologin")
    @ResponseBody
    public Result<String> tologin(String uname, String upwd){
        User user =  userService.userLoginService(uname,upwd);
        if (user!=null){
            return Result.success();
        }else{
            return Result.fail("账号或密码错误");
        }
    }

    //首页
    @RequestMapping("/dashboard")
    public String dashboard(){
        return "dashboard";
    }

    @RequestMapping("/toListEmp")
    public String toListEmp(Model model){
        //调用业务层
        List<User> users = userService.selectAllEmpService();
        model.addAttribute("users",users);
        return "list";}

    @RequestMapping("/toListCom")
    public String toListCom(Model model){
        List<Community> communities = userService.selectAllComService();
        model.addAttribute("communities",communities);
        return "community";
    }
    //编辑页面
    //@PathVariable:获取占位符的数据
    @RequestMapping("/updateHTML/{id}")
    public String addHTML(@PathVariable Integer id, Model model){

        User user = userService.selectUserByIdService(id);
        model.addAttribute("user",user);

        List<Dept> depts=userService.selectAllDeptDataMapper();
        model.addAttribute("depts",depts);
        return "update";
    }

    @RequestMapping("/addHTML")
    public String addHTML(Model model){
        List<Dept> depts=userService.selectAllDeptDataMapper();
        model.addAttribute("depts",depts);
        return "add";
    }
//    addComHTML
   @RequestMapping("/addComHTML")
    public String addComHTML(Model model){
    List<Community> communities=userService.selectAllComDataMapper();
    model.addAttribute("communities",communities);
    return "addCommunity";
}
    @RequestMapping("/addUser")
    public String addUser(User user,Model model){
        //重定向
        //根据用户名查询数据，若查询有数据则该用户名被u占用，否则正常插入数据
        User u = userService.selectUserByNameService(user.getUname());
        if (u!=null){
            model.addAttribute("message","用户名被占用");
            return "add";
        }else{
            userService.addUserService(user);
            return "redirect:/user/toListEmp";
        }
    }
    @RequestMapping("/addCom")
    public String addCom(Community community,Model model){
        //重定向
        //根据用户名查询数据，若查询有数据则该用户名被u占用，否则正常插入数据
        User u = userService.selectComByNameService(community.getCName());
        if (u!=null){
            model.addAttribute("message","用户名被占用");
            return "add";
        }else{
            userService.addComService(community);
            return "redirect:/user/toListCom";
        }
    }
    @RequestMapping("/updateUser")
    public String updateUser(User user){
        userService.updateUserById(user);
        return "redirect:/user/toListEmp";
    }

    @RequestMapping("/updateCommunity")
    public String updateCommunity(Community community){
        userService.updateComById(community);
        return "redirect:/user/toListCom";
    }

    @RequestMapping("/deleteUserById/{id}")
    public String deleteUserById(@PathVariable int id){
        userService.deleteUserByIdService(id);
        return "redirect:/user/toListEmp";
    }

    @RequestMapping("/deleteCommunityById/{cId}")
    public String deleteCommunityById(@PathVariable int cId){
        userService.deleteCommunityByIdService(cId);
        return "redirect:/user/toListCom";
    }

    @RequestMapping("/deptHTML")
    public String deleteHTML(){
        return "dept";
    }

    @RequestMapping("/communityHTML")
    public String communityHTML(Model model){
        List<Community> communities = userService.selectAllComService();
        model.addAttribute("communities",communities);
        return "community";
    }

    @RequestMapping("/updateCommunityHTML/{cId}")
    public String updateCommunityHTML(@PathVariable Integer cId,Model model){
        Community community = userService.selctComByIdService(cId);
        model.addAttribute("community",community);
        return "updateCommunity";
    }

    @RequestMapping("/selectCommunity")
    public String selectCommunity(@PathVariable("community") String community,Model model){
        List<Community> communities =  userService.selectComByName(community);
        model.addAttribute("communities",communities);
        return "community";
    }
}
