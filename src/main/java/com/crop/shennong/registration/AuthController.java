package com.crop.shennong.registration;

import com.crop.shennong.exception.LoginException;
import com.crop.shennong.registration.bean.LoginRequest;
import com.crop.shennong.registration.bean.SignUpRequest;
import com.crop.shennong.response.MessageResponse;
import com.crop.shennong.security.jwt.JwtAuthenticationResponse;
import com.crop.shennong.security.jwt.TokenProvider;
import com.crop.shennong.user.LocalUser;
import com.crop.shennong.user.UserUtils;
import com.crop.shennong.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserService userService;

    @Autowired
    TokenProvider tokenProvider;

    @PostMapping("/signup")
    public MessageResponse registerUser(@Valid @RequestBody SignUpRequest signUpRequest) {
        userService.registerNewUser(signUpRequest);

        return new MessageResponse("註冊成功");
    }

    @PostMapping("/login")
    public JwtAuthenticationResponse authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
        Authentication authentication;
        try {
            authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getPhone(), loginRequest.getPassword()));
        } catch (BadCredentialsException | InternalAuthenticationServiceException e) {
            throw new LoginException("信箱或密碼錯誤");
        }

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = tokenProvider.createToken(authentication);
        LocalUser user = (LocalUser) authentication.getPrincipal();
        return new JwtAuthenticationResponse(jwt, UserUtils.buildUserDto(user));
    }
}
