package com.crop.shennong.user;

import com.crop.shennong.entity.User;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class LocalUser extends org.springframework.security.core.userdetails.User {
    private User user;

    public LocalUser(User user) {
        this(user, user.getPhone(), user.getPassword(), true, true, true, true, UserUtils.buildSimpleGrantedAuthorities(user.getRoles()));
    }

    public LocalUser(User user, String email, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities) {
        super(email, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
        this.user = user;
    }

    public long getId() {
        return user.getId();
    }

    public String getPhone() {
        return user.getPhone();
    }

    public String getDisplayName() {
        return user.getDisplayName();
    }

    public User getUser() {
        return this.user;
    }
}
