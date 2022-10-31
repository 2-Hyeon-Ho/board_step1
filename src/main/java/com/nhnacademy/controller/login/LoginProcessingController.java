package com.nhnacademy.controller.login;

import com.nhnacademy.controller.Command;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@Slf4j
public class LoginProcessingController implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        String pwd = request.getParameter("pwd");

        Map<String, String> userMap = (Map<String, String>) request.getServletContext().getAttribute("userMap");
        String InitPwd = userMap.get(id);

        if("admin".equals(id) && "12345".equals(pwd)) {
            request.getServletContext().setAttribute("role", "admin");
            return "/userCheck.jsp";
        }else if(userMap.get(id)!=null && InitPwd.equals(pwd)) {
            request.getServletContext().setAttribute("role", "user");
            return "/userCheck.jsp";
        }else {
            return "/index.jsp";
        }
    }
}
