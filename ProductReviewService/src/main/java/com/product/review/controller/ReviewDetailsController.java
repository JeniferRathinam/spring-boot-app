package com.product.review.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.product.review.dao.ReviewRepository;
import com.product.review.dto.ReviewDTO;
import com.product.review.entity.ReviewDetails;
import com.product.review.service.ReviewDetailsService;



@RestController
public class ReviewDetailsController {

	
	@Autowired
	private ReviewDetailsService reviewDetailsService;
	
	@Autowired
	private EntityManager entityManager;
	
	List<ReviewDTO> rdtoList = new ArrayList<ReviewDTO>();
	
	
	@RequestMapping(value = "/reviewDetails/{productId}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<ReviewDTO> getReviewDetails(
			@PathVariable("productId") long productId) {
		
		System.out.println("From Controller : "+productId);
		
		
		
		entityManager.clear();
		
			try {
				List<ReviewDetails> reviewList = reviewDetailsService.getReviewDetails(productId);
				rdtoList.clear();
				
				for(int i=0;i<reviewList.size();i++) {
					ReviewDTO rd = new ReviewDTO();
					System.out.println(reviewList.get(i).getProductId()+""+reviewList.get(i).getReviewComment()+""+reviewList.get(i).getReviewer()+""+reviewList.get(i).getReviewId());
					
					rd.setProductId(reviewList.get(i).getProductId());
					rd.setReviewId(reviewList.get(i).getReviewId());
					rd.setReviewer(reviewList.get(i).getReviewer());
					rd.setReviewComment(reviewList.get(i).getReviewComment());
					System.out.println(i);
					rdtoList.add(rd); 
					
					
				}
				reviewList.clear();
		}
		catch (Exception e) {
			e.printStackTrace();
		}

			System.out.println("\n Final list");
			for(int i=0;i<rdtoList.size();i++) {
				System.out.println(rdtoList.get(i).getProductId()+""+rdtoList.get(i).getReviewComment()+""+rdtoList.get(i).getReviewer()+""+rdtoList.get(i).getReviewId());
				//BeanUtils.copyProperties(reviewList, rtoList);
			}
		return rdtoList;
	}
	
	//retrieve List of all review data
	@RequestMapping(value = "/reviewDetails", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<ReviewDTO> getAll()
	{
		try {
			List<ReviewDetails> reviewList = reviewDetailsService.getAll();
			rdtoList.clear();
			
			for(int i=0;i<reviewList.size();i++) {
				ReviewDTO rd = new ReviewDTO();
				//System.out.println(reviewList.get(i).getProductId()+""+reviewList.get(i).getReviewComment()+""+reviewList.get(i).getReviewer()+""+reviewList.get(i).getReviewId());
				
				rd.setProductId(reviewList.get(i).getProductId());
				rd.setReviewId(reviewList.get(i).getReviewId());
				rd.setReviewer(reviewList.get(i).getReviewer());
				rd.setReviewComment(reviewList.get(i).getReviewComment());
				
				rdtoList.add(rd); 
				
				
			}
			
			reviewList.clear();
	}
	catch (Exception e) {
		e.printStackTrace();
	}

		
	return rdtoList;
	}
	
	
}
