package com.codered.main;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRegRepository extends CrudRepository<UserRegistration, Integer>
{
	public List<UserRegistration> findAll();
	
}
