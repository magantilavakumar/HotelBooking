package com.booking.hotel.beans;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.SecondaryTables;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
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
 * 
 */

/**
 * @author magantilavakumar
 *
 */

@Setter
@Getter 
@AllArgsConstructor 
@ToString
@NoArgsConstructor
@Log4j2
@Entity
@Table(name = "BookingDetails")
//@SecondaryTables({
//    @SecondaryTable(name="CustomerDetails",pkJoinColumns={
//    	      @PrimaryKeyJoinColumn(name="BookingNo", referencedColumnName="BookingNo")}),
//    @SecondaryTable(name="RoomDetails",pkJoinColumns={
//  	      @PrimaryKeyJoinColumn(name="BookingNo", referencedColumnName="BookingNo")})
//})
@ApiModel(value = "Store the Booking Details.")

public class BookingDetails {

	@JsonIgnore
	@Id
	@SequenceGenerator(name = "BOOKING_SEQ",sequenceName = "booking_seq_",initialValue = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BOOKING_SEQ")
	@Column(name = "BookingNo")
	private Long bookingNo;
	
	@ApiModelProperty(value = "Hotel ID")
	@Column(name = "HotelID")
	private String hotelID;
	
	@ApiModelProperty(value = "Hotel Name")
	@Column(name = "HotelName")
	private String hotelName;	
	
	@ApiModelProperty(value = "Check in Date ex: yyyy-MM-dd")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	@Column(name = "CheckinDate")
	private LocalDate checkinDate;
	
	@ApiModelProperty(value = "Check out Date ex: yyyy-MM-dd")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	@Column(name = "CheckoutDate")
	private LocalDate checkoutDate;
	
	@ApiModelProperty(value = "Customer Details name,email,number")
	@OneToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name="BookingNo",referencedColumnName = "BookingNo")
	@PrimaryKeyJoinColumn
	private CustomerDetails customerDetails;
	
	@ApiModelProperty(value = "Room Details room id,name,no of guests")
	@OneToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name="BookingNo",referencedColumnName = "BookingNo")
	@PrimaryKeyJoinColumn
	private RoomDetails roomDetails;
	
	@ApiModelProperty(value = "Final Amount")
	@Column(name = "TotalAmount")
	private Double totalAmount;

}
