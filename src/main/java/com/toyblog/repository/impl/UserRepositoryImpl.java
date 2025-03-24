package com.toyblog.repository.impl;

import com.toyblog.entity.User;
import com.toyblog.exception.UserNotFoundException;
import com.toyblog.repository.UserRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {
    List<User> userList = new ArrayList<>();

    @Override
    public User save(User user) {
        userList.add(user);
        return user;
    }

    @Override
    public User findById(String id) {
        return userList.stream().filter(u -> u.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new UserNotFoundException("유저를 찾을 수 없습니다."));
    }

    @Override
    public User findByEmail(String email) {
        return userList.stream().filter(u -> u.getEmail().equals(email))
                .findFirst()
                .orElseThrow(() -> new UserNotFoundException("유저를 찾을 수 없습니다."));
    }

    @Override
    public List<User> findAll() {
        return userList;
    }

    @Override
    public void delete(String id) {
        User target = findById(id);
        userList.remove(target);
    }
}
