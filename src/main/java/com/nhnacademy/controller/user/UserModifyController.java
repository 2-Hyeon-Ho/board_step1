package com.nhnacademy.controller.user;

import com.nhnacademy.controller.Command;
import com.nhnacademy.domain.RealUser;
import com.nhnacademy.domain.User;
import com.nhnacademy.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@Slf4j
public class UserModifyController implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("modifyId");

        User member = new RealUser(
                id,
                request.getParameter("pwd"),
                request.getParameter("name"),
                request.getParameter("profileFileName"));

        UserRepository userRepository = (UserRepository) request.getServletContext().getAttribute("userRepository");
        List<User> users = userRepository.getUsers();
        for (User user : users) {
            if(user.getId().equals(id)) {
                userRepository.modify(user);
                userRepository.add(member);
                break;
            }else {
                log.error("{}", "존재하지 않는 아이디입니다..");
            }
        }
        Map<String, String> userMap = (Map<String, String>) request.getServletContext().getAttribute("userMap");
        userMap.replace(id, member.getPassword());
        request.setAttribute("userMap", userMap);

        return "redirect:/user/view.do";
    }
}
