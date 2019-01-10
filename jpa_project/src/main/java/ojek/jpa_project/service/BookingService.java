package ojek.jpa_project.service;

import ojek.jpa_project.model.Booking;

import java.util.List;

public interface BookingService {
    List<Booking> getAllBooking();

    List<Booking> getAllBooking_byMember(String memberID);

    List<Booking> getAllBooking_byDriver(String driverID);

    List<Booking> getAllBooking_hasPaid();

    Booking getById(String id);

    Booking create(String memberID, Booking booking);

    Booking cancel(String id);

    Booking finish(String id);


}
