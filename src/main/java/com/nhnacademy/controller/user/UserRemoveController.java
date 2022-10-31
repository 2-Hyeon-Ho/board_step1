package com.nhnacademy.controller.user;

import com.nhnacademy.controller.Command;
import com.nhnacademy.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
public class UserRemoveController implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("removeId");

        UserRepository userRepository = (UserRepository) request.getServletContext().getAttribute("userRepository");

        userRepository.remove(id);

        return "redirect:/user/view.do";
    }
}
