package com.bookapp.model;

import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@Data
@NoArgsConstructor
public class ApiUser implements UserDetails{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String username;
	private String email;
	private String password;
	@Id
	@GeneratedValue
	private Integer userId; 
	@ElementCollection
	@JoinTable(name="apiuser_authorities")
	private Set<GrantedAuthority> authorities;
	public ApiUser(String username, String email, String password, Set<GrantedAuthority> authorities) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
		this.authorities = authorities;
	}
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	
}
