package com.booking.hotel.validators;

import java.util.List;

import io.swagger.annotations.Api;

@Api(value = "Validator Interface")
public interface Validator {
	
	List<String> validate(Object obj);

}
