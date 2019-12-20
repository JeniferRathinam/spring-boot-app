package com.product.review.dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.product.review.entity.ReviewDetails;



/*
 * public interface ReviewRepository extends JpaRepository<ReviewDetails,Long> {
 * 
 * 
 * ReviewDetails findByProductId(long productId);
 * 
 * }
 */

public interface ReviewRepository extends CrudRepository<ReviewDetails,Long> {

	List<ReviewDetails> findByProductId(long productId);
	
	List<ReviewDetails> findAll();
	//public List<ReviewDetails> findByProductId(long productId);
	
	
}
