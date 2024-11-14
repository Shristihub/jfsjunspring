package com.bookapp.model;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
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
	@ElementCollection(fetch=FetchType.EAGER)
	@JoinTable(name="apiuser_roles")
	private Set<String> roles;
	public ApiUser(String username, String email, String password, Set<String> roles) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
		this.roles = roles;
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
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// convert Set<String> roles to Set<GrantedAuthority> roles
//		Set<GrantedAuthority> authorities = new HashSet<>();
//		for(String role:roles) {
//			GrantedAuthority gauth = new SimpleGrantedAuthority(role);
//			authorities.add(gauth);
//		}
		
		return roles.stream()
				.map(role -> new SimpleGrantedAuthority(role))
				.collect(Collectors.toSet());
	}
	
	
	
	
}
