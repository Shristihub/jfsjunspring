package com.bookapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Service;

import com.bookapp.model.ApiUser;
import com.bookapp.repository.IApiUserRepository;

@Service
public class ApiUserServiceImpl implements UserDetailsManager {

	private IApiUserRepository apiUserRepository;
	@Autowired
	public void setApiUserRepository(IApiUserRepository apiUserRepository) {
		this.apiUserRepository = apiUserRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return apiUserRepository.findByEmail(username);
	}

	@Override
	public void createUser(UserDetails user) {
		ApiUser apiUser = (ApiUser) user;
		apiUserRepository.save(apiUser);
	}

	@Override
	public void updateUser(UserDetails user) {
		ApiUser apiUser = (ApiUser) user;
		apiUserRepository.save(apiUser);

	}

	@Override
	public void deleteUser(String email) {
		ApiUser user = apiUserRepository.findByEmail(email);
		apiUserRepository.delete(user);
	}

	@Override
	public void changePassword(String oldPassword, String newPassword) {

	}

	@Override
	public boolean userExists(String email) {
		ApiUser user = apiUserRepository.findByEmail(email);
		if (user != null)
			return true;
		return false;
	}

}
