package com.hotel.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.exception.ResourceNotFoundException;
import com.hotel.model.Hotel;
import com.hotel.repository.HotelRepository;

@Service
public class HotelServiceImpl implements HotelService {
	
	@Autowired
	HotelRepository hotelRepository;

	@Override
	public Hotel create(Hotel hotel) {
		String hotelId=UUID.randomUUID().toString();
		hotel.setHotelId(hotelId);
		return hotelRepository.save(hotel);
	}

	@Override
	public List<Hotel> getAllHotel() {
		
		return hotelRepository.findAll();
	}

	@Override
	public Hotel getById(String hotelId) {
		
		return hotelRepository.findById(hotelId).orElseThrow(()->new ResourceNotFoundException("Hotel With Given id not found..!"));
	}

}
