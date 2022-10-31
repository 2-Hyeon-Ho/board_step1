package com.nhnacademy.controller.user;

import com.nhnacademy.controller.Command;
import com.nhnacademy.domain.User;
import com.nhnacademy.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class UserViewController implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ServletContext servletContext = request.getServletContext();
        UserRepository userRepository = (UserRepository) servletContext.getAttribute("userRepository");

        List<User> users = userRepository.getUsers();
        List<String> userId = new ArrayList<>();
        List<String> userProfileFileName = new ArrayList<>();

        for (int i = 0; i < users.size(); i++) {
            userId.add(users.get(i).getId());
            userProfileFileName.add(users.get(i).getProfileFileName());
        }

        request.setAttribute("users", users);
        request.setAttribute("userId", userId);
        request.setAttribute("userProfileFileName", userProfileFileName);

        return "/userList.jsp";
    }
}
