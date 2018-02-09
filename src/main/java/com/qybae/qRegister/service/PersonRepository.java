package com.qybae.qRegister.service;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.qybae.qRegister.entity.Person;

@RepositoryRestResource(collectionResourceRel = "person", path = "person")
public interface PersonRepository extends JpaRepository<Person, Long>{

	@Query("select u from Person u where u.email like %?1%")
	List<Person> findByEmail(@Param("email") String email);
	
	List<Person> findByPhoneLike (@Param("phone")String phone);
	
	List<Person> findByNameContainingOrderByNameDesc (@Param("name")String name);
	
	List<Person> findByEmailContainingOrderByNameDesc (@Param("email")String email);
	
	List<Person> findByEmailContainingAndNameContainingOrderByNameDesc (@Param("email")String email, @Param("name")String name );
} 



