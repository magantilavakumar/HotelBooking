package com.booking.hotel.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
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


@Setter @Getter @AllArgsConstructor 
@NoArgsConstructor
@ToString
@Log4j2
@Entity
@Table(name = "CustomerDetails")
@ApiModel(value = "Store the Customer Details.")
public class CustomerDetails {

	
	@Id
	@JsonIgnore
	@Column(name = "BookingNo")
	private Long bookingNo;
	
	@ApiModelProperty(value = "Customer Name")
	@Column(name = "CustomerName")
	private String customerName;
	
	@ApiModelProperty(value = "Customer Email Ex: sample@xxx.com")
	@Column(name = "CustomerEmail")
	private String customerEmail;
	
	@ApiModelProperty(value = "Customer Number Ex: 01234567890")
	@Column(name = "CustomerMobileNumber")
	private String customerMobileNumber;
	

}
