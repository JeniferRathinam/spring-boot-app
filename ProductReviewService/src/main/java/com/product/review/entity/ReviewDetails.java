package com.product.review.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="ReviewDetails")
@NamedQuery(name="ReviewDetails.findAll", query="SELECT rd FROM ReviewDetails rd")
public class ReviewDetails {
	
	@Id
	@Column(name="reviewId")
	private long reviewId; //primary key
	
	
	/*
	 * @ManyToOne
	 * 
	 * @JoinColumn(name ="productId")*/
	@Column(name="productId")
	 private long productId; //foreign key
	
	@Column(name="reviewComment")
	private String reviewComment;	
	
	@Column(name="reviewer")
	private String reviewer;
	
	
	public long getReviewId() {
		return reviewId;
	}
	public void setReviewId(long reviewId) {
		this.reviewId = reviewId;
	}
	public long getProductId() {
		return productId;
	}
	public void setProductId(long productId) {
		this.productId = productId;
	}
	public String getReviewComment() {
		return reviewComment;
	}
	public void setReviewComment(String reviewComment) {
		this.reviewComment = reviewComment;
	}
	public String getReviewer() {
		return reviewer;
	}
	public void setReviewer(String reviewer) {
		this.reviewer = reviewer;
	}
	
	
}
