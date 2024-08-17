package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.Mobile;

public interface MobileRepository extends JpaRepository<Mobile, Integer> {
	
	@Query(value="SELECT * FROM mobile WHERE brandname = :brandname", nativeQuery = true)
	List<Mobile> findMobileByBrandname(String brandname);
	
//	@Query(value="select distinct brandname from mobile", nativeQuery = true)
//	List<Mobile> findAllMobilesByUniqueBrand();
	
	@Query(value="select distinct brandname from mobile", nativeQuery = true)
	List<String> findAllMobilesByUniqueBrand();

}
