package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Booking;
import com.example.demo.repositories.BookingRepository;


@RestController
public class BookingController {
	@Autowired
    private BookingRepository bookingRepository;
	
	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	@GetMapping("/bookings")
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }
	
//	@GetMapping("/bookingss")
//    public List<Booking> getAllBookingss() {
//        String sql = "SELECT * FROM BOOKING ORDER BY bookingNO DESC";
//        List<Booking> bookings = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Booking.class));
//        return bookings;
//    }
	
	@PostMapping("/bookings/post")
    public Booking createBookings(@RequestBody Booking booking) {
        return bookingRepository.save(booking);
    }
}
