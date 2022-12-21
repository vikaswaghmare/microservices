package com.user.serivce;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.user.exception.ResourNotFoundException;
import com.user.external.service.HotelService;
import com.user.model.Hotel;
import com.user.model.Rating;
import com.user.model.User;
import com.user.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	RestTemplate restTemplate;

	@Autowired
	HotelService hotelService;

	private Logger logger = LoggerFactory.getLogger(UserService.class);

	@Override
	public User saveUser(User user) {
		String userId = UUID.randomUUID().toString();
		user.setUserId(userId);
		return userRepository.save(user);
	}

	@Override
	public List<User> getAllUsers() {

		return userRepository.findAll();
	}

	@Override
	public User getByUserId(String userId) {
		// TODO Auto-generated method stub
		User user = userRepository.findById(userId).orElseThrow(() -> new ResourNotFoundException());

		Rating[] userRatings = restTemplate.getForObject("http://RATING-SERVICE/api/v1/user/" + user.getUserId(),
				Rating[].class);

		List<Rating> ratings = Arrays.stream(userRatings).collect(Collectors.toList());

		List<Rating> ratingList = ratings.stream().map(rating -> {
			Hotel hotel = hotelService.getHotel(rating.getHotelId());
					//restTemplate.getForEntity("http://HOTEL-SERVICE/hotel/" + rating.getHotelId(), Hotel.class)
					//.getBody();
			rating.setHotel(hotel);
			return rating;
		}).collect(Collectors.toList());
		user.setRatings(ratingList);

		return user;
	}

}
