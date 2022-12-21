package com.rating.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rating.model.Rating;

@Repository
public interface RatingRepository extends JpaRepository<Rating, String> {
	//@Query(value = "SELECT r FROM Rating r where r.hotelId=1")
	public List<Rating> getByHotelId(String hotelId);
	
	//@Query(value = "SELECT r FROM Rating r where r.userId=1")
	public List<Rating> getByUserId(String userId);
	
}
