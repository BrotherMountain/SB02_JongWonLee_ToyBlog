package com.toyblog.repository;

import com.toyblog.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository {
    User save(User user);

    User findById(String id);

    User findByEmail(String email);

    User delete(String id);

}
