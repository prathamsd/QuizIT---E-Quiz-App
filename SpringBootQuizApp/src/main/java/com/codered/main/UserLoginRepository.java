package com.codered.main;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserLoginRepository extends CrudRepository<UserLogin, Integer> 
{
	public List<UserLogin> findAll();
}
