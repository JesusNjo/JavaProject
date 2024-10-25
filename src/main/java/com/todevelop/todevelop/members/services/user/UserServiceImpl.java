package com.todevelop.todevelop.members.services.user;

import com.todevelop.todevelop.members.services.user.model.UserModel;
import com.todevelop.todevelop.members.services.user.service.UserServices;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
class UserServiceImpl implements UserServices {
    private final UserDAO userDAO;
    @Override
    public Optional<UserModel> findById(String var1) {
        return userDAO.findById(var1);
    }

    @Override
    public UserModel save(UserModel var1) {
        return userDAO.save(var1);
    }

    @Override
    public List<UserModel> saveAll(List<UserModel> var1) {
        return userDAO.saveAll(var1);
    }

    @Override
    public void delete(UserModel var1) {
        userDAO.delete(var1);
    }
}
