package com.booking.hotel.controllers;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.booking.hotel.beans.BookingDetails;
import com.booking.hotel.repositories.BookingDetailsRepo;
import com.booking.hotel.validators.BookingDetailsValidator;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("/booking")
@Api("Endpoints provided for Creating Booking")
@Log4j2
public class RoomBookingController{
	
	
	@Autowired
	private BookingDetailsValidator bookingDetailValidate;
	
	@Autowired
	private BookingDetailsRepo bookingDetailsRepo;
	
	@PostMapping(value = "/save",produces = "application/json")
	@ApiOperation(value = "Submit for Creating Booking")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 400, message = "There is error among the data being parse in to system"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
			@ApiResponse(code = 500, message = "Internal Server Error")
	})
	public ResponseEntity<String> saveBooking(@RequestBody BookingDetails bookingDetails) {
		log.info(bookingDetails.toString());
		
		bookingDetailValidate.validate(bookingDetails);

	
		bookingDetailsRepo.save(bookingDetails);
		
		
		return new ResponseEntity<String>(HttpStatus.OK);
	}
}
