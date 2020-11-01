package com.booking.hotel.util;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author magantilavakumar
 *
 */
@Getter @AllArgsConstructor
@ApiModel(value = "Enum for storing error codes ")
public enum ErrorCode {
	ERR_1000("ERROR.INVALID_FIELD_FORMAT"),ERR_1001("ERROR.INVALID_FIELD_VALUE");
	
	@ApiModelProperty(value = "Error Decription")
	private String errorDescription;
	
		
}
