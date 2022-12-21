package com.user.external.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.user.model.Hotel;
@Service
@FeignClient(name="HOTEL-SERVICE")
public interface HotelService {
	
	@GetMapping("/hotel/{hotelId}")
	public Hotel getHotel(@PathVariable String hotelId);

}
