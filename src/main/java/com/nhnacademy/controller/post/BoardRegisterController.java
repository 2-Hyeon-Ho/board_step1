package com.nhnacademy.controller.post;

import com.nhnacademy.controller.Command;
import com.nhnacademy.domain.Post;
import com.nhnacademy.domain.RealPost;
import com.nhnacademy.repository.PostRepository;
import com.nhnacademy.repository.RealPostRepository;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Slf4j
public class BoardRegisterController implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Post post = new RealPost(
                request.getParameter("title"),
                request.getParameter("content"));

        log.info("{}", post.getContent());
        PostRepository postRepository = (RealPostRepository) request.getServletContext().getAttribute("postRepository");
        postRepository.register(post);
        List<Post> posts = postRepository.getPosts();
        log.info("{}", posts);
        request.getServletContext().setAttribute("postRepository", postRepository);
        request.getServletContext().setAttribute("posts", posts);

        return "redirect:/board/view.do";
    }
}
