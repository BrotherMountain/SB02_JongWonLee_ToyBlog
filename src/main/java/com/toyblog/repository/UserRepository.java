package com.toyblog.repository;

import com.toyblog.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository {
    User save(User user);

    User findById(String id);

    User findByEmail(String email);

    List<User> findAll();

    void delete(String id);

}
