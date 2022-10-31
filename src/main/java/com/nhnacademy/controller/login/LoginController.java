package com.nhnacademy.controller.login;

import com.nhnacademy.controller.Command;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;

@Slf4j
public class LoginController implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession(false);
        if (Objects.isNull(session)) {
            return "redirect:/login.jsp";
        } else {
            return "/index.jsp";
        }
    }
}
