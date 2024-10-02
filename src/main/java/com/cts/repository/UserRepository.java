package com.cts.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cts.dto.UserDbRespDto;
import com.cts.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	List<User> findByName(String name);

	List<User> findByNameContains(String name, Pageable page);

	List<User> findByNameContainsOrderByNameAsc(String name, Pageable page);

	List<User> findByNameAndAge(String name, int age);

	// @Query("select u from User u where u.name = :name")
	@Query(value = "select u.* from User u where u.name = : name", nativeQuery = true)
	List<User> getUserByName(@Param("name") String name);

	List<User> findByNameContainsOrEmailContainsOrderByNameDesc(String name, String email);

	List<User> findByNameContainsAndEmailContainsOrderByNameDesc(String name, String email);

	List<User> findByNameContainsAndEmailOrderByNameDesc(String name, String email);
	
	List<User> findByAgeGreaterThanEqual(int age);
	
	List<User> findByNameStartingWith(String name);
	
	/*
	 * @Query("select com.hcl") List<UserDbRespDto> getCustomUserData(@Param("name")
	 * String name);
	 */

}
