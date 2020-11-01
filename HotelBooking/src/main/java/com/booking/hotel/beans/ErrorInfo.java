/**
 * 
 */
package com.booking.hotel.beans;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * @author magantilavakumar
 *
 */

@Getter @Setter
@Builder
@ApiModel(value = "Store Error information")
public class ErrorInfo {
	@ApiModelProperty(value = "Store Error Message")
	private List<String> errorMessage;
	
	@ApiModelProperty(value = "Store Error Code")
	private Integer errorCode;
	
	@ApiModelProperty(value = "Store Error Time")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
	private LocalDateTime errorTime;
	
	

}
