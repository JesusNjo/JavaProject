package com.todevelop.todevelop.members.services.user;

import com.todevelop.todevelop.members.services.user.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface UserRepository extends JpaRepository<UserModel,String> {
}
