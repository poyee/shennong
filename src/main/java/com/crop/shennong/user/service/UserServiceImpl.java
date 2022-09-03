package com.crop.shennong.user.service;

import com.crop.shennong.entity.Role;
import com.crop.shennong.entity.User;
import com.crop.shennong.exception.NotFoundException;
import com.crop.shennong.exception.ResourceConflictException;
import com.crop.shennong.registration.bean.SignUpRequest;
import com.crop.shennong.role.RoleRepository;
import com.crop.shennong.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;

/**
 * @author Chinna
 * @since 26/3/18
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Transactional(value = "transactionManager")
	public User registerNewUser(final SignUpRequest signUpRequest) {
		if (userRepository.existsByPhone(signUpRequest.getPhone())) {
			throw new ResourceConflictException("此信箱已有人註冊");
		}
		User user = buildUser(signUpRequest);
		return userRepository.save(user);
	}

	@Override
	public User findUserByEmail(String phone) {
		return userRepository.findByPhone(phone);
	}

	@Override
	public User findUserById(long id) {
		return userRepository.findById(id).orElseThrow(() -> new NotFoundException("查無使用者" + id));
	}

	private User buildUser(final SignUpRequest request) {
		User user = new User();
		user.setDisplayName(request.getDisplayName());
		user.setPhone(request.getPhone());
		user.setPassword(passwordEncoder.encode(request.getPassword()));
		final HashSet<Role> roles = new HashSet<>();
		roles.add(roleRepository.findByName(Role.ROLE_USER));
		user.setRoles(roles);
		return user;
	}
}
