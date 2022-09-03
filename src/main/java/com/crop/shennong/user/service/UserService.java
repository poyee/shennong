package com.crop.shennong.user.service;

import com.crop.shennong.entity.User;
import com.crop.shennong.registration.bean.SignUpRequest;

public interface UserService {
    User registerNewUser(SignUpRequest signUpRequest);

    User findUserByEmail(String email);

    User findUserById(long id);
}
