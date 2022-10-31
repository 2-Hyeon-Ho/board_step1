package com.nhnacademy.servlet;

import com.nhnacademy.controller.*;
import com.nhnacademy.controller.login.LoginController;
import com.nhnacademy.controller.login.LoginProcessingController;
import com.nhnacademy.controller.login.LogoutController;
import com.nhnacademy.controller.post.BoardRegisterController;
import com.nhnacademy.controller.post.BoardViewController;
import com.nhnacademy.controller.user.UserModifyController;
import com.nhnacademy.controller.user.UserRegisterController;
import com.nhnacademy.controller.user.UserRemoveController;
import com.nhnacademy.controller.user.UserViewController;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@WebServlet(name = "frontServlet", urlPatterns = "*.do")
public class FrontServlet extends HttpServlet {
    private static final String REDIRECT_PREFIX = "redirect:";

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");

        try {
            // 실제 요청 처리할 Servlet 결정.
            Command command = resolveServlet(req.getServletPath(), req.getMethod());

            // 실제 요청을 처리할 Servlet으로 요청을 전달하여 처리 결과를 include시킴.
            // ex.) /student/register, /student/view
            String view = command.execute(req, resp);

            // 실제 요청을 처리한 Servlet이 `view`라는 request 속성 값으로 view를 전달해 줌.
            if (view.startsWith(REDIRECT_PREFIX)) {
                // `redirect:`로 시작하면 redirect 처리.
                resp.sendRedirect(view.substring(REDIRECT_PREFIX.length()));
            } else {
                // redirect 아니면 JSP에게 view 처리를 위임하여 그 결과를 include시킴.
                RequestDispatcher rd = req.getRequestDispatcher(view);
                rd.include(req, resp);
            }
        } catch (Exception ex) {
            // 에러가 발생한 경우는 error page로 지정된 `/error.jsp`에게 view 처리를 위임.
            log.error("", ex);
            req.setAttribute("exception", ex);
            RequestDispatcher rd = req.getRequestDispatcher("/error.jsp");
            rd.forward(req, resp);
        }
    }

    private Command resolveServlet(String servletPath, String method) {

        Command command = null;
        if ("/login.do".equals(servletPath) && "POST".equalsIgnoreCase(method)) {
            command = new LoginProcessingController();
        }else if("/login.do".equals(servletPath) && "GET".equalsIgnoreCase(method)) {
            command = new LoginController();
        }else if("/logout.do".equals(servletPath) && "GET".equalsIgnoreCase(method)) {
            command = new LogoutController();
        } else if("/admin/userRegister.do".equals(servletPath) && "POST".equalsIgnoreCase(method)) {
            command = new UserRegisterController();
        } else if("/user/view.do".equals(servletPath) && "GET".equalsIgnoreCase(method)) {
            command = new UserViewController();
        } else if("/user/boardRegister.do".equals(servletPath) && "POST".equalsIgnoreCase(method)) {
            command = new BoardRegisterController();
        } else if("/admin/userModify.do".equals(servletPath) && "POST".equalsIgnoreCase(method)) {
            command = new UserModifyController();
        } else if("/admin/userRemove.do".equals(servletPath) && "POST".equalsIgnoreCase(method)) {
            command = new UserRemoveController();
        } else if("/board/view.do".equals(servletPath) && "GET".equalsIgnoreCase(method)) {
            command = new BoardViewController();
        }

        return command;
    }

}
