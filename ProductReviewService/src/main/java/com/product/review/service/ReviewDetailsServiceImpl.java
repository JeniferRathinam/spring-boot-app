package com.product.review.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.review.dao.ReviewRepository;
import com.product.review.entity.ReviewDetails;

@Service
public class ReviewDetailsServiceImpl implements ReviewDetailsService{

	@Autowired
	private ReviewRepository reviewRepository;

		 
	@Override
	public List<ReviewDetails> getReviewDetails(long productId) {
		
		System.out.println("From ReviewDetailsServiceImpl : "+productId);
		 
		 
		List<ReviewDetails> rList  = (List<ReviewDetails>) reviewRepository.findByProductId(productId); 
	  return rList; 
	}
	
	@Override
	public List<ReviewDetails> getAll(){
		
		List<ReviewDetails> reviewList = (List<ReviewDetails>)reviewRepository.findAll();
		return reviewList;
		
	}

}
