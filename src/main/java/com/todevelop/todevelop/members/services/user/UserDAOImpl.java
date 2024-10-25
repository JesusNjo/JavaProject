package com.todevelop.todevelop.members.services.user;

import com.todevelop.todevelop.members.services.user.model.UserModel;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@AllArgsConstructor
class UserDAOImpl implements UserDAO{
    private final UserRepository userRepository;
    @Override
    public Optional<UserModel> findById(String var1) {
        return userRepository.findById(var1);
    }

    @Override
    public UserModel save(UserModel var1) {
        return userRepository.save(var1);
    }

    @Override
    public List<UserModel> saveAll(List<UserModel> var1) {
        return userRepository.saveAll(var1);
    }

    @Override
    public void delete(UserModel var1) {
        userRepository.delete(var1);
    }
}
