package com.nhnacademy.repository;

import com.nhnacademy.domain.User;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class RealUserRepository implements UserRepository {
    private List<User> userList = new ArrayList<>();

    @Override
    public void add(User user) {
        userList.add(user);
    }

    @Override
    public void modify(User user) {
        userList.remove(user);
    }

    @Override
    public User remove(String id) {
        User removeUser = null;
        int i = 0;
        for (User user : userList) {
            removeUser = user;
            if (user.getId().equals(id)) {
                removeUser = userList.remove(i);
                break;
            }
            i++;
        }
        return removeUser;
    }

    @Override
    public User getUser(String id) {
        User getUser = null;
        int i = 0;
        for (User user : userList) {
            if (user.getId().equals(id)) {
                getUser = userList.get(i);
            }
            i++;
        }
        return getUser;
    }

    @Override
    public List<User> getUsers() {
        return userList;
    }
}
