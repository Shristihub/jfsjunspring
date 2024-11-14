package com.bookapp.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
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
		ApiUser apiuser =  apiUserRepository.findByUsername(username);
		System.out.println(apiuser);
		if(apiuser==null)
			throw new UsernameNotFoundException("invalid");
		// get username,password and grantedAuthorities
		UserDetails details = new User(apiuser.getUsername(), apiuser.getPassword(),apiuser.getAuthorities());
		return details;
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
	public void deleteUser(String username) {
		ApiUser user = apiUserRepository.findByUsername(username);
		apiUserRepository.delete(user);
	}

	@Override
	public void changePassword(String oldPassword, String newPassword) {

	}

	@Override
	public boolean userExists(String username) {
		ApiUser user = apiUserRepository.findByUsername(username);
		System.out.println(user);
		if (user != null)
			return true;
		return false;
	}

}
