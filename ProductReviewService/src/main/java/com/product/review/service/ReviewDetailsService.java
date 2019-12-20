package com.product.review.service;

import java.util.List;

import com.product.review.entity.ReviewDetails;

public interface ReviewDetailsService {

	//ReviewDetails getReviewDetails(long reviewId) ;
	 public List<ReviewDetails> getReviewDetails(long productId) ;
	 
	//retrieve all data
	 public List<ReviewDetails> getAll();
}
