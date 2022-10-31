package com.nhnacademy.controller.post;

import com.nhnacademy.controller.Command;
import com.nhnacademy.domain.Post;
import com.nhnacademy.repository.PostRepository;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class BoardViewController implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ServletContext servletContext = request.getServletContext();
        PostRepository postRepository = (PostRepository) servletContext.getAttribute("postRepository");

//        List<Post> posts = postRepository.getPosts();
//        postRepository.register()
//        List<Post> posts = (List<Post>) servletContext.getAttribute("posts");
        List<Post> posts = postRepository.getPosts();
        log.info("{}", posts);
        List<String> postTitle = new ArrayList<>();
        List<String> postContent = new ArrayList<>();

        for(int i = 0; i < posts.size(); i++) {
            postTitle.add(posts.get(i).getTitle());
            postContent.add(posts.get(i).getContent());
        }

        request.setAttribute("posts", posts);
        request.setAttribute("postTitle", postTitle);
        request.setAttribute("postContent", postContent);

        return "/boardList.jsp";
    }
}
