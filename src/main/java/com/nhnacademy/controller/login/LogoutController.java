package com.nhnacademy.controller.login;

import com.nhnacademy.controller.Command;
import com.nhnacademy.servlet.CookieUtils;

import javax.servlet.http.*;
import java.io.IOException;
import java.util.Objects;

public class LogoutController implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession(false);
        if (Objects.nonNull(session)) {
            session.invalidate();
        }

        Cookie cookie = CookieUtils.getCookie(request, "JSESSIONID");
        if (Objects.nonNull(cookie)) {
            cookie.setValue("");
            cookie.setMaxAge(0);
            response.addCookie(cookie);
        }

        return "/index.jsp";
    }
}
