package com.bookapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bookapp.model.ApiUser;


@Repository
public interface IApiUserRepository extends JpaRepository<ApiUser, Integer>{
	
	@Query(
			value="select au.username,au.password,au.email,au.user_id,r.roles from api_user au inner join apiuser_roles r on au.user_id=r.api_user_user_id where au.username=?1",
			nativeQuery = true
			
			)
	ApiUser findByUsername(String username);
}
