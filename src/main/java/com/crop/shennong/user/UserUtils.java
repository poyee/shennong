package com.crop.shennong.user;

import com.crop.shennong.bean.UserDto;
import com.crop.shennong.entity.Role;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class UserUtils {
    public static List<SimpleGrantedAuthority> buildSimpleGrantedAuthorities(final Set<Role> roles) {
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        for (Role role : roles) {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        }
        return authorities;
    }

    public static UserDto buildUserDto(LocalUser user) {
        List<String> roles = user.getAuthorities().stream().map(item -> item.getAuthority()).collect(Collectors.toList());
        return new UserDto(user.getId(), user.getDisplayName(), user.getPhone(), roles);
    }
}
