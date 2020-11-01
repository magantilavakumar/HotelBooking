/**
 * 
 */
package com.booking.hotel.exception;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @author magantilavakumar
 *
 */
@Setter @Getter @AllArgsConstructor
public class InvalidBookingDetailsException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<String> lstOfErrors;
	

}
