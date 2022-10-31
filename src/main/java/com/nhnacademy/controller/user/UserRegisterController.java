package com.nhnacademy.controller.user;

import com.nhnacademy.controller.Command;
import com.nhnacademy.domain.RealUser;
import com.nhnacademy.domain.User;
import com.nhnacademy.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
public class UserRegisterController implements Command {
    private static Map<String, String> userMap = new HashMap<>();

    public static Map<String, String> getUserMap() {
        return userMap;
    }


    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        User member = new RealUser(
                request.getParameter("id"),
                request.getParameter("pwd"),
                request.getParameter("name"),
                request.getParameter("profileFileName"));

        UserRepository userRepository = (UserRepository) request.getServletContext().getAttribute("userRepository");
        userRepository.add(member);

        List<User> user = userRepository.getUsers();
        request.setAttribute("user", user);

        List<String> userId = new ArrayList<>();
        List<String> userPwd = new ArrayList<>();

        for(int i = 0; i < user.size(); i++) {
            userId.add(user.get(i).getId());
            userPwd.add(user.get(i).getPassword());
        }

        for(int i = 0; i < userId.size(); i++) {
            userMap.put(userId.get(i), userPwd.get(i));
        }

        request.getServletContext().setAttribute("userMap", getUserMap());

        return "redirect:/user/view.do";
    }
}
