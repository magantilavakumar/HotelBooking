/**
 * 
 */
package com.booking.hotel.validators;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.MethodArgumentNotValidException;

import com.booking.hotel.beans.BookingDetails;
import com.booking.hotel.beans.CustomerDetails;
import com.booking.hotel.beans.RoomDetails;
import com.booking.hotel.exception.InvalidBookingDetailsException;
import com.booking.hotel.util.ErrorCode;

import lombok.extern.log4j.Log4j2;

/**
 * @author magantilavakumar
 *
 */
@Component
@Log4j2
public class BookingDetailsValidator implements Validator {

	@Autowired
	@Qualifier(value = "errorMessageSource")
	private MessageSource errorMessage;
	
	@Override
	public List<String> validate(Object obj) {
		List<String> lstErrors = new ArrayList<>();
		BookingDetails bookDet = (BookingDetails)obj;
		lstErrors.addAll(checkBookingDetails(bookDet));
		lstErrors.addAll(checkRoomDetails(bookDet.getRoomDetails()));
		lstErrors.addAll(checkCustomerDetails(bookDet.getCustomerDetails()));
		if(lstErrors.size()>0) {
			throw new InvalidBookingDetailsException(lstErrors);
		}
		return lstErrors;
	}
	
	protected List<String> checkBookingDetails(BookingDetails bookingDet){
		List<String> lstErrors = new ArrayList<>();
		
		if(bookingDet.getHotelID().isEmpty() || bookingDet.getHotelID().length()<3 || bookingDet.getHotelID().length()>10) {
			lstErrors.add(errorMessage.getMessage(ErrorCode.ERR_1001.getErrorDescription(), new Object[] {"HotelId"}, null));
		}
		if(bookingDet.getHotelName().isEmpty() || bookingDet.getHotelName().length()>30) {
			lstErrors.add(errorMessage.getMessage(ErrorCode.ERR_1001.getErrorDescription(), new Object[] {"HotelName"}, null));
		}
		if(bookingDet.getTotalAmount()<=0) {
			lstErrors.add(errorMessage.getMessage(ErrorCode.ERR_1001.getErrorDescription(), new Object[] {"TotalAmount"}, null));
		}		
		return lstErrors;
	}
	
	protected List<String> checkRoomDetails(RoomDetails roomDetails){
		List<String> lstErrors = new ArrayList<>();
		
		if(roomDetails.getRoomID().isEmpty() || roomDetails.getRoomID().length()<3 || roomDetails.getRoomID().length()>10) {
			lstErrors.add(errorMessage.getMessage(ErrorCode.ERR_1001.getErrorDescription(), new Object[] {"RoomId"}, null));
		}
		if(roomDetails.getRoomName().isEmpty() || roomDetails.getRoomName().length()>30) {
			lstErrors.add(errorMessage.getMessage(ErrorCode.ERR_1001.getErrorDescription(), new Object[] {"RoomName"}, null));
		}
		if(roomDetails.getNoOfGuests()<=0) {
			lstErrors.add(errorMessage.getMessage(ErrorCode.ERR_1001.getErrorDescription(), new Object[] {"NoOfGuests"}, null));
		}		
		return lstErrors;
	}
	
	protected List<String> checkCustomerDetails(CustomerDetails customerDetails){
		List<String> lstErrors = new ArrayList<>();
		
		if(customerDetails.getCustomerName().isEmpty() || customerDetails.getCustomerName().length()<3 || customerDetails.getCustomerName().length()>40) {
			lstErrors.add(errorMessage.getMessage(ErrorCode.ERR_1001.getErrorDescription(), new Object[] {"CustomerName"}, null));
		}
		if(customerDetails.getCustomerEmail().isEmpty() || customerDetails.getCustomerEmail().length()>30) {
			lstErrors.add(errorMessage.getMessage(ErrorCode.ERR_1001.getErrorDescription(), new Object[] {"CustomerEmail"}, null));
		}
		if(customerDetails.getCustomerMobileNumber().isEmpty() || customerDetails.getCustomerMobileNumber().length()<10 || customerDetails.getCustomerMobileNumber().length()>11) {
			lstErrors.add(errorMessage.getMessage(ErrorCode.ERR_1001.getErrorDescription(), new Object[] {"CustomerMobileNumber"}, null));
		}		
		return lstErrors;
	}

}
