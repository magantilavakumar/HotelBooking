/**
 * 
 */
package com.booking.hotel.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.log4j.Log4j2;

/**
 * @author magantilavakumar
 *
 */

@Setter @Getter @AllArgsConstructor
@NoArgsConstructor
@ToString
@Log4j2
@Entity
@Table(name = "RoomDetails")
@ApiModel(value = "Store the Room Details.")
public class RoomDetails {

	
	@Id
	@JsonIgnore
	@Column(name = "BookingNo")
	private Long bookingNo;
	
	@ApiModelProperty(value = "Room Id")
	@Column(name = "RoomID")
	private String roomID;
	
	@ApiModelProperty(value = "Room Name")
	@Column(name = "RoomName")
	private String roomName;
	
	@ApiModelProperty(value = "No of Guests allowed")
	@Column(name = "NoOfGuest")
	private Integer noOfGuests;
	
}
