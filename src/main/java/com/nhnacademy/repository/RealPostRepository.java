package com.nhnacademy.repository;

import com.nhnacademy.domain.Post;

import java.util.ArrayList;
import java.util.List;

public class RealPostRepository implements PostRepository {
    private List<Post> postList = new ArrayList<>();
    private static long postId = 0;

    @Override
    public long register(Post post) {
        postList.add(post);
        postId++;
        return postId;
    }

    @Override
    public void modify(Post post) {

    }

    @Override
    public Post remove(long id) {
        return null;
    }

    @Override
    public Post getPost(long id) {
        return null;
    }

    @Override
    public List<Post> getPosts() {
        return this.postList;
    }
}
