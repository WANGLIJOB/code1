package com.group.bodyBuilding.servlet.admin;

import com.group.bodyBuilding.dao.UserDao;
import com.group.bodyBuilding.factory.Factory;
import com.group.bodyBuilding.vo.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DelUserServlet_admin extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("userId");
        /*System.out.println(id);*/
        UserDao userDao = Factory.getUserDao();
        boolean delState = userDao.del(id);
        List<User> userList = new ArrayList<>();
        userList = userDao.userList();
        req.setAttribute("userList", userList);
        req.setAttribute("state2",true);
        req.setAttribute("delState",delState);
        req.setAttribute("state1",false);
        req.getRequestDispatcher("/admin/userTable.jsp").forward(req,resp);
    }
}
