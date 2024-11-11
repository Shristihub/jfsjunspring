package com.bookapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
 
import com.bookapp.model.ApiUser;

@Repository
public interface IApiUserRepository extends JpaRepository<ApiUser, Integer>{
	
	
	ApiUser findByEmail(String email);

}
