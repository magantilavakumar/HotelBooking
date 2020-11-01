/**
 * 
 */
package com.booking.hotel.exception;

import java.time.LocalDateTime;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.booking.hotel.beans.ErrorInfo;
import com.booking.hotel.util.ErrorCode;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @author magantilavakumar	
 *
 */
	
@ControllerAdvice
@Api(value = "Customized Global Exception Handler")
public class ResponseCustomEntityExceptionHandler extends ResponseEntityExceptionHandler {
	
	@Autowired
	@Qualifier(value = "errorMessageSource")
	private MessageSource messageSource;
	
	@Override
	@ApiOperation(value = "Handles Incorrect input format Exceptions")
	protected ResponseEntity<Object> handleHttpMessageNotReadable(
			HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		ErrorInfo errInfo = ErrorInfo.builder()
				.errorCode(HttpStatus.NOT_ACCEPTABLE.value())
				.errorMessage(Arrays.asList(new String[] {ErrorCode.ERR_1000.getErrorDescription()}))
				.errorTime(LocalDateTime.now())
				.build();
		return new ResponseEntity<>(errInfo,HttpStatus.NOT_ACCEPTABLE);
	}	
	
	@Override
	@ApiOperation(value = "Handles Other Writable Exceptions")
	protected ResponseEntity<Object> handleHttpMessageNotWritable(
			HttpMessageNotWritableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

		ErrorInfo errInfo = ErrorInfo.builder()
				.errorCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
				.errorMessage(Arrays.asList(new String[] {ErrorCode.ERR_1000.getErrorDescription()}))
				.errorTime(LocalDateTime.now())
				.build();
		return new ResponseEntity<>(errInfo,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ApiOperation(value = "Handles Incorrect fields which not follow input rules")
	@ExceptionHandler(value = InvalidBookingDetailsException.class)
	protected ResponseEntity<Object> handleInvalidBookingDetails(InvalidBookingDetailsException ibdException)			{
		ErrorInfo errInfo = ErrorInfo.builder()
				.errorCode(HttpStatus.NOT_ACCEPTABLE.value())
				.errorMessage(ibdException.getLstOfErrors())
				.errorTime(LocalDateTime.now())
				.build();
		return new ResponseEntity<>(errInfo,HttpStatus.NOT_ACCEPTABLE);
	}	
}
