package com.booking.hotel.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.booking.hotel.beans.BookingDetails;

@Repository
public interface BookingDetailsRepo extends CrudRepository<BookingDetails, Long> {

}
