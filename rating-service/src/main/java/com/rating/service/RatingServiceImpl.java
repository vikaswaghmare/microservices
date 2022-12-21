package com.rating.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.rating.exception.ResourceNotFoundException;
import com.rating.model.Rating;
import com.rating.repository.RatingRepository;


@Service
public class RatingServiceImpl implements RatingService{
	
	@Autowired
	RatingRepository ratingRepo;
	
	@Override
	public Rating createRating(Rating rating) {
		String ratingId=UUID.randomUUID().toString();
		rating.setRatingId(ratingId);
		return ratingRepo.save(rating);
	}

	@Override
	public List<Rating> getAllRating() {
		 
		return ratingRepo.findAll();
	}

	@Override
	public Rating getByRatingId(String ratingId) {
		
		return ratingRepo.findById(ratingId).orElseThrow(()->new ResourceNotFoundException("Rating with given id not found...!"));
	}

	@Override
	public List<Rating> getByHotelId(String hotelId) {
	 
		return ratingRepo.getByUserId(hotelId);
	}

	@Override
	public  List<Rating> getByUserId(String userId) {
				 
		return ratingRepo.getByUserId(userId);
	}
}
