package com.rating.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rating.model.Rating;
import com.rating.service.RatingService;

@RestController
@RequestMapping("/api/v1")
public class RatingController {
	@Autowired
	private RatingService ratingService;

	@PostMapping("/create")
	public ResponseEntity<Rating> createRating(@RequestBody  Rating rating) {
		
		return ResponseEntity.status(HttpStatus.CREATED).body(ratingService.createRating(rating));
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Rating>> getAllRatings() {
		
		return ResponseEntity.ok(ratingService.getAllRating());
	}
	
	@GetMapping("/rating/{ratingId}")
	public ResponseEntity<Rating> getByRatingId(@PathVariable String ratingId) {
		System.out.println("ratingId: "+ratingId);
		return ResponseEntity.ok(ratingService.getByRatingId(ratingId));
	}
	@GetMapping("/hotel/{hotelId}")
	public ResponseEntity<List<Rating>> getByHotelId(@PathVariable String hotelId) {
		System.out.println("hotelId: "+hotelId);
		return ResponseEntity.ok(ratingService.getByHotelId(hotelId));
	}
	
	@GetMapping("/user/{userId}")
	public ResponseEntity<List<Rating>> getByUserId(@PathVariable String userId) {
		System.out.println("userId: "+userId);
		return ResponseEntity.ok(ratingService.getByUserId(userId));
	}
}
