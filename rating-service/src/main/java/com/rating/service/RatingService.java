package com.rating.service;

import java.util.List;

import com.rating.model.Rating;

public interface RatingService {
	public Rating createRating(Rating rating);
	public List<Rating> getAllRating();
	public List<Rating> getByHotelId(String hotelId);
	public  Rating getByRatingId(String ratingId);
	
	public List<Rating> getByUserId(String userId);
	
}
