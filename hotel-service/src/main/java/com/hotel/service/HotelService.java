package com.hotel.service;

import java.util.List;

import com.hotel.model.Hotel;

public interface HotelService {

	Hotel create(Hotel hotel);
	
	List<Hotel> getAllHotel();
	
	Hotel getById(String hotelId);
}
