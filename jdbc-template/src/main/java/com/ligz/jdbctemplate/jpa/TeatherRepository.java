package com.ligz.jdbctemplate.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * author:ligz
 */
public interface TeatherRepository extends JpaRepository<Teather, Long> {
	Teather findByName(String name);

	Teather findByNameAndAge(String name, Integer age);

	@Query("from Teather t where t.name=:name")
	Teather findTeather(@Param("name") String name);

}
