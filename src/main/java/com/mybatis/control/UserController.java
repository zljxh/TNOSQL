package com.mybatis.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


import com.mybatis.database.DbContextHolder;
import com.mybatis.entity.User;
import com.mybatis.returnjson.JsonReturn;
import com.mybatis.service.UserService;
import com.mybatis.service.UserService2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserService2 userService2;

    /**
     * 获取所有用户列表
     *
     * @param request
     * @return
     */
    @RequestMapping("/getAllUser")
    public
    @ResponseBody
    JsonReturn
    getAllUser(HttpServletRequest request) {
        DbContextHolder.setDbType("ds1");
        List<User> findAll = userService.findAll();
        System.out.println(findAll.size());
        DbContextHolder.setDbType("ds2");
        request.setAttribute("userList", findAll);
        List<User> findAll1 = userService2.findAll();
        findAll.addAll(findAll1);
        return new JsonReturn(1, "操作成功", findAll);
    }

    /**
     * 跳转到添加用户界面
     *
     * @param request
     * @return
     */
    @RequestMapping("/toAddUser")
    public String toAddUser(HttpServletRequest request) {

        return "/addUser";
    }

    /**
     * 添加用户并重定向
     *
     * @param user
     * @param request
     * @return
     */
    @RequestMapping("/addUser")
    public String addUser(User user, HttpServletRequest request) {
        userService.save(user);
        return "redirect:/user/getAllUser";
    }

    /**
     * 编辑用户
     *
     * @param user
     * @param request
     * @return
     */
    @RequestMapping("/updateUser")
    public String updateUser(User user, HttpServletRequest request) {


        if (userService.update(user)) {
            user = userService.findById(user.getId());
            request.setAttribute("user", user);
            return "redirect:/user/getAllUser";
        } else {
            return "/error";
        }
    }

    /**
     * 根据id查询单个用户
     *
     * @param id
     * @param request
     * @return
     */
    @RequestMapping("/getUser")
    public String getUser(int id, HttpServletRequest request) {

        request.setAttribute("user", userService.findById(id));
        return "/editUser";
    }

    /**
     * 删除用户
     *
     * @param id
     * @param request
     * @param response
     */
    @RequestMapping("/delUser")
    public void delUser(int id, HttpServletRequest request, HttpServletResponse response) {
        String result = "{\"result\":\"error\"}";

        if (userService.delete(id)) {
            result = "{\"result\":\"success\"}";
        }

        response.setContentType("application/json");

        try {
            PrintWriter out = response.getWriter();
            out.write(result);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
